public class Engine {
  private boolean isRunning;
  private Score score;

  public Engine(Score score) {
    this.isRunning = false;
    this.score = score;
  }

  public void start() {
    this.isRunning = true;
  }

  public void stop() {
    this.isRunning = false;
  }

  public void updateGame(Arena a) {
    a.getBall().move();

    Paddle.Player getScorer = a.getBall().paddleCollision(a.getPaddles());

    if (getScorer != Paddle.Player.NONE) {
      if (getScorer == Paddle.Player.PADDLE_A) {
        score.addP1Score();
      } else if (getScorer == Paddle.Player.PADDLE_B) {
        score.addP2Score();
      }
      stop();
    }

    a.repaint();
  }

  public boolean getRunningState() {
    return this.isRunning;
  }
}