import java.awt.Font;
import java.awt.Graphics;

public class Score extends Instances {
  private int p1_score, p2_score;

  // konstruktor, keadaan awal skor
  public Score() {
    p1_score = p2_score = 0;
  }

  // increment skor player 1
  public void addP1Score() {
    p1_score++;
  }

  // increment skor player 2
  public void addP2Score() {
    p2_score++;
  }

  // mengembalikan keadaan skor ke awal
  public void reset() {
    p1_score = p2_score = 0;
  }

  // method draw untuk score
  public void draw(Graphics g) {
    g.setFont(new Font("Press Start 2P", Font.PLAIN, 30));
    g.drawString(Integer.toString(p1_score), maxWidth / 4, maxHeight / 5);
    g.drawString(":", maxWidth / 2, maxHeight / 5);
    g.drawString(Integer.toString(p2_score), maxWidth * 3 / 4, maxHeight / 5);
  }
}