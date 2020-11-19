import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
  private Paddle paddles;

  public KeyboardListener(Paddle paddles) {
    this.paddles = paddles;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      paddles.moveB(+paddles.getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      paddles.moveB(-paddles.getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
      paddles.moveA(+paddles.getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      paddles.moveA(-paddles.getPaddleDisplacement());
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent ke) {
  }
}