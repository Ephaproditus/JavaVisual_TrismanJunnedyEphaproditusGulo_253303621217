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

```
---

# Character Manager Java Visual TP5

---
Nama: Trisman Junnedy Ephaproditus Gulo
NIM: 253303621217
Kelas: Sistem Informasi / Java Visual (SIH-6406)
Dosen Pengampu: Dr. Evta Indra


---


## Ringkasan Proyek
Proyek ini merupakan pengembangan lanjutan dari modul Character Manager (Sprint #2 / TP5). Fokus utama pengerjaan meliputi penerapan prinsip Pemrograman Berorientasi Objek di Java, validasi data, enkapsulasi memori, serta penanganan koleksi data secara aman.

---

## Struktur dan Implementasi Fitur
1. Core Implementation (Bagian A):
- Character.java: Mengimplementasikan method equals() yang dioverride untuk membandingkan kesamaan nama karakter secara case-insensitive.
- CharacterManager.java: Menyediakan method addCharacter() dengan pencegahan duplikasi nama, findByName(), removeCharacter(), getTotalCharacters(), serta getAllCharacters() yang menerapkan Defensive Copying agar list internal terlindungi dari modifikasi luar.

2. Mini-Challenge (Bagian B):
- getAverageLevel(): Menghitung rata-rata level seluruh karakter secara akurat dan dilengkapi pengaman kondisi list kosong (mencegah error pembagian dengan nol).
- findByType(CharacterType): Menyaring dan mengembalikan daftar karakter berdasarkan tipe tertentu.

3. Fitur Analitik Mandiri (Bagian C):
- renameCharacter(oldName, newName): Method rancangan sendiri untuk mengubah nama karakter dengan validasi ketat terhadap nama kosong dan pencegahan bentrok nama dengan karakter lain yang sudah ada.

## Analisis dan Dokumentasi (Bagian D)
- Tautan Dokumen Analisis Google Docs: https://docs.google.com/document/d/17mQVz4Sup2ySj154_-H6PZ7psDAkIZMqWyOgDwHO_bQ/edit?usp=sharing


## Screenshot Output Program
![Output Terminal](Screenshot/hasil_TP5.png)

---

## TP8 — Character Manager Sprint #3 (MainWindow, Data Dinamis & MVC)

---

### 1. Aliran Data MVC (Main -> CharacterManager -> MainWindow)
Dalam arsitektur MVC yang diterapkan, kelas Main berperan sebagai Controller yang menginisialisasi objek CharacterManager (Model) beserta seluruh data karakter awal. Selanjutnya, Main menjalankan MainWindow (View) melalui SwingUtilities.invokeLater() dengan meneruskan referensi CharacterManager. MainWindow kemudian membaca salinan daftar karakter secara dinamis melalui perulangan (loop) untuk merender kartu komponen GUI dan memperbarui label statistik rata-rata level tanpa manipulasi data langsung.

### 2. Daftar Karakter Baru dan Alasan Pemilihan
- Mercy (Tipe: HEALER, Level: 7): Ditambahkan untuk melengkapi keragaman peran karakter pendukung (support) dan menguji tampilan dinamis dengan atribut mana yang tinggi.
- Shadow (Tipe: MAGE, Level: 12): Ditambahkan sebagai representasi karakter level tinggi guna menguji akurasi perhitungan rata-rata level pada label statistik di bagian bawah jendela.
- Ragnar (Tipe: WARRIOR, Level: 15): Digunakan pada pengujian kedua untuk membuktikan bahwa statistik rata-rata level otomatis berubah secara dinamis ketika data bertambah.

### 3. Link Dokumen Analisis GUI & MVC (Bagian D)
- Google Docs Analisis TP8: https://docs.google.com/document/d/1qUnXGoD2E3CNBsIdRjVAdcjbK1R4Dc9eFBOgiXzSOuU/edit?usp=sharing
(Akses dokumen diatur ke: Anyone with the link Viewer)

### 4. Screenshots MainWindow (Sebelum & Sesudah Perubahan Data)
- Screenshot 1 (5 Karakter — Rata-rata Level 7.40):
  ![MainWindow Sebelum](Screenshot/TP8_Sebelum.png)
- Screenshot 2 (6 Karakter — Rata-rata Level 8.67):
  ![MainWindow Sesudah](Screenshot/TP8_Sesudah.png)

  ---

  ## TP10 — Character Manager Sprint #4 (Theming, Properti Komponen & MVC)

  ---

### 1. Mengapa Warna Disimpan di AppTheme dan Bukan di Character?
Pengaturan warna disimpan di kelas AppTheme (layer View) dan bukan di dalam kelas Character (layer Model) untuk menjaga pemisahan tanggung jawab (Separation of Concerns) pada arsitektur MVC. Kelas Character hanya fokus mengelola data dan aturan bisnis karakter tanpa bergantung pada pustaka grafis java.awt.Color. Dengan demikian, tampilan tema visual dapat diubah secara terpusat di satu tempat tanpa harus menyentuh atau merusak struktur data pada package model.

### 2. Dua Properti Tambahan yang Dipilih dan Alasannya
- setToolTipText() pada Kartu Karakter: Menampilkan ringkasan lengkap seluruh atribut karakter (termasuk nilai Mana yang tidak ditampilkan di kartu utama) saat kursor diarahkan ke kartu, sehingga tampilan kartu tetap ringkas namun informatif.
- setEnabled(false) pada Karakter Level 1 (Rookie): Memberikan pembeda visual (efek teks redup) secara otomatis bagi karakter pemula yang masih berada di level 1 sebagai penanda status bahwa karakter tersebut belum siap diturunkan ke misi utama.

### 3. Link Dokumen Analisis Properti & MVC (Bagian D)
- Google Docs Analisis TP10: https://docs.google.com/document/d/1h79l414pdOZf5NFlvjPyC7lBw6iUGUz4GsD8T82VbNI/edit?usp=sharing
(Akses dokumen diatur ke: Anyone with the link Viewer)

### 4. Screenshots Perbandingan (Sebelum v0.3 vs Sesudah v0.4)
- Sebelum (MainWindow v0.3):
  ![MainWindow v0.3](Screenshot/TP8_Sesudah.png)
- Sesudah (MainWindow v0.4 dengan AppTheme & Highlight Emas Level >= 5):
  ![MainWindow v0.4](Screenshot/TP10_v04.png)