package util;

import core.*;

import java.awt.Graphics;

public class Menu extends Instances {
  private String title = "MAIN MENU";
  private String[] menuList = { "Start Game (1 Player)", "Start Game (2 Players)", "Settings", "Quit" };
  private int menuState;

  // konstruktor untuk menu
  public Menu() {
    this.menuState = 0;
  }

  // mengembalikan arena.state sesuai state yang terfokus pada kursor ketika
  // pengguna menekan SPACE
  public Arena.State ignite() {
    if (menuState == 0 || menuState == 1) {
      return Arena.State.IN_GAME;
    } else if (menuState == 2) {
      return Arena.State.SETTINGS;
    } else if (menuState == 3) {
      System.exit(0);
    }
    return Arena.State.MENU_SCREEN;
  }

  // menggerakkan kursor
  public void moveCursor(int amount) {
    menuState += (((menuState == 3) && (amount > 0)) || ((menuState == 0) && (amount < 0))) ? 0 : amount;
  }

  // mengambil state menu saat ini
  public int getMenuState() {
    return this.menuState;
  }

  // method draw untuk menu
  public void draw(Graphics g) {

    for (int i = 0; i < menuList.length; i++) {
      g.drawString(menuList[i], maxWidth * 3 / 7, maxHeight * (25 + 5 * i) / 50);
    }

    // menyesuaikan dengan state saat ini, akan muncul kursor di sebelah kiri dan
    // indikator nilainya di sebelah kanan

    g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * (25 + 5 * menuState) / 50);

    // menyesuaikan dengan state saat ini, akan muncul kursor di sebelah kiri dan
    // indikator nilainya di sebelah kanan
    if (menuState == 0) {
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 25 / 50);
    } else if (menuState == 1) {
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 30 / 50);
    } else if (menuState == 2) {
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 35 / 50);
    } else if (menuState == 3) {
      g.drawString("> ", maxWidth * 3 / 7 - 30, maxHeight * 40 / 50);
    }

    g.setFont(g.getFont().deriveFont(28f));
    g.drawString(title, maxWidth * 3 / 7, maxHeight * 15 / 50);

  }
}