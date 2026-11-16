package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AppTheme {
    // 1. Konstanta Warna Dasar & Aksen
    public static final Color BG_WINDOW = Color.WHITE;
    public static final Color BG_PANEL_SUBTLE = new Color(246, 248, 250);
    public static final Color TEXT_PRIMARY = new Color(35, 45, 55);
    public static final Color TEXT_MUTED = new Color(95, 105, 115);
    public static final Color GOLD_HIGHLIGHT = new Color(184, 134, 11);
    public static final Color STATUS_BAR_BG = new Color(53, 89, 142);
    public static final Color STATUS_BAR_FG = Color.WHITE;
    public static final Color BORDER_LINE = new Color(210, 215, 220);

    // Warna Kartu & Legenda Berdasarkan Role (Sesuai Tema Terang TP10)
    private static final Color ROLE_WARRIOR_BG = new Color(255, 175, 175); // Merah terang
    private static final Color ROLE_MAGE_BG = new Color(220, 180, 255);    // Ungu terang
    private static final Color ROLE_ARCHER_BG = new Color(135, 206, 250);  // Biru terang
    private static final Color ROLE_HEALER_BG = new Color(152, 251, 152);  // Hijau terang
    private static final Color ROLE_DEFAULT_BG = new Color(245, 247, 250);

    // 2. Konstanta Font (Logical Font)
    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font FONT_SUBTITLE = new Font(Font.SANS_SERIF, Font.BOLD, 13);
    public static final Font FONT_NAME_REGULAR = new Font(Font.SANS_SERIF, Font.BOLD, 13);
    public static final Font FONT_NAME_ELITE = FONT_NAME_REGULAR.deriveFont(Font.BOLD, 14f);
    public static final Font FONT_DETAIL = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font FONT_LEGEND = new Font(Font.SANS_SERIF, Font.BOLD, 11);
    public static final Font FONT_STATS = new Font(Font.MONOSPACED, Font.BOLD, 12);
    public static final Font FONT_STATUS = new Font(Font.SANS_SERIF, Font.BOLD, 12);

    // 3. Konstanta Border
    public static final Border BORDER_CARD = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_LINE),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)
    );
    public static final Border BORDER_CARD_HIGH_LEVEL = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 4, 1, 0, GOLD_HIGHLIGHT),
            BorderFactory.createEmptyBorder(10, 10, 10, 14)
    );
    public static final Border BORDER_HEADER = BorderFactory.createEmptyBorder(14, 15, 8, 15);
    public static final Border BORDER_STATS_GRID = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 1, 0, BORDER_LINE),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
    );
    public static final Border BORDER_SCROLL = BorderFactory.createEmptyBorder(8, 15, 8, 8);
    public static final Border BORDER_LEGEND_PANEL = BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 1, 0, 0, BORDER_LINE),
            BorderFactory.createEmptyBorder(12, 12, 12, 15)
    );
    public static final Border BORDER_LEGEND_ITEM = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_LINE, 1),
            BorderFactory.createEmptyBorder(6, 10, 6, 10)
    );
    public static final Border BORDER_STATUS_BAR = BorderFactory.createEmptyBorder(10, 15, 10, 15);

    // 4. Pemetaan Warna Sesuai Role
    public static Color colorFor(CharacterType type) {
        if (type == null) return ROLE_DEFAULT_BG;
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