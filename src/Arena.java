import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel implements ActionListener {
  enum State {
    TITLE_SCREEN, MENU_SCREEN, IN_GAME, SETTINGS
  };

  private State state;

  private Menu menu;
  private Settings settings;

  private Ball ball;
  private Paddle paddle;
  private Engine engine;
  private Timer timer;
  private Score score;
  private KeyboardListener keyboardListener;

  public Arena(KeyboardListener keyboardListener) {
    super();
    super.setBackground(Color.BLACK);
    this.engine = new Engine();
    this.ball = new Ball();
    this.paddle = new Paddle();
    this.score = new Score();

    this.keyboardListener = keyboardListener;

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

      repaint();
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
    if (keyboardListener.getKeys().contains("UP")) {
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
    } else if (keyboardListener.getKeys().contains("DOWN")) {
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
    } else if (keyboardListener.getKeys().contains("W")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(-1);
          break;
        case IN_GAME:
          paddle.moveA("UP");
          break;
        case SETTINGS:
          settings.moveCursor(-1);
          break;
      }
    } else if (keyboardListener.getKeys().contains("S")) {
      switch (state) {
        case MENU_SCREEN:
          menu.moveCursor(+1);
          break;
        case IN_GAME:
          paddle.moveA("DOWN");
          break;
        case SETTINGS:
          settings.moveCursor(+1);
          break;
      }
    } else if (keyboardListener.getKeys().contains("LEFT")) {
      switch (state) {
        case SETTINGS:
          settings.alterAmount(-1);
          break;
      }
    } else if (keyboardListener.getKeys().contains("RIGHT")) {
      switch (state) {
        case SETTINGS:
          settings.alterAmount(+1);
          break;
      }
    } else if (keyboardListener.getKeys().contains("SPACE")) {
      switch (state) {
        case TITLE_SCREEN:
          state = State.MENU_SCREEN;
          menu = (menu == null) ? new Menu(getHeight(), getWidth()) : menu;
          break;
        case MENU_SCREEN:
          // mengubah state tampilan sesuai yang dipilih pada menu
          state = menu.ignite();
          if (state == State.SETTINGS) {
            settings = (settings == null) ? new Settings(getHeight(), getWidth(), this) : settings;
          }
          break;
        case IN_GAME:
          // mengubah timer menjadi nilai in-game, per 5 milidetik = 1x update
          timer.setDelay(5);
          engine.start();
          break;
        case SETTINGS:
          // jika `back` pada settings maka menyimpan hasil perubahan
          if (settings.getSettingsState() == 2) {
            settings.wrap(this);
            state = State.MENU_SCREEN;
            menu = (menu == null) ? new Menu(getHeight(), getWidth()) : menu;
          }
          break;
      }
    } else if (keyboardListener.getKeys().contains("ESCAPE")) {
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

    repaint();

    // jika state dalam permainan dan engine running, maka akan mengupdate
    // pergerakan setiap instances. Jika engine tidak running maka akan reset posisi
    // setiap instances
    if (state == State.IN_GAME) {
      if (engine.getRunningState()) {
        engine.updateGame(this);
      } else {
        initInstances();
      }
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (state == State.TITLE_SCREEN) {
      String message = "Press start to continue";

      Toolkit t = Toolkit.getDefaultToolkit();
      Image i = t.getImage("../images/pongtitle.png");

      int image_h = i.getHeight(this);
      int image_w = i.getWidth(this);

      g.drawImage(i, getWidth() / 2 - image_w / 2, getHeight() / 2 - image_h / 2, this);

      g.setFont(new Font("Press Start 2P", Font.PLAIN, 14));
      g.setColor(Color.WHITE);
      int string_h = g.getFontMetrics().getHeight();
      int string_w = g.getFontMetrics().stringWidth(message);
      g.drawString(message, getWidth() / 2 - string_w / 2, getHeight() / 2 - string_h / 2 + i.getHeight(this) + 20);
    } else if (state == State.MENU_SCREEN) {
      menu.draw(g);
    } else if (state == State.IN_GAME) {
      ball.draw(g);
      paddle.draw(g);
      score.draw(g);
    } else if (state == State.SETTINGS) {
      settings.draw(g);
    }
  }
}