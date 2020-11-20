public class Engine {
  private boolean isRunning;

  public Engine() {
    isRunning = false;
  }

  public void start() {
    this.isRunning = true;
  }

  public void stop() {
    this.isRunning = false;
  }

  public void updateGame(Arena a) {
    a.getBall().move();

    if (!a.getBall().paddleCollision(a.getPaddles())) {
      stop();
    }

    a.repaint();
  }

  public boolean getRunningState() {
    return this.isRunning;
  }

}