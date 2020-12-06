package core;

import util.*;

import java.awt.Container;
import java.awt.Dimension;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameInterface implements Runnable {
  private JFrame pongFrame;
  private Arena arena;
  private KeyboardListener keyboardListener;
  private HashSet<String> keys;

  public GameInterface() {
    // membuat instance keyboardListener yang akan mengambil input key untuk JFrame
    // pongFrame sebagai component yang terfokus
    this.keys = new HashSet<String>();
    this.keyboardListener = new KeyboardListener(keys);

    // meneruskan keyboardListener ke dalam JPanel arena sehingga dapat dilakukan
    // mapping action untuk masing-masing key
    this.arena = new Arena(keys);
  }

  @Override
  public void run() {
    pongFrame = new JFrame("Pong");

    pongFrame.setMinimumSize(new Dimension(1200, 800));

    // fullscreen
    pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
    pongFrame.add(this.arena);

    // listener untuk keyboard
    pongFrame.addKeyListener(this.keyboardListener);
  }

}