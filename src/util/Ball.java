package util;

import java.awt.Graphics;

public class Ball extends Instances {
  // untuk menjaga bola tidak terperangkap paddle
  private int bouncingToken;

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
    this.velocity = this.dX = this.dY = 3.0;
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

    if ((ballX >= maxWidth / 4 && ballX <= maxWidth / 4 + 5)
        || (ballX >= maxWidth * 3 / 4 || ballX <= maxWidth * 3 / 4 + 5)) {
      bouncingToken = 1;
    }
  }

  // logika tumbukan bola, akan mengembalikan boolean true jika terjadi tumbukan
  // dan false jika tidak terjadi tumbukan
  public boolean paddleCollision(Paddle paddle, Score score) {
    if (ballX - ballR < 0) {
      score.addP2Score();
      return false;
    } else if (ballX + ballR > maxWidth) {
      score.addP1Score();
      return false;
    }

    // Empat if dibawah ini merupakan bug fix

    // fix bola nyangkut di bawah kiri
    if ((ballX - ballR <= 35 && ballX - ballR >= 20)
        && (ballY - ballR <= paddle.getaY() + paddle.getPaddleSize() / 2 + 5
            && ballY - ballR >= paddle.getaY() + paddle.getPaddleSize() / 2)) {
      dY = -dY;
    }

    // fix bola nyangkut di bawah kanan
    if ((ballX + ballR >= maxWidth - 35 && ballX + ballR <= maxWidth - 20)
        && (ballY - ballR <= paddle.getbY() + paddle.getPaddleSize() / 2 + 5
            && ballY - ballR >= paddle.getbY() + paddle.getPaddleSize() / 2)) {
      dY = -dY;
    }

    // fix bola nyangkut di atas kiri
    if ((ballX - ballR <= 35 && ballX - ballR >= 20) && (ballY + ballR <= paddle.getaY() - paddle.getPaddleSize() / 2
        && ballY + ballR >= paddle.getaY() - paddle.getPaddleSize() / 2 - 5)) {
      dY = -dY;
    }

    // fix bola nyangkut di atas kanan
    if ((ballX + ballR >= maxWidth - 35 && ballX + ballR <= maxWidth - 20)
        && (ballY + ballR <= paddle.getbY() - paddle.getPaddleSize() / 2
            && ballY + ballR >= paddle.getbY() - paddle.getPaddleSize() / 2 - 5)) {
      dY = -dY;
    }

    // Empat if selesai

    if (((ballX - ballR <= 35) && (ballX - ballR >= 30) && (ballY - ballR < paddle.getaY() + paddle.getPaddleSize() / 2)
        && (ballY + ballR > paddle.getaY() - paddle.getPaddleSize() / 2))
        || ((ballX + ballR >= maxWidth - 35) && (ballX + ballR <= maxWidth - 30)
            && (ballY - ballR < paddle.getbY() + paddle.getPaddleSize() / 2)
            && (ballY + ballR > paddle.getbY() - paddle.getPaddleSize() / 2)) && bouncingToken == 1) {
      dX = -dX;
      bouncingToken = 0;
    }

    return true;
  }

  // method draw untuk bola
  public void draw(Graphics g) {
    int x = (int) (ballX - ballR);
    int y = (int) (ballY - ballR);
    int size = 2 * ballR;
    g.fillOval(x, y, size, size);
  }
}