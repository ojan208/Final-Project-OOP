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
   - Menambah UML
   - Bug fixing
   - Menambah sistem *single player*

## Running The App

File utama `Pong.java` 

1. *Compile* seluruh file java dalam folder `src` menggunakan perintah :

``` 
 javac *.java 
 ``` 

2. Jalankan file utama `Pong.java` dengan perintah :

 ``` 
 java Pong 
 ``` 

3. Tombol keyboard yang digunakan pada aplikasi :
   - Gunakan tombol `W` dan `S` untuk menggerakkan paddle A (pemain 1) serta tombol `Up Arrow` dan `Down Arrow` untuk menggerakkan paddle B (pemain 2) ke atas dan ke bawah.
   - Gunakan tombol `Spacebar` untuk konfirmasi pilihan menu dan memulai permainan.
   - Gunakan tombol `Left Arrow` dan `Right Arrow` untuk mengubah nilai pada *settings*.

## Classes Used

1. **Pong (program utama)** -
`Pong.java` 
   - Program utama yang berisi method main.
   - Arguments (1 arg)
      - **1 arg (args)** - args tidak digunakan.
   - 0 Class Variable
   - 1 Method
      - **main()** - Method main yang menginvoke mainUI sebagai GameInterface.

### Folder *core*

2. **Arena** - 
`Arena.java` 
   - Objek utama yang mengatur actionListeners, state halaman, serta seluruh object utils.
   - Arguments (1 arg)
      - **1 arg (keys)** - Merupakan HashKey yang disimpan sebagai keystrokes dalam variabel keys.  
   - 10 Class Variable
      - **@State** - Enum untuk halaman.
      - **@state** - Nilai enum halaman aktif.
      - **@menu** - Object menu.
      - **@settings** - Object settings.
      - **@ball** - Object ball.
      - **@paddle** - Object paddle.
      - **@engine** - Object engine.
      - **@score** - Object score.
      - **@timer** - Timer sebagai interval setiap action.
      - **@keys** - Keystrokes untuk diproses sebagai action.
   - 7 Method
      - **initInstances()** - Kondisi awal yang me-reset instances ball, paddle, dan score.
      - **getBall()** - Getter ball.
      - **getPaddles()** - Getter paddles.
      - **getEngine()** - Getter engine.
      - **getScore()** - Getter score.
      - **OV~actionPerformed(e)** - Mapping action berdasarkan keys dan state.
      - **OV~paintComponent(g)** - Method drawable, menyesuaikan dengan state.

3. **GameInterface** -
`GameInterface.java`
   - Object frame sebagai container komponen arena sekaligus sebagai focus untuk keyboardListener.
   - Arguments (0 arg)
   - 4 Class Variable
      - **@pongFrame** - Frame container utama.
      - **@arena** - Object arena yang akan diberikan argumen keys sebagai keystrokes. 
      - **@keyboardListener** - Listener untuk input keyboard.
      - **@keys** - Keystrokes hasil dari input keyboardListener.
   - 2 Method
      - **OV~run()** - Sebagai method yang dijalankan pada thread utama, mengatur karakteristik window yang dibangun.
      - **createComponenents(container)** - Penyambungan komponen arena dan listener keyboard.

### Folder *util*

4. **Ball** -
`Ball.java`
   - Object bola yang mengekstensi class `Instances`.
   - Arguments (0 arg)
   - 7 Class Variable
      - **@bouncingToken** - Untuk menjaga bola tidak terperangkap paddle.
      - **@ballX** - Koordinat x bola.
      - **@ballY** - Koordinat y bola.
      - **@velocity** - Kecepatan translasi bola.
      - **@dX** - Kecepatan translasi bola menurut koordinat X.
      - **@dY** - Kecepatan translasi bola menurut koordinat Y.
      - **@ballR** - Radius bola.
   - 10 Method
      - **getVelocity()** - Getter perubahan kecepatan bola.
      - **setVelocity(velocity)** - Setter perubahan kecepatan bola.
      - **getX()** - Getter koordinat X bola.
      - **getY()** - Getter koordinat Y bola.
      - **getR()** - Getter radius bola.
      - **setBallX(ballX)** - Setter koordinat X bola.
      - **setBallY(ballY)** - Setter koordinat Y bola.
      - **move()** - Logika pergerakan bola.
      - **paddleCollision(paddle, score)** - Logika tumbukan bola.
      - **draw(g)** - Drawable untuk bola.

5. **Engine** -
`Engine.java`
   - Object engine yang mengekstensi class `Instances`. Berfungsi untuk mengorkestrasi ketika state IN-GAME dalam arena.
   - Arguments (0 arg)
   - 1 Class Variable
      - **@isRunning** - Status nyala/ berhenti engine.
   - 4 Method
      - **start()** - Menyalakan engine.
      - **stop()** - Menghentikan engine.
      - **updateGame()** - Logika update game, berisi ketika bola bergerak dan pengecekan tumbukan bola.
      - **getRunningState()** - Getter status engine.

6. **Instances** -
`Instances.java`
   - Abstract Class yang berfungsi sebagai helper dalam menginisialisasi ukuran container untuk komponen drawables.
   - Arguments (2 arg)
      - **1 arg (height, width)** - Sebagai boundary komponen drawables.
   - 2 Class Variable
      - **@maxHeight** - Tinggi maksimum boundary.
      - **@maxWidth** - Lebar maksimum boundary.
   - 1 Method
      - **setBoundary(height, width)** - Setter ukuran boundary.

7. **KeyboardListener** -
`KeyboardListener.java`
   - Object untuk mengontrol input keyboard yang akan dimapping ke dalam keys.
   - Arguments (1 arg)
      - **1 arg (keys)** - Merupakan HashKey yang disimpan sebagai keystrokes hasil input pengguna.
   - 2 Class Variable
      - **@keys** - Keystrokes hasil mapping.
   - 3 Method
      - **OV~keyPressed** - Mapping ketika tombol ditekan.
      - **OV~keyReleased** - Mapping ketika tombol dilepaskan.
      - **OV~keyTyped** - Mapping ketika tombol diketikkan.

8. **Menu** -
`Menu.java`
   - Object menu yang mengekstensi class `Instances`. Berfungsi sebagai controller dan views halaman menu.
   - Arguments (0 arg)
   - 3 Class Variable
      - **@title** - Merupakan judul MAIN MENU.
      - **@menuList** - Array string pilihan menu.
      - **@menuState** - Status menu aktif yang akan ditunjuk kursor.
   - 4 Method
      - **ignite()** - Mengembalikan state Arena sesuai pilihan yang ditunjuk kursor.
      - **moveCursor(amount)** - Perubahan pergerakan kursor yang menunjuk pilihan menu.
      - **getMenuState()** - Setter state menu.
      - **draw(g)** - Drawable untuk menu.

9. **Paddle** -
`Paddle.java`
   - Object paddle yang mengekstensi class `Instances`.
   - Arguments (0 arg)
   - 4 Class Variable
      - **@aY** - Koordinat Y dari paddle A.
      - **@bY** - Koordinat Y dari paddle B.
      - **@paddleSize** - Ukuran panjang paddle.
      - **@paddleDisplacement** - Kecepatan translasi vertikal paddle.
   - 10 Method
      - **getaY()** - Getter koordinat Y dari paddle A.
      - **getbY()** - Getter koordinat Y dari paddle B.
      - **getPaddleDisplacement()** - Getter kecepatan perpindahan paddle.
      - **getPaddleSize()** - Getter ukuran paddle.
      - **setaY(aY)** - Setter koordinat Y dari paddle A.
      - **setbY(bY)** - Setter koordinat Y dari paddle B.
      - **setPaddleSize(bY)** - Setter ukuran paddle.
      - **moveA()** - Logika pergerakan paddle A.
      - **moveB()** - Logika pergerakan paddle B.
      - **draw(g)** - Drawable untuk paddle.

10. **Score** -
`Score.java`
    - Object score yang mengekstensi class `Instances`.
    - Arguments (0 arg)
    - 3 Class Variable
      - **@p1_score** - Nilai skor pemain 1.
      - **@p2_score** - Nilai skor pemain 2.
      - **@maxScore** - Nilai maksimum skor.
    - 7 Method
      - **addP1Score()** - Increment skor pemain 1.
      - **addP2Score()** - Increment skor pemain 2.
      - **changeMaxScore(maxScore)** - Ubah skor maksimal.
      - **getMaxScore()** - Getter skor maksimal untuk diubah di settings.
      - **hasWon()** - Ambil jika terdapat pemain yang menang.
      - **reset()** - Mengembalikan keadaan skor ke awal.
      - **draw(g)** - Drawable untuk skor.
      
11. **Settings** -
`Settings.java`
    - Object settings yang mengekstensi class `Instances`. Berfungsi sebagai controller dan views halaman settings.
    - Arguments (1 arg)
      - **1 arg (arena)** - Berisi inisialisasi komponen variabel temporary yang diambil dari arena.
    - 8 Class Variable
      - **@title** - Merupakan judul SETTINGS.
      - **@settingsList** - Array string pilihan settings.
      - **@settingsState** - Status settings aktif yang akan ditunjuk kursor.
      - **@s_ballVelocity** - Temporary variabel kecepatan bola.
      - **@s_paddleSize** - Temporary variabel ukuran paddle.
      - **@s_currentTheme** - Temporary variabel tema warna.
      - **@s_maxScore** - Temporary variabel ukuran skor maksimal.
      - **@s_colorTheme** - LinkedHashMap berisi warna yang dapat dipilih sebagai tema.
    - 7 Method
      - **wrap()** - Menerapkan segala perubahan yang telah dibuat.
      - **moveCursor(amount)** - Perubahan pergerakan kursor yang menunjuk pilihan settings.
      - **alterAmount(amount)** - Menambah/ mengurangi nilai variabel temporary sesuai amount yang dimasukkan.
      - **setSettingsState(state)** - Mengubah keadaan status settings saat ini.
      - **getSettingsState()** - Mengambil status settings saat ini.
      - **getSettingsOptionsLength()** - Mengambil indeks pilihan settings terakhir.
      - **draw(g)** - Drawable untuk settings.


![UML](/images/UML_project.png "UML")

## Notable Assumption and Design App Details

- Desain Aplikasi
   - Aplikasi didesain untuk bekerja optimal dengan ukuran window fullscreen. Ukuran window minimum 1200x800 masih cukup bekerja dengan baik.
   - Tema warna default adalah hitam (Black) dan pilihan yang dapat dipilih adalah { Black , White }.
   - Skor maksimum default adalah 10 dan skor akan direset jika salah satu pemain mencapai skor tersebut.
   - Terdapat menu dengan pilihan { Start Game (1 Player), Start Game (2 Players), Settings, Quit }.
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
