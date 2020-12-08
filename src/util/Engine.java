package util;

import core.*;

public class Engine {
  private boolean isRunning;

  // konstruktor, engine berhenti
  public Engine() {
    this.isRunning = false;
  }

  // engine dinyalakan
  public void start() {
    this.isRunning = true;
  }

  // engine dihentikan
  public void stop() {
    this.isRunning = false;
  }

  // logika update game
  public void updateGame(Arena a, Menu menu) {
    // bola bergerak
    a.getBall().move();

    /*
     * TESTING AUTOMOVING PADDLE (UNBEATABLE AI)
     */
    if (menu.getMenuState() == 0){
      double delta = a.getBall().getY() - a.getPaddles().getaY();
      if ((delta > 0) && (a.getPaddles().getaY() < a.getHeight() - a.getPaddles().getPaddleSize() / 2)) {
        a.getPaddles().setaY(a.getPaddles().getaY() +
        a.getPaddles().getPaddleDisplacement());
      } else if ((delta < 0) && (a.getPaddles().getaY() > 0 + a.getPaddles().getPaddleSize() / 2)) {
        a.getPaddles().setaY(a.getPaddles().getaY() -
        a.getPaddles().getPaddleDisplacement());
      }
    }

    // cek tumbukan bola terhadap paddle, jika tidak terjadi tumbukan, maka game
    // akan masuk ke stop state
    if (!a.getBall().paddleCollision(a.getPaddles(), a.getScore())) {
      stop();
    }
  }

  // mengembalikan keadaan engine
  public boolean getRunningState() {
    return this.isRunning;
  }
}