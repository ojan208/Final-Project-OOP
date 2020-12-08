package util;

import core.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedHashMap;

public class Settings extends Instances {
  private String title = "SETTINGS";
  private String[] settingsList = { "Ball Speed : ", "Paddle Size : ", "Color Theme : ", "Maximum Score : ", "Back" };
  private int settingsState;
  private int s_ballVelocity, s_paddleSize, s_currentTheme, s_maxScore;
  private LinkedHashMap<String, Color> s_colorTheme = new LinkedHashMap<String, Color>();

  // konstruktor untuk settings, akan mengambil nilai yang dibutuhkan dari
  // variabel yang di pass arena
  public Settings(Arena arena) {
    this.settingsState = 0;
    this.s_ballVelocity = (int) arena.getBall().getVelocity();
    this.s_paddleSize = arena.getPaddles().getPaddleSize();
    this.s_currentTheme = 0;
    this.s_maxScore = arena.getScore().getMaxScore();
    this.s_colorTheme.put("Black", Color.BLACK);
    this.s_colorTheme.put("White", Color.WHITE);
  }

  // menerapkan segala perubahan yang telah dibuat
  public void wrap(Arena arena) {
    arena.getBall().setVelocity(s_ballVelocity);
    arena.getPaddles().setPaddleSize(s_paddleSize);
    arena.setBackground((Color) s_colorTheme.values().toArray()[s_currentTheme]);
    arena.getScore().changeMaxScore(s_maxScore);
  }

  // menggerakkan kursor
  public void moveCursor(int amount) {
    settingsState += (((settingsState == getSettingsOptionsLength()) && (amount > 0))
        || ((settingsState == 0) && (amount < 0))) ? 0 : amount;
  }

  // menambah/ mengurangi nilai variabel state sesuai amount yang dimasukkan
  public void alterAmount(int amount) {
    if (settingsState == 0) {
      s_ballVelocity += (((s_ballVelocity == 7) && (amount > 0)) || ((s_ballVelocity == 1) && (amount < 0))) ? 0
          : amount;
    } else if (settingsState == 1) {
      s_paddleSize += (((s_paddleSize == 300) && (amount > 0)) || ((s_paddleSize == 20) && (amount < 0))) ? 0
          : amount * 5;
    } else if (settingsState == 2) {
      s_currentTheme += (((s_currentTheme == 1) && (amount > 0)) || ((s_currentTheme == 0) && (amount < 0))) ? 0
          : amount;
    } else if (settingsState == 3) {
      s_maxScore += (((s_maxScore == 30) && (amount > 0)) || ((s_maxScore == 3) && (amount < 0))) ? 0 : amount;
    }
  }

  // men-set state settings saat ini
  public void setSettingsState(int state) {
    this.settingsState = state;
  }

  // mengambil state settings saat ini
  public int getSettingsState() {
    return this.settingsState;
  }

  // mengambil indeks nilai pilihan settings terakhir
  public int getSettingsOptionsLength() {
    return this.settingsList.length - 1;
  }

  // method draw untuk settings
  public void draw(Graphics g) {
    for (int i = 0; i < settingsList.length; i++) {
      g.drawString(settingsList[i], maxWidth * 3 / 7, maxHeight * (25 + 5 * i) / 50);
    }

    // menyesuaikan dengan state saat ini, akan muncul kursor di sebelah kiri dan
    // indikator nilainya di sebelah kanan
    if (settingsState == 0) {
      String string = "<   " + Integer.toString(s_ballVelocity) + "   >";
      int string_w = g.getFontMetrics().stringWidth(settingsList[0]);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * (25 + 5 * settingsState) / 50);
    } else if (settingsState == 1) {
      String string = "<   " + Integer.toString(s_paddleSize) + "   >";
      int string_w = g.getFontMetrics().stringWidth(settingsList[1]);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * (25 + 5 * settingsState) / 50);
    } else if (settingsState == 2) {
      String string = "<   " + (String) s_colorTheme.keySet().toArray()[s_currentTheme] + "   >";
      int string_w = g.getFontMetrics().stringWidth(settingsList[2]);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * (25 + 5 * settingsState) / 50);
    } else if (settingsState == 3) {
      String string = "<   " + Integer.toString(s_maxScore) + "   >";
      int string_w = g.getFontMetrics().stringWidth(settingsList[3]);
      g.drawString(string, maxWidth * 3 / 7 + string_w + 30, maxHeight * (25 + 5 * settingsState) / 50);
    }

    g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * (25 + 5 * settingsState) / 50);

    g.setFont(g.getFont().deriveFont(28f));
    g.drawString(title, maxWidth * 3 / 7, maxHeight * 15 / 50);
  }
}