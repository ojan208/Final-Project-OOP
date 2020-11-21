public class Settings {
  // kecepatan perpindahan paddle A dan B
  private int pd_A_displacement = 15;
  private int pd_B_displacement = 15;

  // kecepatan bola
  private double ball_velocity = 5.0;
  private Ball ball;

  // getter kecepatan perpindahan paddle A atau B
  public int getPaddleDisplacement(Paddle.Player type) {
    if (type == Paddle.Player.PADDLE_A) {
      return this.pd_A_displacement;
    }
    return this.pd_B_displacement;
  }

  // setter kecepatan perpindahan paddle A atau B
  public void setPaddleDisplacement(Paddle.Player type, int displacement) {
    if (type == Paddle.Player.PADDLE_A) {
      this.pd_A_displacement = displacement;
    }
    this.pd_B_displacement = displacement;
  }

  // getter kecepatan perpindahan bola
  public double getBallVelocity() {
    return this.ball_velocity;
  }

  // setter kecepatan perpindahan bola
  public void setBallVelocity(double velocity) {
    this.ball_velocity = velocity;
    ball.setVelocity(velocity);
  }
}