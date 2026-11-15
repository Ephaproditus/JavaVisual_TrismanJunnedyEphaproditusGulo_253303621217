package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class MainWindow extends JFrame {
    // Konstanta bernama untuk batas level highlight emas (Bagian B)
    private static final int HIGH_LEVEL_THRESHOLD = 5;
    private static final int ROOKIE_LEVEL = 1;

    private final CharacterManager manager;
    private final JPanel characterListPanel;
    private final JLabel totalLabel;
    private final JLabel avgLabel;
    private final JLabel statusMsgLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        // 1. Konfigurasi Jendela
        setTitle("Character Manager TP10 - v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        getContentPane().setBackground(AppTheme.BG_WINDOW);

        // 2. Header Judul
        JLabel headerLabel = new JLabel("CHARACTER MANAGER", SwingConstants.CENTER);
        headerLabel.setFont(AppTheme.FONT_TITLE);
        headerLabel.setForeground(AppTheme.TEXT_PRIMARY);
        headerLabel.setBorder(AppTheme.BORDER_HEADER);
        add(headerLabel, BorderLayout.NORTH);

        // 3. Panel Daftar Karakter Dinamis
        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));
        characterListPanel.setBackground(AppTheme.BG_WINDOW);

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setBorder(AppTheme.BORDER_SCROLL);
        scrollPane.getViewport().setBackground(AppTheme.BG_WINDOW);
        scrollPane.setPreferredSize(new Dimension(540, 390));
        add(scrollPane, BorderLayout.CENTER);

        // 4. Panel Bagian Bawah
        JPanel bottomContainer = new JPanel();
        bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
        bottomContainer.setBackground(AppTheme.BG_WINDOW);
        bottomContainer.setBorder(AppTheme.BORDER_BOTTOM);

        JPanel statsPanel = new JPanel(new GridLayout(1, 2));
        statsPanel.setBackground(AppTheme.BG_WINDOW);
        statsPanel.setBorder(AppTheme.BORDER_STATS);

        totalLabel = new JLabel("Total Karakter: 0");
        totalLabel.setFont(AppTheme.FONT_STATS);
        totalLabel.setForeground(AppTheme.TEXT_PRIMARY);

        avgLabel = new JLabel("Rata-rata Level: 0.00", SwingConstants.RIGHT);
        avgLabel.setFont(AppTheme.FONT_STATS);
        avgLabel.setForeground(AppTheme.TEXT_PRIMARY);

        statsPanel.add(totalLabel);
        statsPanel.add(avgLabel);
        bottomContainer.add(statsPanel);

        statusMsgLabel = new JLabel("Tema v0.4 berhasil diterapkan", SwingConstants.CENTER);
        statusMsgLabel.setFont(AppTheme.FONT_STATUS);
        statusMsgLabel.setForeground(AppTheme.STATUS_BAR_FG);
        statusMsgLabel.setOpaque(true);
        statusMsgLabel.setBackground(AppTheme.STATUS_BAR_BG);
        statusMsgLabel.setBorder(AppTheme.BORDER_STATUS_MSG);
        statusMsgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomContainer.add(statusMsgLabel);

        add(bottomContainer, BorderLayout.SOUTH);

        // Render data dan atur ukuran otomatis dengan pack()
        refreshView();
        pack();
        setLocationRelativeTo(null);
    }

    public void refreshView() {
        characterListPanel.removeAll();
        List<Character> characters = manager.getAllCharacters();

        for (Character c : characters) {
            JPanel card = new JPanel(new BorderLayout(8, 2));
            card.setOpaque(true); // Wajib agar warna background tampil
            card.setBackground(AppTheme.colorFor(c.getType()));
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 64));

            boolean isHighLevel = c.getLevel() >= HIGH_LEVEL_THRESHOLD;
            boolean isRookie = c.getLevel() == ROOKIE_LEVEL;

            card.setBorder(isHighLevel ? AppTheme.BORDER_CARD_HIGH_LEVEL : AppTheme.BORDER_CARD);

            // Properti Tambahan 1: Tooltip berisi statistik lengkap saat hover
            card.setToolTipText(String.format(
                    "Nama: %s | Role: %s | Level: %d | HP: %d | ATK: %d | Mana: %d",
                    c.getName(), c.getType(), c.getLevel(), c.getHitPoints(), c.getAttackPower(), c.getMana()
            ));

            // Panel Kiri: Nama & Detail
            JPanel infoPanel = new JPanel(new GridLayout(2, 1, 0, 2));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(c.getName());
            // Mini-Challenge: Level >= 5 berwarna emas dan tebal
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

            // Panel Kanan: Status
            JLabel statusLabel = new JLabel(isRookie ? "ROOKIE (LV.1)" : "ALIVE");
            statusLabel.setFont(AppTheme.FONT_STATUS);
            statusLabel.setForeground(isHighLevel ? AppTheme.GOLD_HIGHLIGHT : AppTheme.TEXT_MUTED);
            card.add(statusLabel, BorderLayout.EAST);

            // Properti Tambahan 2: setEnabled(false) pada label jika karakter masih level 1
            if (isRookie) {
                nameLabel.setEnabled(false);
                detailLabel.setEnabled(false);
                statusLabel.setEnabled(false);
            }

            characterListPanel.add(card);
        }

        int total = manager.getTotalCharacters();
        double avg = manager.getAverageLevel();
        totalLabel.setText("Total Karakter: " + total);
        avgLabel.setText(String.format("Rata-rata Level: %.2f", avg));

        if (total > 0) {
            statusMsgLabel.setText(characters.get(characters.size() - 1).getName() + " Berhasil Ditambahkan");
        }

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}