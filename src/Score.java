public class Score {
  private int p1_score, p2_score;

  public Score() {
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
}