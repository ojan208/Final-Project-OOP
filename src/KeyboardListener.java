import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
  private Arena arena;

  public KeyboardListener(Arena arena) {
    this.arena = arena;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      arena.initInstances();
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      arena.getPaddles().moveB(-arena.getPaddles().getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      arena.getPaddles().moveB(+arena.getPaddles().getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
      arena.getPaddles().moveA(-arena.getPaddles().getPaddleDisplacement());
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      arena.getPaddles().moveA(+arena.getPaddles().getPaddleDisplacement());
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent ke) {
  }
}