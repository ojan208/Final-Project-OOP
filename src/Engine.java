public class Engine {
  private boolean isRunning;

  public Engine() {
    this.isRunning = false;
  }

  public void start() {
    this.isRunning = true;
  }

  public void stop() {
    this.isRunning = false;
  }

  public void updateGame(Arena a) {
    a.getBall().move(a);

    // cek tumbukan bola terhadap paddle, jika tidak terjadi tumbukan, maka game
    // akan masuk ke stop state
    if (!a.getBall().paddleCollision(a.getPaddles(), a.getScore())) {
      stop();
    }

    a.repaint();
  }

  public boolean getRunningState() {
    return this.isRunning;
  }
}