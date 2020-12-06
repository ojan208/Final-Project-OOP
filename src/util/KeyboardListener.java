package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class KeyboardListener implements KeyListener {
  private HashSet<String> keys;

  public KeyboardListener(HashSet<String> keys) {
    this.keys = keys;
  }

  // ketika tombol ditekan, maka akan menyimpan state ke keys
  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code) {
      case KeyEvent.VK_UP:
        keys.add("UP");
        break;
      case KeyEvent.VK_DOWN:
        keys.add("DOWN");
        break;
      case KeyEvent.VK_LEFT:
        keys.add("LEFT");
        break;
      case KeyEvent.VK_RIGHT:
        keys.add("RIGHT");
        break;
      case KeyEvent.VK_SPACE:
        keys.add("SPACE");
        break;
      case KeyEvent.VK_W:
        keys.add("W");
        break;
      case KeyEvent.VK_S:
        keys.add("S");
        break;
      case KeyEvent.VK_ESCAPE:
        keys.add("ESCAPE");
        break;
    }
  }

  // ketika tombol dilepaskan, maka akan menghapus state ke keys
  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code) {
      case KeyEvent.VK_UP:
        keys.remove("UP");
        break;
      case KeyEvent.VK_DOWN:
        keys.remove("DOWN");
        break;
      case KeyEvent.VK_LEFT:
        keys.remove("LEFT");
        break;
      case KeyEvent.VK_RIGHT:
        keys.remove("RIGHT");
        break;
      case KeyEvent.VK_SPACE:
        keys.remove("SPACE");
        break;
      case KeyEvent.VK_W:
        keys.remove("W");
        break;
      case KeyEvent.VK_S:
        keys.remove("S");
        break;
      case KeyEvent.VK_ESCAPE:
        keys.remove("ESCAPE");
        break;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }
}