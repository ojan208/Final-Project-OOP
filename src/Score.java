import java.awt.Font;
import java.awt.Graphics;

public class Score extends Instances {
  private int p1_score, p2_score;

  public Score(int containerHeight, int containerWidth) {
    super(containerHeight, containerWidth);
    p1_score = p2_score = 0;
  }

  public void addP1Score() {
    p1_score++;
  }

  public void addP2Score() {
    p2_score++;
  }

  public int getP1Score() {
    return p1_score;
  }

  public int getP2Score() {
    return p2_score;
  }

  public void reset() {
    p1_score = p2_score = 0;
  }

  public boolean hasInitialized() {
    if (!(p1_score == 0 && p2_score == 0)) {
      return true;
    }
    return false;
  }

  public void draw(Graphics g) {
    g.setFont(new Font("Press Start 2P", Font.PLAIN, 30));
    g.drawString(Integer.toString(this.p1_score), maxWidth / 4, maxHeight / 5);
    g.drawString(":", maxWidth / 2, maxHeight / 5);
    g.drawString(Integer.toString(this.p2_score), maxWidth * 3 / 4, maxHeight / 5);
  }
}