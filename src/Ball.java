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

  // getter koordinat bola
  public double getX() {
    return this.ballX;
  }

  public double getY() {
    return this.ballY;
  }

  // getter radius bola
  public double getR() {
    return this.ballR;
  }

  // setter koordinat bola
  public void setBallX(int ballX) {
    this.ballX = ballX;
  }

  public void setBallY(int ballY) {
    this.ballY = ballY;
  }

  public void move(Arena arena) {
    ballX += dX;
    ballY += dY;

    // Kalau keluar di sumbu Y
    if (ballY + ballR > arena.getHeight()) {
      double out = ballY + ballR - arena.getHeight();
      ballY = arena.getHeight() - ballR - out;
      dY = -dY;
    }
    if (ballY - ballR < 0) {
      double out = ballR - ballY;
      ballY = ballR + out;
      dY = -dY;
    }
  }

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

  public void draw(Graphics g) {
    int x = (int) (ballX - ballR);
    int y = (int) (ballY - ballR);
    int size = 2 * ballR;
    g.setColor(Color.WHITE);
    g.fillOval(x, y, size, size);
  }
}