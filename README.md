# JavaVisual_TrismanJunnedyEphaproditusGulo_253303621217

# Character Manager — TP3 (Java Visual SIH-6406)

Proyek ini merupakan implementasi fondasi *class model* Java untuk aplikasi **Character Manager** pada Sprint #1. Aplikasi ini dibangun mengimplementasikan konsep dasar Pemrograman Berbasis Objek (OOP) seperti *Encapsulation*, *Type Safety* dengan Enum, *Constructor Overloading*, serta validasi atribut kondisi (*exception handling*).

---

## 📌 Screenshot Output Terminal

![Output Terminal](Screenshot/HASIL.png)
---

## 📁 Struktur Folder Project

```text
javavisual-tp03-[NIM]/
├── README.md
└── CharacterManager/
    └── src/
        ├── Main.java
        └── com/
            └── unpri/
                └── charactermanager/
                    └── model/
                        ├── Character.java
                        └── CharacterType.java

# Character Manager — Java Visual (TP5)

**Nama**: Trisman Junnedy Ephaproditus Gulo  
**NIM**: 253303621217  
**Kelas**: Sistem Informasi / Java Visual (SIH-6406)  
**Dosen Pengampu**: Dr. Evta Indra  

---

## 📌 Deskripsi Tugas (TP5)
Tugas ini berfokus pada implementasi arsitektur kelas berbasis *Object-Oriented Programming* (PBO) di Java, penerapan enkapsulasi data (*defensive copying*), pelacakan objek secara global menggunakan *static field*, serta analisis konseptual terkait penanganan referensi memori.

---

## 🚀 Fitur & Implementasi Kode
1. **Bagian A — Implementasi Core & Defensive Copying**:
   - `Character.java`: Memiliki method `equals()` yang di-*override* untuk membandingkan kesamaan nama karakter secara *case-insensitive*.
   - `CharacterManager.java`: Mengimplementasikan method `addCharacter()` dengan validasi penolakan nama duplikat, `findByName()`, `removeCharacter()`, `getTotalCharacters()`, dan `getAllCharacters()`.
   - **Defensive Copying**: Method `getAllCharacters()` mengembalikan salinan baru dari list (`new ArrayList<>(characterList)`) guna melindungi struktur data internal dari modifikasi ilegal di luar kelas.
2. **Bagian B — Mini-Challenge**:
   - `getAverageLevel()`: Menghitung rata-rata level seluruh karakter secara akurat dan aman terhadap kondisi list kosong (mencegah *Division by Zero*).
   - `findByType(CharacterType)`: Mengembalikan daftar karakter berdasarkan filter tipe tertentu.
3. **Bagian C — Fitur Analitik Rancangan Sendiri (`renameCharacter`)**:
   - **Deskripsi Method**: Mengubah nama karakter lama menjadi nama baru dengan validasi ketat untuk memastikan nama tidak kosong serta mencegah bentrok (duplikasi) dengan nama karakter lain.
   - **Rasional**: Memungkinkan pemain/sistem memperbarui identitas karakter secara fleksibel tanpa merusak enkapsulasi internal objek maupun struktur data manajemen.

---

## 🔗 Link Dokumen Analisis (Google Docs — Bagian D)
- **Google Docs Analisis**: [JavaVisual_TP05_253303621217_TrismanJunnedyEphaproditusGulo](https://docs.google.com/document/d/YOUR_GOOGLE_DOCS_LINK_HERE/edit?usp=sharing)  
*(Akses dokumen diatur ke: "Anyone with the link — Viewer")*

---

## 📸 Screenshots & Output Program
![Output Terminal](Screenshot/HASIL.png)
