package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AppTheme {
    // 1. Konstanta Warna Dasar & Aksen
    public static final Color BG_WINDOW = Color.WHITE;
    public static final Color TEXT_PRIMARY = new Color(35, 45, 55);
    public static final Color TEXT_MUTED = new Color(95, 105, 115);
    public static final Color GOLD_HIGHLIGHT = new Color(184, 134, 11);
    public static final Color STATUS_BAR_BG = new Color(53, 89, 142);
    public static final Color STATUS_BAR_FG = Color.WHITE;

    // 2. Warna Kartu Berdasarkan Role
    private static final Color ROLE_WARRIOR_BG = new Color(255, 175, 175);
    private static final Color ROLE_MAGE_BG = new Color(220, 180, 255);
    private static final Color ROLE_ARCHER_BG = new Color(135, 206, 250);
    private static final Color ROLE_HEALER_BG = new Color(152, 251, 152);
    private static final Color ROLE_DEFAULT_BG = new Color(245, 247, 250);

    // 3. Konstanta Font
    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font FONT_NAME_REGULAR = new Font(Font.SANS_SERIF, Font.BOLD, 13);
    public static final Font FONT_NAME_ELITE = FONT_NAME_REGULAR.deriveFont(Font.BOLD, 14f);
    public static final Font FONT_DETAIL = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font FONT_STATS = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    public static final Font FONT_STATUS = new Font(Font.SANS_SERIF, Font.BOLD, 12);

    // 4. Konstanta Border
    public static final Border BORDER_HEADER = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(200, 210, 220)),
            BorderFactory.createEmptyBorder(10, 0, 10, 0)
    );
    public static final Border BORDER_SCROLL = BorderFactory.createLineBorder(new Color(220, 225, 230), 1);
    public static final Border BORDER_BOTTOM = BorderFactory.createEmptyBorder(6, 8, 8, 8);
    public static final Border BORDER_STATS = BorderFactory.createEmptyBorder(6, 6, 6, 6);
    public static final Border BORDER_STATUS_MSG = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(35, 70, 120)),
            BorderFactory.createEmptyBorder(6, 8, 6, 8)
    );
    public static final Border BORDER_CARD = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(210, 215, 220)),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)
    );
    public static final Border BORDER_CARD_HIGH_LEVEL = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 4, 1, 0, GOLD_HIGHLIGHT),
            BorderFactory.createEmptyBorder(10, 10, 10, 14)
    );

    // 5. Pemetaan Warna Sesuai Role
    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return ROLE_DEFAULT_BG;
        }

        switch (type) {
            case WARRIOR:
                return ROLE_WARRIOR_BG;
            case MAGE:
                return ROLE_MAGE_BG;
            case ARCHER:
                return ROLE_ARCHER_BG;
            case HEALER:
                return ROLE_HEALER_BG;
            default:
                return ROLE_DEFAULT_BG;
        }
    }
}