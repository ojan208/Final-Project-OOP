package core;

import util.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel implements ActionListener {
  public enum State {
    TITLE_SCREEN, MENU_SCREEN, IN_GAME, SETTINGS
  };

  private State state;

  private Menu menu;
  private Settings settings;

  private Ball ball;
  private Paddle paddle;
  private Engine engine;
  private Score score;
  private Timer timer;
  private HashSet<String> keys;

  public Arena(HashSet<String> keys) {
    super();
    super.setBackground(Color.BLACK);

    // mengambil font dari folder font
    try {
      Font bodyFont = Font.createFont(Font.TRUETYPE_FONT, new File("../font/Body.ttf")).deriveFont(14f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

      ge.registerFont(bodyFont);

      this.setFont(bodyFont);
    } catch (IOException e) {
      e.printStackTrace();
      this.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    } catch (FontFormatException e) {
      e.printStackTrace();
      this.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }

    this.engine = new Engine();
    this.ball = new Ball();
    this.paddle = new Paddle();
    this.score = new Score();
    this.menu = new Menu();
    this.settings = new Settings(this);

    this.keys = keys;

    // update pada game, per 150 milidetik = 1x update (hanya untuk menu)
    this.timer = new Timer(150, this);
    timer.start();

    this.state = State.TITLE_SCREEN;
  }

  public void initInstances() {
    if (!engine.getRunningState()) {

      // set boundary yang diambil dari batas maksimum panjang dan lebar layar untuk
      // penggunaan di dalam masing-masing instances
      ball.setBoundary(getHeight(), getWidth());
      paddle.setBoundary(getHeight(), getWidth());
      score.setBoundary(getHeight(), getWidth());

      // set koordinat bola di tengah
      ball.setBallX(getWidth() / 2);
      ball.setBallY(getHeight() / 2);

      // set koordinat paddle di tengah
      paddle.setaY(getHeight() / 2);
      paddle.setbY(getHeight() / 2);
    }
  }

  public Ball getBall() {
    return this.ball;
  }

  public Paddle getPaddles() {
    return this.paddle;
  }

  public Engine getEngine() {
    return this.engine;
  }

  public Score getScore() {
    return this.score;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // implementasi keyboardListener berdasarkan masing-masing state
    if (keys.contains("UP")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(-1);
          break;
        case IN_GAME:
          paddle.moveB("UP");
          break;
        case SETTINGS:
          settings.moveCursor(-1);
          break;
      }
    }

    if (keys.contains("DOWN")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(+1);
          break;
        case IN_GAME:
          paddle.moveB("DOWN");
          break;
        case SETTINGS:
          settings.moveCursor(+1);
          break;
      }
    }

    if (keys.contains("W")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(-1);
          break;
        case IN_GAME:
          if(menu.getMenuState() == 1){
            paddle.moveA("UP");
          }
          break;
        case SETTINGS:
          settings.moveCursor(-1);
          break;
      }
    }

    if (keys.contains("S")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(+1);
          break;
        case IN_GAME:
          if(menu.getMenuState() == 1){
            paddle.moveA("DOWN");
          }
          break;
        case SETTINGS:
          settings.moveCursor(+1);
          break;
      }
    }

    if (keys.contains("LEFT")) {
      switch (state) {
        case SETTINGS:
          settings.alterAmount(-1);
          break;
      }
    }

    if (keys.contains("RIGHT")) {
      switch (state) {
        case SETTINGS:
          settings.alterAmount(+1);
          break;
      }
    }

    if (keys.contains("SPACE")) {
      switch (state) {
        case TITLE_SCREEN:
          state = State.MENU_SCREEN;
          menu.setBoundary(getHeight(), getWidth());
          break;
        case MENU_SCREEN:
          // mengubah state tampilan sesuai yang dipilih pada menu
          state = menu.ignite();
          if (state == State.SETTINGS) {
            settings.setSettingsState(0);
            settings.setBoundary(getHeight(), getWidth());
          }
          break;
        case IN_GAME:
          if (score.hasWon() != 0) {
            score.reset();
          }
          // mengubah timer menjadi nilai in-game, per 5 milidetik = 1x update
          timer.setDelay(5);
          engine.start();
          break;
        case SETTINGS:
          // jika `back` pada settings maka menyimpan hasil perubahan
          if (settings.getSettingsState() == settings.getSettingsOptionsLength()) {
            settings.wrap(this);
            state = State.MENU_SCREEN;
            menu.setBoundary(getHeight(), getWidth());
          }
          break;
      }
    }

    if (keys.contains("ESCAPE")) {
      switch (state) {
        case IN_GAME:
          // menghentikan engine, me-reset score, dan mengembalikan delay timer untuk menu
          engine.stop();
          score.reset();
          timer.setDelay(150);
          state = State.MENU_SCREEN;
          break;
      }
    }

    // jika state dalam permainan dan engine running, maka akan mengupdate
    // pergerakan setiap instances. Jika engine tidak running maka akan reset posisi
    // setiap instances
    if (state == State.IN_GAME) {
      if (engine.getRunningState()) {
        engine.updateGame(this, menu);
      } else {
        initInstances();
      }
    }

    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (this.getBackground() == Color.BLACK) {
      g.setColor(Color.WHITE);
    } else {
      g.setColor(Color.BLACK);
    }

    super.paintComponent(g);

    if (state == State.TITLE_SCREEN) {
      String message = "Press start to continue";

      Toolkit t = Toolkit.getDefaultToolkit();
      Image i = t.getImage("../images/pongtitle.png");

      int image_h = i.getHeight(this);
      int image_w = i.getWidth(this);

      g.drawImage(i, getWidth() / 2 - image_w / 2, getHeight() / 2 - image_h / 2, this);

      int string_h = g.getFontMetrics().getHeight();
      int string_w = g.getFontMetrics().stringWidth(message);
      g.drawString(message, getWidth() / 2 - string_w / 2, getHeight() / 2 - string_h / 2 + i.getHeight(this) + 20);
    } else if (state == State.MENU_SCREEN) {
      menu.draw(g);
    } else if (state == State.IN_GAME) {
      if (score.hasWon() != 0) {
        String submessage = "Press space to play again...";
        int string_h = g.getFontMetrics().getHeight();
        int string_w2 = g.getFontMetrics().stringWidth(submessage);
        g.drawString(submessage, getWidth() / 2 - string_w2 / 2, getHeight() / 2 - string_h / 2 + 50);

        g.setFont(this.getFont().deriveFont(24f));
        String message = "Player " + score.hasWon() + " wins the game!";
        int string_w = g.getFontMetrics().stringWidth(message);
        g.drawString(message, getWidth() / 2 - string_w / 2, getHeight() / 2 - string_h / 2);
      } else {
        ball.draw(g);
      }
      paddle.draw(g);
      score.draw(g);
    } else if (state == State.SETTINGS) {
      settings.draw(g);
    }
  }
}