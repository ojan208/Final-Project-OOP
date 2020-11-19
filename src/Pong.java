import javax.swing.SwingUtilities;

public class Pong {
  public static void main(String[] args) {
    UserInterface mainUI = new GameInterface();
    SwingUtilities.invokeLater(mainUI);
  }
}