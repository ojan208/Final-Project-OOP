package util;

import java.awt.Graphics;

public class Score extends Instances {
  private int p1_score, p2_score, maxScore;

  // konstruktor, keadaan awal skor
  public Score() {
    this.maxScore = 10;
    reset();
  }

  // increment skor player 1
  public void addP1Score() {
    p1_score++;
  }

  // increment skor player 2
  public void addP2Score() {
    p2_score++;
  }

  // ubah skor maksimal
  public void changeMaxScore(int maxScore) {
    this.maxScore = maxScore;
  }

  // ambil skor maksimal
  public int getMaxScore() {
    return this.maxScore;
  }

  // ambil pemain yang menang
  public int hasWon() {
    if (p1_score == maxScore) {
      return 1;
    } else if (p2_score == maxScore) {
      return 2;
    }
    return 0;
  }

  // mengembalikan keadaan skor ke awal
  public void reset() {
    p1_score = p2_score = 0;
  }

  // method draw untuk score
  public void draw(Graphics g) {
    g.setFont(g.getFont().deriveFont(28f));
    g.drawString(Integer.toString(p1_score), maxWidth / 4, maxHeight / 5);
    g.drawString(":", maxWidth / 2, maxHeight / 5);
    g.drawString(Integer.toString(p2_score), maxWidth * 3 / 4, maxHeight / 5);
  }
}