import java.awt.Graphics;

public class Ball {
  // koordinat X dan Y bola
  private double ballX, ballY;

  // kecepatan translasi bola menurut koordinat X dan Y
  private double dX, dY;

  // radius bola
  private int ballR;

  // konstruktor
  public Ball() {
    this.dX = this.dY = 5.0;
    this.ballR = 8;
  }

  // setter perubahan kecepatan bola
  public void setVelocity(double velocity) {
    this.dX = this.dY = velocity;
  }

  // getter koordinat X bola
  public double getX() {
    return this.ballX;
  }

  // getter koordinat Y bola
  public double getY() {
    return this.ballY;
  }

  // getter radius bola
  public double getR() {
    return this.ballR;
  }

  public void move() {
    // masukkan rumus update koordinat bola
  }

  public void draw(Graphics g) {
    // masukkan aturan gambar bola
  }
}