import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Instances {
  // koordinat X dan Y bola
  private double ballX, ballY;

  // kecepatan translasi bola menurut koordinat X dan Y
  private double dX, dY;

  // radius bola
  private int ballR;

  // konstruktor
  public Ball(int containerHeight, int containerWidth) {
    super(containerHeight, containerWidth);
    this.dX = this.dY = 5.0;
    this.ballR = 8;
  }

  // setter perubahan kecepatan bola
  public void setVelocity(double velocity) {
    this.dX = this.dY = velocity;
  }

  // getter koordinat X bola
  public double getX() {
    // isi getter koordinatX
  }

  // getter koordinat Y bola
  public double getY() {
    // isi getter koordinatY
  }

  // getter radius bola
  public double getR() {
    // isi getter radius ballR
  }

  public void setBallX(int ballX) {
    // isi setter untuk ballX
  }

  public void setBallY(int ballY) {
    // isi setter untuk ballY
  }

  public void move() {
    // masukkan rumus update koordinat bola di sini
  }

  public boolean paddleCollision(Paddle paddle) {
    // masukkan logika benturan bola ke paddle di sini, harus mengembalikan nilai
    // boolean true untuk benturan
  }

  public void draw(Graphics g) {
    // masukkan body untuk fungsionalitas draw ball di sini
  }
}