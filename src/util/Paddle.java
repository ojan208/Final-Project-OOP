package util;

import java.awt.Graphics;

public class Paddle extends Instances {
  private int aY, bY, paddleSize, paddleDisplacement;

  // konstruktor
  public Paddle() {
    this.paddleDisplacement = 5;
    this.paddleSize = 120;
  }

  // getter koordinat y dari paddle A
  public int getaY() {
    return this.aY;
  }

  // getter koordinat y dari paddle B
  public int getbY() {
    return this.bY;
  }

  // getter kecepatan perpindahan paddle
  public int getPaddleDisplacement() {
    return this.paddleDisplacement;
  }

  // getter ukuran paddle
  public int getPaddleSize() {
    return this.paddleSize;
  }

  // setter koordinat y dari paddle A
  public void setaY(int aY) {
    this.aY = aY;
  }

  // setter koordinat y dari paddle B
  public void setbY(int bY) {
    this.bY = bY;
  }

  // setter ukuran panjang paddle
  public void setPaddleSize(int size) {
    this.paddleSize = size;
  }

  // logika pergerakan paddle A
  public void moveA(String direction) {
    aY += (direction == "UP") ? -this.paddleDisplacement : +this.paddleDisplacement;

    // agar paddle A tidak bisa keluar batas layar
    if (aY <= paddleSize / 2) {
      aY = paddleSize / 2;
    } else if (aY + paddleSize >= maxHeight + paddleSize / 2) {
      aY = maxHeight - paddleSize / 2;
    }
  }

  // logika pergerakan paddle B
  public void moveB(String direction) {
    bY += (direction == "UP") ? -this.paddleDisplacement : +this.paddleDisplacement;

    // agar paddle B tidak bisa keluar batas layar
    if (bY <= paddleSize / 2) {
      bY = paddleSize / 2;
    } else if (bY + paddleSize >= maxHeight + paddleSize / 2) {
      bY = maxHeight - paddleSize / 2;
    }
  }

  // method draw untuk paddle
  public void draw(Graphics g) {
    g.fillRect(25, aY - paddleSize / 2, 15, paddleSize);
    g.fillRect(maxWidth - 40, bY - paddleSize / 2, 15, paddleSize);
  }
}