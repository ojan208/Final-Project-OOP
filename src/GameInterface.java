import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JTextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GameInterface implements Runnable {
  private JFrame pongFrame;

  public GameInterface() {
    // Constructor interface
  }

  @Override
  public void run() {
    pongFrame = new JFrame("Pong");

    // fullscreen
    pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // bentuk semua komponen
    createComponents(pongFrame.getContentPane());

    // rekondisi ukuran komponen
    pongFrame.pack();

    // tampilkan frame
    pongFrame.setVisible(true);
  }

  private void createComponents(Container container) {

  }

  public JFrame getFrame() {
    return pongFrame;
  }

}