# Challenge Guidelines

## Project UAS OOP – Pong

**A. Deskripsi masalah**
- Implementasi dari game terkenal yaitu Pong dimana ada dua paddle yang masing-masing dimiliki oleh pemain A dan B. Tugas pemain adalah menggerakkan paddle dan menjaga bola agar tidak melewati paddle miliknya. Pemain kemudian akan mendapatkan skor dengan cara membiarkan pemain lawan gagal mengembalikan bola ke arena.
- Nama main file adalah ‘Pong’ (Contoh command: java Pong).
- Ukuran window minimum adalah 1200 x 800 dengan default *fullscreen*.

**B. Setelah app berjalan**
- Tampilkan menu { *Start Game (1P), Start Game (2P), Settings, Quit* }.
- Untuk *Start Game*, tampilkan arena permainan dan komponennya (ball, paddle, scoreboard).
- Paddle pemain 1 akan menempel di sebelah kiri arena, dan paddle pemain 2 di sebelah kanan arena.
- Bola akan muncul di tengah koordinat x dan y dari ukuran layar.
- Bola akan segera bergerak secara acak dengan kecepatan yang sudah ditentukan.
- Jika bola mengenai dasar atau atap layar, maka bola akan memantul kembali.
- Jika bola mengenai salah satu paddle pemain, maka bola akan memantul kembali menjauhi paddle.
- Jika bola melewati paddle pemain dan keluar dari arena, maka pemain lawan dari pemain yang paddle-nya dilewati akan bertambah satu skornya dan keadaan bola dan paddle kembali di-reset.
- Pada bagian settings, pemain dapat mengkonfigurasi game berkaitan dengan:
  - Kecepatan Bola
  - Ukuran Paddle
  - Tema Warna
  - Skor Maksimum

**C. Batasan lainnya**
- Gunakan prinsip modularitas pada code.
- Tampilan dibuat semenarik mungkin, misalnya warna, font, layout, dll.
- Skor akan di-*reset* setiap kali kembali ke menu. 

**D. Challenge ideas (optional)**
- Buat mode permainan dinamis, misalnya kecepatan bola dapat berubah ketika mengenai paddle pemain. 
- Buat mode Player vs CPU.
