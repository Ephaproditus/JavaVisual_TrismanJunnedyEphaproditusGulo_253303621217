package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // 3 Karakter awal dari sprint sebelumnya
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 5, 200, 40, 50));
        manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 10, 300, 80, 200));
        manager.addCharacter(new Character("Legolas", CharacterType.ARCHER, 3, 160, 30, 80));

        // 2 Karakter baru untuk TP8 (Total 5 karakter)
        manager.addCharacter(new Character("Casanova", CharacterType.MAGE, 7, 240, 25, 150));
        manager.addCharacter(new Character("Caraxes", CharacterType.HEALER, 12, 340, 95, 250));
        manager.addCharacter(new Character("Zerstear", CharacterType.WARRIOR, 15, 400, 110, 40));

        // Menjalankan GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}