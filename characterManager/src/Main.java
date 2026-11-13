import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO CHARACTER MANAGER SPRINT #2 (TP5) ===");

        CharacterManager manager = new CharacterManager();

        // 1. Pengujian Bagian A: CRUD & Penolakan Duplikat
        System.out.println("\n--- [BAGIAN A] Pengujian CRUD & Penolakan Duplikat ---");
        Character c1 = new Character("Arthur", CharacterType.WARRIOR, 5, 200, 40, 50);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 10, 300, 80, 200);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 3, 160, 30, 80);
        Character cDuplicate = new Character("arthur", CharacterType.HEALER);

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);

        System.out.println("Mencoba menambahkan duplikat 'arthur':");
        manager.addCharacter(cDuplicate);
        System.out.println("Total Karakter dalam Manager: " + manager.getTotalCharacters());

        // 2. Pengujian Bagian A: Defensive Copying
        System.out.println("\n--- [BAGIAN A] Pengujian Defensive Copying ---");
        List<Character> copyList = manager.getAllCharacters();
        copyList.clear(); // Menghapus isi salinan
        System.out.println("Ukuran list salinan setelah clear(): " + copyList.size());
        System.out.println("Ukuran list asli dalam Manager (tetap utuh): " + manager.getTotalCharacters());

        // 3. Pengujian Bagian B: Mini-Challenge
        System.out.println("\n--- [BAGIAN B] Pengujian Mini-Challenge ---");
        System.out.println("Rata-rata level saat ada data: " + manager.getAverageLevel());
        System.out.println("Karakter tipe MAGE: " + manager.findByType(CharacterType.MAGE));

        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata level pada manager kosong (edge case): " + emptyManager.getAverageLevel());

        // 4. Pengujian Bagian C: Fitur Mandiri renameCharacter()
        System.out.println("\n--- [BAGIAN C] Pengujian Fitur Mandiri renameCharacter() ---");
        System.out.println("Mencoba merename 'Legolas' -> 'Gandalf' (harus ditolak karena bentrok):");
        manager.renameCharacter("Legolas", "Gandalf");

        System.out.println("Mencoba merename 'Legolas' -> 'RobinHood' (harus berhasil):");
        boolean renameSuccess = manager.renameCharacter("Legolas", "RobinHood");
        System.out.println("Status Rename: " + renameSuccess);
        System.out.println("Data karakter setelah rename: " + manager.findByName("RobinHood"));

        // 5. Pengujian Bagian D: Eksperimen Reference & Static Field
        System.out.println("\n--- [BAGIAN D] Bukti Eksperimen Reference & Static ---");
        Character a = new Character("Kael", CharacterType.WARRIOR, 2, 150, 30, 20);
        Character b = a; // Menyalin reference, bukan objek baru
        b.setLevel(8);
        System.out.println("Nilai a.getLevel() setelah b.setLevel(8): " + a.getLevel());
        System.out.println("Apakah a == b? : " + (a == b));
        System.out.println("Total instance Character yang dibuat (static): " + Character.getTotalCharacterCreated());
    }
}