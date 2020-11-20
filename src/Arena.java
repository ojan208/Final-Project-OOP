import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Arena extends JPanel {
  private Ball ball;
  private Paddle paddle;
  private Engine engine;
  private Timer timer;

  public Arena() {
    super();
    super.setBackground(Color.BLACK);
    this.engine = new Engine();

    Arena arena = this;
    this.timer = new Timer(10, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (engine.getRunningState()) {
          engine.updateGame(arena);
        }
      }
    });
    this.timer.start();
  }

  public void initInstances() {
    if (!engine.getRunningState()) {
      this.engine.start();
      this.ball = new Ball(getHeight(), getWidth());
      this.paddle = new Paddle(getHeight(), getWidth());

      this.paddle.setaY(getHeight() / 2);
      this.paddle.setbY(getHeight() / 2);

      this.ball.setBallX(getWidth() / 2);
      this.ball.setBallY(getHeight() / 2);

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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (this.engine.getRunningState()) {
      this.ball.draw(g);
      this.paddle.draw(g);

    } else {
      String message = "Press start to continue";

      Toolkit t = Toolkit.getDefaultToolkit();
      Image i = t.getImage("../images/pongtitle.png");

      int image_h = i.getHeight(this);
      int image_w = i.getWidth(this);

      g.drawImage(i, getWidth() / 2 - image_w / 2, getHeight() / 2 - image_h / 2, this);

      g.setFont(new Font("Arial", Font.PLAIN, 14));
      g.setColor(Color.WHITE);
      int string_h = g.getFontMetrics().getHeight();
      int string_w = g.getFontMetrics().stringWidth(message);
      g.drawString(message, getWidth() / 2 - string_w / 2, getHeight() / 2 - string_h / 2 + i.getHeight(this));
    }
  }
}