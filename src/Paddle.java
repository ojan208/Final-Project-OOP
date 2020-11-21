import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Instances {
  // enumerator tipe paddle
  enum Types {
    PADDLE_A, PADDLE_B
  }

  private int aY, bY, paddleSize, paddleDisplacement;

  // konstruktor
  public Paddle(int containerHeight, int containerWidth) {
    super(containerHeight, containerWidth);
    this.paddleDisplacement = 15;
    this.paddleSize = 120;
  }

  // getter koordinat Y dari paddle A
  public int getaY() {
    
  }

  // getter koordinat Y dari paddle B
  public int getbY() {
    
  }

  // getter kecepatan perpindahan paddle
  public int getPaddleDisplacement() {
    return this.paddleDisplacement;
  }

  // getter ukuran paddle
  public int getPaddleSize() {
    return this.paddleSize;
  }

  // setter koordinat Y dari paddle A
  public void setaY(int aY) {
    // isi setter untuk aY
  }

  // setter koordinat Y dari paddle B
  public void setbY(int bY) {
    // isi setter untuk bY
  }

  public void moveA(int d) {
    // masukkan logika pergerakan paddle A di sini
  }

  public void moveB(int d) {
    // masukkan logika pergerakan paddle B di sini
  }

  public void draw(Graphics g) {
    // masukkan body untuk fungsionalitas draw ball di sini
  }
}