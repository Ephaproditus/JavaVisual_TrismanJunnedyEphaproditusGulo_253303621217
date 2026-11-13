package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private final List<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    // Bagian A: Menambahkan karakter dengan validasi anti-duplikat nama
    public boolean addCharacter(Character c) {
        if (c == null) return false;
        for (Character existing : characterList) {
            if (existing.getName().equalsIgnoreCase(c.getName())) {
                System.out.println("[WARNING] Karakter dengan nama '" + c.getName() + "' sudah ada! Penambahan ditolak.");
                return false;
            }
        }
        characterList.add(c);
        return true;
    }

    // Bagian A: Mencari karakter berdasarkan nama (case-insensitive)
    public Character findByName(String name) {
        if (name == null) return null;
        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // Bagian A: Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target != null) {
            return characterList.remove(target);
        }
        return false;
    }

    // Bagian A: Mengembalikan jumlah total karakter
    public int getTotalCharacters() {
        return characterList.size();
    }

    // Bagian A: Mengembalikan salinan list (Defensive Copying) agar list asli terlindungi
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // Bagian B (Mini-Challenge): Menghitung rata-rata level (aman dari pembagian nol)
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }
        double totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        return totalLevel / characterList.size();
    }

    // Bagian B (Mini-Challenge): Mengembalikan daftar karakter berdasarkan tipe tertentu
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Bagian C (Fitur Analitik Rancangan Sendiri):
     * Mengubah nama karakter yang sudah ada menjadi nama baru dengan validasi ketat
     * untuk mencegah nama kosong atau bentrok (duplikat) dengan karakter lain,
     * serta menjaga encapsulation dengan tidak mengekspos list internal.
     *
     * @param oldName Nama karakter lama yang ingin diubah
     * @param newName Nama baru yang diinginkan
     * @return true jika perubahan nama berhasil, false jika karakter tidak ditemukan atau nama bentrok
     */
    public boolean renameCharacter(String oldName, String newName) {
        if (oldName == null || newName == null || newName.trim().isEmpty()) {
            return false;
        }
        Character target = findByName(oldName);
        if (target == null) {
            System.out.println("[ERROR] Karakter '" + oldName + "' tidak ditemukan.");
            return false;
        }
        if (!oldName.equalsIgnoreCase(newName) && findByName(newName) != null) {
            System.out.println("[ERROR] Nama baru '" + newName + "' sudah digunakan oleh karakter lain!");
            return false;
        }
        target.setName(newName);
        return true;
    }
}