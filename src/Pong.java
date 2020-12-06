import core.*;

import javax.swing.SwingUtilities;

public class Pong {
  public static void main(String[] args) {
    GameInterface mainUI = new GameInterface();
    SwingUtilities.invokeLater(mainUI);
  }
}