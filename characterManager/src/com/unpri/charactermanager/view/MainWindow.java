package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class MainWindow extends JFrame {
    private static final int HIGH_LEVEL_THRESHOLD = 5;
    private static final int ROOKIE_LEVEL = 1;
    private static final String APP_VERSION = "v0.5";

    private final CharacterManager manager;
    private final JPanel cardsGridPanel;
    private final JLabel totalCharStatLabel;
    private final JLabel avgLevelStatLabel;
    private final JLabel eliteCountStatLabel;
    private final JLabel highestHpStatLabel;
    private final JLabel statusLeftLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        // 1. Konfigurasi Jendela Utama (BorderLayout)
        setTitle("Character Manager TP12 - " + APP_VERSION);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));
        getContentPane().setBackground(AppTheme.BG_WINDOW);

        // 2. WILAYAH NORTH: Header + Panel Tambahan Statistik (GridLayout 2x2)
        JPanel northContainer = new JPanel(new BorderLayout());
        northContainer.setBackground(AppTheme.BG_WINDOW);

        JLabel headerLabel = new JLabel("CHARACTER MANAGER", SwingConstants.CENTER);
        headerLabel.setFont(AppTheme.FONT_TITLE);
        headerLabel.setForeground(AppTheme.TEXT_PRIMARY);
        headerLabel.setBorder(AppTheme.BORDER_HEADER);
        northContainer.add(headerLabel, BorderLayout.NORTH);

        // Panel Tambahan Pilihan (Bagian B): GridLayout 2x2 untuk 4 ringkasan statistik
        JPanel statsGridPanel = new JPanel(new GridLayout(2, 2, 12, 4));
        statsGridPanel.setBackground(AppTheme.BG_PANEL_SUBTLE);
        statsGridPanel.setBorder(AppTheme.BORDER_STATS_GRID);

        totalCharStatLabel = new JLabel("Total Karakter: 0");
        totalCharStatLabel.setFont(AppTheme.FONT_STATS);
        totalCharStatLabel.setForeground(AppTheme.TEXT_PRIMARY);

        avgLevelStatLabel = new JLabel("Rata-rata Level: 0.00", SwingConstants.RIGHT);
        avgLevelStatLabel.setFont(AppTheme.FONT_STATS);
        avgLevelStatLabel.setForeground(AppTheme.TEXT_PRIMARY);

        eliteCountStatLabel = new JLabel("Karakter Elite (Lv>=5): 0");
        eliteCountStatLabel.setFont(AppTheme.FONT_STATS);
        eliteCountStatLabel.setForeground(AppTheme.GOLD_HIGHLIGHT);

        highestHpStatLabel = new JLabel("HP Tertinggi: 0", SwingConstants.RIGHT);
        highestHpStatLabel.setFont(AppTheme.FONT_STATS);
        highestHpStatLabel.setForeground(AppTheme.TEXT_PRIMARY);

        statsGridPanel.add(totalCharStatLabel);
        statsGridPanel.add(avgLevelStatLabel);
        statsGridPanel.add(eliteCountStatLabel);
        statsGridPanel.add(highestHpStatLabel);

        northContainer.add(statsGridPanel, BorderLayout.SOUTH);
        add(northContainer, BorderLayout.NORTH);

        // 3. WILAYAH CENTER: Daftar Karakter Berscroll
        // Panel pembungkus dengan BorderLayout agar grid kartu menempel di NORTH (tidak melar vertikal saat resize)
        JPanel scrollWrapperPanel = new JPanel(new BorderLayout());
        scrollWrapperPanel.setBackground(AppTheme.BG_WINDOW);

        cardsGridPanel = new JPanel(new GridLayout(0, 1, 0, 6));
        cardsGridPanel.setBackground(AppTheme.BG_WINDOW);
        scrollWrapperPanel.add(cardsGridPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(scrollWrapperPanel);
        scrollPane.setBorder(AppTheme.BORDER_SCROLL);
        scrollPane.getViewport().setBackground(AppTheme.BG_WINDOW);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(520, 410));
        add(scrollPane, BorderLayout.CENTER);

        // 4. WILAYAH EAST: Legenda Role dengan BoxLayout Y_AXIS
        JPanel legendPanel = buildLegendPanel();
        add(legendPanel, BorderLayout.EAST);

        // 5. WILAYAH SOUTH: Bar Status (Teks di Kiri, "v0.5" di Kanan)
        JPanel statusBarPanel = new JPanel(new BorderLayout());
        statusBarPanel.setBackground(AppTheme.STATUS_BAR_BG);
        statusBarPanel.setBorder(AppTheme.BORDER_STATUS_BAR);

        statusLeftLabel = new JLabel("Siap menampilkan daftar karakter");
        statusLeftLabel.setFont(AppTheme.FONT_STATUS);
        statusLeftLabel.setForeground(AppTheme.STATUS_BAR_FG);

        JLabel versionRightLabel = new JLabel(APP_VERSION, SwingConstants.RIGHT);
        versionRightLabel.setFont(AppTheme.FONT_STATUS);
        versionRightLabel.setForeground(AppTheme.STATUS_BAR_FG);

        statusBarPanel.add(statusLeftLabel, BorderLayout.WEST);
        statusBarPanel.add(versionRightLabel, BorderLayout.EAST);
        add(statusBarPanel, BorderLayout.SOUTH);

        // Render data dan atur ukuran awal dengan pack()
        refreshView();
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Membangun panel legenda role menggunakan BoxLayout Y_AXIS, strut, dan glue
     * yang diturunkan secara otomatis dari CharacterType.values()
     */
    private JPanel buildLegendPanel() {
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS));
        legendPanel.setBackground(AppTheme.BG_PANEL_SUBTLE);
        legendPanel.setBorder(AppTheme.BORDER_LEGEND_PANEL);

        JLabel legendTitle = new JLabel("LEGENDA ROLE");
        legendTitle.setFont(AppTheme.FONT_SUBTITLE);
        legendTitle.setForeground(AppTheme.TEXT_PRIMARY);
        legendTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(12));

        // Iterasi otomatis dari enum CharacterType.values()
        for (CharacterType type : CharacterType.values()) {
            JLabel itemLabel = new JLabel(type.name());
            itemLabel.setFont(AppTheme.FONT_LEGEND);
            itemLabel.setForeground(AppTheme.TEXT_PRIMARY);
            itemLabel.setOpaque(true);
            itemLabel.setBackground(AppTheme.colorFor(type));
            itemLabel.setBorder(AppTheme.BORDER_LEGEND_ITEM);
            itemLabel.setMaximumSize(new Dimension(130, 32));
            itemLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            legendPanel.add(itemLabel);
            legendPanel.add(Box.createVerticalStrut(8));
        }

        // Glue mendorong seluruh item legenda merapat ke atas saat jendela dipertinggi
        legendPanel.add(Box.createVerticalGlue());

        JLabel noteLabel = new JLabel("<html><i>*Emas = Level &ge; 5</i></html>");
        noteLabel.setFont(AppTheme.FONT_DETAIL);
        noteLabel.setForeground(AppTheme.GOLD_HIGHLIGHT);
        noteLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        legendPanel.add(noteLabel);

        return legendPanel;
    }

    public void refreshView() {
        cardsGridPanel.removeAll();
        List<Character> characters = manager.getAllCharacters();

        int eliteCount = 0;
        int maxHp = 0;

        for (Character c : characters) {
            if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) eliteCount++;
            if (c.getHitPoints() > maxHp) maxHp = c.getHitPoints();

            JPanel card = new JPanel(new BorderLayout(8, 2));
            card.setOpaque(true);
            card.setBackground(AppTheme.colorFor(c.getType()));

            boolean isHighLevel = c.getLevel() >= HIGH_LEVEL_THRESHOLD;
            boolean isRookie = c.getLevel() == ROOKIE_LEVEL;

            card.setBorder(isHighLevel ? AppTheme.BORDER_CARD_HIGH_LEVEL : AppTheme.BORDER_CARD);
            card.setToolTipText(String.format(
                    "Nama: %s | Role: %s | Level: %d | HP: %d | ATK: %d | Mana: %d",
                    c.getName(), c.getType(), c.getLevel(), c.getHitPoints(), c.getAttackPower(), c.getMana()
            ));

            JPanel infoPanel = new JPanel(new GridLayout(2, 1, 0, 2));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(c.getName());
            if (isHighLevel) {
                nameLabel.setFont(AppTheme.FONT_NAME_ELITE);
                nameLabel.setForeground(AppTheme.GOLD_HIGHLIGHT);
            } else {
                nameLabel.setFont(AppTheme.FONT_NAME_REGULAR);
                nameLabel.setForeground(AppTheme.TEXT_PRIMARY);
            }

            JLabel detailLabel = new JLabel(String.format(
                    "Role: %s  |  Level: %d  |  HP: %d  |  ATK: %d",
                    c.getType(), c.getLevel(), c.getHitPoints(), c.getAttackPower()
            ));
            detailLabel.setFont(AppTheme.FONT_DETAIL);
            detailLabel.setForeground(AppTheme.TEXT_MUTED);

            infoPanel.add(nameLabel);
            infoPanel.add(detailLabel);
            card.add(infoPanel, BorderLayout.CENTER);

            JLabel statusLabel = new JLabel(isRookie ? "ROOKIE" : "ALIVE");
            statusLabel.setFont(AppTheme.FONT_STATUS);
            statusLabel.setForeground(isHighLevel ? AppTheme.GOLD_HIGHLIGHT : AppTheme.TEXT_MUTED);
            card.add(statusLabel, BorderLayout.EAST);

            if (isRookie) {
                nameLabel.setEnabled(false);
                detailLabel.setEnabled(false);
                statusLabel.setEnabled(false);
            }

            cardsGridPanel.add(card);
        }

        int total = manager.getTotalCharacters();
        double avg = manager.getAverageLevel();

        totalCharStatLabel.setText("Total Karakter: " + total);
        avgLevelStatLabel.setText(String.format("Rata-rata Level: %.2f", avg));
        eliteCountStatLabel.setText("Karakter Elite (Lv>=5): " + eliteCount);
        highestHpStatLabel.setText("HP Tertinggi: " + maxHp);

        if (total > 0) {
            statusLeftLabel.setText(characters.get(characters.size() - 1).getName() + " Berhasil Ditambahkan");
        }

        cardsGridPanel.revalidate();
        cardsGridPanel.repaint();
    }
}