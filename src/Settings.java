import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Settings extends Instances {
  private String[] settingsList = { "Ball Speed : ", "Paddle Size : ", "Back" };
  private int settingsState;
  private int s_ballVelocity, s_paddleSize;

  // konstruktor untuk settings, akan mengambil nilai yang dibutuhkan dari
  // variabel yang di pass arena
  public Settings(int containerHeight, int containerWidth, Arena arena) {
    super(containerHeight, containerWidth);
    this.settingsState = 0;
    this.s_ballVelocity = (int) arena.getBall().getVelocity();
    this.s_paddleSize = arena.getPaddles().getPaddleSize();
  }

  // menerapkan segala perubahan yang telah dibuat
  public void wrap(Arena arena) {
    arena.getBall().setVelocity(s_ballVelocity);
    arena.getPaddles().setPaddleSize(s_paddleSize);
  }

  // menggerakkan kursor
  public void moveCursor(int amount) {
    settingsState += (((settingsState == 2) && (amount > 0)) || ((settingsState == 0) && (amount < 0))) ? 0 : amount;
  }

  // menambah/ mengurangi nilai variabel state sesuai amount yang dimasukkan
  public void alterAmount(int amount) {
    if (settingsState == 0) {
      s_ballVelocity += (((s_ballVelocity == 10) && (amount > 0)) || ((s_ballVelocity == 3) && (amount < 0))) ? 0
          : amount;
    } else if (settingsState == 1) {
      s_paddleSize += (((s_paddleSize == 300) && (amount > 0)) || ((s_paddleSize == 20) && (amount < 0))) ? 0 : amount;
    }
  }

  // mengambil state settings saat ini
  public int getSettingsState() {
    return this.settingsState;
  }

  // method draw untuk settings
  public void draw(Graphics g) {
    g.setFont(new Font("Press Start 2P", Font.PLAIN, 14));
    g.setColor(Color.WHITE);
    g.drawString(settingsList[0], maxWidth * 3 / 7, maxHeight * 2 / 5);
    g.drawString(settingsList[1], maxWidth * 3 / 7, maxHeight * 3 / 5);
    g.drawString(settingsList[2], maxWidth * 3 / 7, maxHeight * 4 / 5);

    // menyesuaikan dengan state saat ini, akan muncul kursor di sebelah kiri dan
    // indikator nilainya di sebelah kanan
    if (settingsState == 0) {
      String string = "- " + Integer.toString(s_ballVelocity) + " +";
      int string_w = g.getFontMetrics().stringWidth(settingsList[0]);
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 2 / 5);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * 2 / 5);
    } else if (settingsState == 1) {
      String string = "- " + Integer.toString(s_paddleSize) + " +";
      int string_w = g.getFontMetrics().stringWidth(settingsList[1]);
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 3 / 5);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * 3 / 5);
    } else if (settingsState == 2) {
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 4 / 5);
    }
  }
}