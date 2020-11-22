# Pong

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Implementasi dari game terkenal yaitu Pong dimana ada dua paddle yang masing-masing dimiliki oleh pemain A dan B. Tugas pemain adalah menggerakkan paddle miliknya dan menjaga bola agar tidak melewati paddle miliknya. Pemain kemudian akan mendapatkan skor dengan cara membiarkan pemain lawan gagal mengembalikan bola ke arena.**

## Credits
| NPM           | Name        |
| ------------- |-------------|
| 140810190001  | Dicky Rahma Hermawan    |
| 140810190015  | Salsabila Karin    |
| 140810190041  | Windu Nursetyadi |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (18/11/2020)** 
   -  Diskusi awal, pembentukan challenge guidelines, perencanaan changelog

- **[Sprint 1](changelog/sprint-1.md) - (18/11/2020 - 24/11/2020)** 
   - Inisialisasi dasar kebutuhan JFrame
   - Konstruksi main screen
   - Inisialisasi kecepatan dan ukuran bola dan paddle
   - Inisialisasi koordinat bola
   - Inisialisasi koordinat paddle
   - Konfigurasi gambar bola pada window
   - Konfigurasi gambar paddle pada window
   - Membuat aturan kontrol keyboard pemain
   - Mengatur logika pantulan bola terhadap batas atap dan lantai
   - Mengatur logika pantulan bola terhadap paddle pemain A dan B
   - Mengatur logika perubahan pergerakan bola
   - Mengatur logika perpindahan paddle
   - Mengatur logika scoring
 
 
- **[Sprint 2](changelog/sprint-2.md) - (25/11/2020 - 01/12/2020)** 
   - Membuat tampilan menu dan pilihannya
   - Membuat setting
   - Merapikan antarmuka UI
   
- **[Sprint 3](changelog/sprint-3.md) - (02/12/2020 - 08/12/2020)** 
   - Merapikan antarmuka game yang kurang sesuai
   - Error handling
   - Mengimplementasikan challenge yang dapat diselesaikan

## Running The App

- Tampilkan menu { Start Game (2P), Settings, Quit }
- Untuk start game, tampilkan window game dan scoreboard di atas layar
- Paddle pemain 1 akan muncul di sebelah kiri window, dan paddle pemain 2 akan muncul di sebelah kanan window
- Bola akan muncul di tengah koordinat x dan y dari ukuran layar
- Bola akan segera bergerak secara acak dengan kecepatan yang sudah ditentukan
- Jika bola mengenai dasar atau atap layar, maka bola akan memantul kembali
- Jika bola mengenai paddle pemain, maka bola akan memantul menjauhi paddle
- Jika bola melewati paddle pemain, maka pemain lawan dari pemain yang paddle-nya dilewati skornya akan bertambah 1 dan keadaan bola dan paddle akan di-reset
- Pada bagian settings, pemain dapat mengonfigurasi game berkaitan mengenai:
   - Kecepatan bola;
   - Kecepatan paddle;

## Classes Used

TO;DO

UML image here

## Notable Assumption and Design App Details

TO;DO
