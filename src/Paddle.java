import java.awt.Graphics;

public class Paddle {
  // enumerator tipe paddle
  enum Types {
    PADDLE_A, PADDLE_B
  }

  private static int paddleSize = 120;
  private int aY, bY, paddleDisplacement;

  // konstruktor
  public Paddle() {
    this.paddleDisplacement = 15;
  }

  // getter koordinat Y dari paddle A
  public int getaY() {
    return this.aY;
  }

  // getter koordinat Y dari paddle B
  public int getbY() {
    return this.bY;
  }

  // getter kecepatan perpindahan paddle
  public int getPaddleDisplacement() {
    return this.paddleDisplacement;
  }

  // getter ukuran paddle
  public static int getPaddleSize() {
    return paddleSize;
  }

  public void moveA(int d) {
    // masukkan logika pergerakan paddle A di sini (ganti getHeight() menjadi
    // GameInterface)

  }

  public void moveB(int d) {
    // masukkan logika pergerakan paddle B di sini (ganti getHeight() menjadi
    // maxHeight)
  }

  public void draw(Graphics g) {
    // masukkan aturan gambar paddle
  }
}