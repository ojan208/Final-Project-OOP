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
    a.getBall().move(a);

    if (!a.getBall().paddleCollision(a.getPaddles(), a, a.getScore()) {
      stop();
    }

    a.repaint();
  }

  public boolean getRunningState() {
    return this.isRunning;
  }

}