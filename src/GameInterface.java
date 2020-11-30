import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameInterface implements Runnable {
  private JFrame pongFrame;
  private Arena arena;
  private KeyboardListener keyboardListener;

  public GameInterface() {
    // membuat instance keyboardListener yang akan mengambil input key untuk JFrame
    // pongFrame sebagai component yang terfokus
    keyboardListener = new KeyboardListener();

    // meneruskan keyboardListener ke dalam JPanel arena sehingga dapat dilakukan
    // mapping action untuk masing-masing key
    arena = new Arena(keyboardListener);
  }

  @Override
  public void run() {
    pongFrame = new JFrame("Pong");

    // fullscreen
    pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    // set ukuran window minimum menjadi 1200px x 800px
    pongFrame.setMinimumSize(new Dimension(1200, 800));

    // ketika window di-close, maka akan exit program
    pongFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // bentuk semua komponen
    createComponents(pongFrame.getContentPane());

    // rekondisi ukuran komponen
    pongFrame.pack();

    // tampilkan frame
    pongFrame.setVisible(true);
  }

  private void createComponents(Container container) {
    // menambahkan arena pada container
    pongFrame.add(arena);

    // listener untuk keyboard
    pongFrame.addKeyListener(keyboardListener);
  }

  public JFrame getFrame() {
    return pongFrame;
  }

}