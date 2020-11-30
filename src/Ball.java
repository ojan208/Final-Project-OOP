import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Instances {
  // koordinat x dan y bola
  private double ballX, ballY;

  // kecepatan translasi bola
  private double velocity;

  // kecepatan translasi bola menurut koordinat X dan Y
  private double dX, dY;

  // radius bola
  private int ballR;

  // konstruktor
  public Ball() {
    this.velocity = this.dX = this.dY = 5.0;
    this.ballR = 8;
  }

  // getter perubahan kecepatan bola
  public double getVelocity() {
    return this.velocity;
  }

  // setter perubahan kecepatan bola
  public void setVelocity(double velocity) {
    this.velocity = velocity;
    this.dX = this.dY = velocity;
  }

  // getter koordinat x bola
  public double getX() {
    return this.ballX;
  }

  // getter koordinat y bola
  public double getY() {
    return this.ballY;
  }

  // getter radius bola
  public double getR() {
    return this.ballR;
  }

  // setter koordinat x bola
  public void setBallX(int ballX) {
    this.ballX = ballX;
  }

  // setter koordinat y bola
  public void setBallY(int ballY) {
    this.ballY = ballY;
  }

  // logika pergerakan bola
  public void move() {
    ballX += dX;
    ballY += dY;

    // misal bola keluar di sumbu y (lantai)
    if (ballY + ballR > maxHeight) {
      double out = ballY + ballR - maxHeight;
      ballY = maxHeight - ballR - out;
      dY = -dY;
    }

    // misal bola keluar di sumbu y (atap)
    if (ballY - ballR < 0) {
      double out = ballR - ballY;
      ballY = ballR + out;
      dY = -dY;
    }
  }

  // logika tumbukan bola, akan mengembalikan boolean true jika terjadi tumbukan
  // dan false jika tidak terjadi tumbukan
  public boolean paddleCollision(Paddle paddle, Score score) {
    if ((ballX - ballR < 15) && (ballY < paddle.getaY() + paddle.getPaddleSize() / 2)
        && (ballY > paddle.getaY() - paddle.getPaddleSize() / 2)) {
      dX = -dX;
    } else if ((ballX + ballR > maxWidth - 15) && (ballY < paddle.getbY() + paddle.getPaddleSize() / 2)
        && (ballY > paddle.getbY() - paddle.getPaddleSize() / 2)) {
      dX = -dX;
    } else if (ballX - ballR < 0) {
      score.addP2Score();
      return false;
    } else if (ballX + ballR > maxWidth) {
      score.addP1Score();
      return false;
    }
    return true;
  }

  // method draw untuk bola
  public void draw(Graphics g) {
    int x = (int) (ballX - ballR);
    int y = (int) (ballY - ballR);
    int size = 2 * ballR;
    g.setColor(Color.WHITE);
    g.fillOval(x, y, size, size);
  }
}