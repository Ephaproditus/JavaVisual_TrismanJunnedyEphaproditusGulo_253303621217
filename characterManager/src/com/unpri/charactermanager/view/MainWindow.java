package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class MainWindow extends JFrame {
    private final CharacterManager manager;
    private final JPanel characterListPanel;
    private final JLabel totalLabel;
    private final JLabel avgLabel;
    private final JLabel statusMsgLabel;

    private static final Color[] CARD_COLORS = {
            new Color(230, 242, 255),
            new Color(232, 245, 233),
            new Color(255, 243, 224),
            new Color(243, 229, 245)
    };

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Multi-Color Cards");
        setSize(580, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        JLabel headerLabel = new JLabel("CHARACTER MANAGER", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        headerLabel.setForeground(new Color(41, 64, 82));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(18, 10, 12, 10));
        add(headerLabel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));
        characterListPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(8, 8));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));

        JPanel statsPanel = new JPanel(new GridLayout(1, 2));
        statsPanel.setBackground(Color.WHITE);
        totalLabel = new JLabel("Total Karakter: 0");
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        avgLabel = new JLabel("Rata-rata Level: 0.00", SwingConstants.RIGHT);
        avgLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        statsPanel.add(totalLabel);
        statsPanel.add(avgLabel);
        bottomPanel.add(statsPanel, BorderLayout.NORTH);

        statusMsgLabel = new JLabel("Aplikasi siap digunakan", SwingConstants.CENTER);
        statusMsgLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        statusMsgLabel.setForeground(Color.WHITE);
        statusMsgLabel.setOpaque(true);
        statusMsgLabel.setBackground(new Color(53, 89, 142));
        statusMsgLabel.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        bottomPanel.add(statusMsgLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshView();
    }

    public void refreshView() {
        characterListPanel.removeAll();
        List<Character> characters = manager.getAllCharacters();

        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);
            JPanel card = new JPanel(new BorderLayout(8, 2));
            card.setBackground(getCardColor(character.getType(), i));
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200)),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            ));
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 72));

            JPanel infoPanel = new JPanel(new GridLayout(2, 1, 0, 3));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(character.getName());
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

            JLabel detailLabel = new JLabel(String.format(
                    "Level: %d  |  HP: %d  |  ATK: %d  |  Mana: %d",
                    character.getLevel(),
                    character.getHitPoints(),
                    character.getAttackPower(),
                    character.getMana()
            ));
            detailLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
            infoPanel.add(nameLabel);
            infoPanel.add(detailLabel);
            card.add(infoPanel, BorderLayout.CENTER);

            JLabel aliveLabel = new JLabel(character.isAlive() ? "ALIVE" : "DEFEATED");
            aliveLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
            aliveLabel.setForeground(character.isAlive() ? new Color(35, 120, 65) : Color.RED);
            card.add(aliveLabel, BorderLayout.EAST);

            characterListPanel.add(card);
            characterListPanel.add(Box.createRigidArea(new Dimension(0, 6)));
        }

        totalLabel.setText("Total Karakter: " + manager.getTotalCharacters());
        avgLabel.setText(String.format("Rata-rata Level: %.2f", manager.getAverageLevel()));
        statusMsgLabel.setText("Daftar karakter berhasil diperbarui");
        characterListPanel.revalidate();
        characterListPanel.repaint();
    }

    private Color getCardColor(CharacterType type, int index) {
        switch (type) {
            case WARRIOR:
                return CARD_COLORS[0];
            case MAGE:
                return CARD_COLORS[3];
            case ARCHER:
                return CARD_COLORS[1];
            case HEALER:
                return CARD_COLORS[2];
            default:
                return CARD_COLORS[index % CARD_COLORS.length];
        }
    }
}