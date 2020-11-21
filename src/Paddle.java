import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Instances {
  // enumerator tipe paddle
  enum Player {
    NONE, PADDLE_A, PADDLE_B
  }

  private int aY, bY, paddleSize, paddleDisplacement;

  // konstruktor
  public Paddle(int containerHeight, int containerWidth) {
    super(containerHeight, containerWidth);
    this.paddleDisplacement = 15;
    this.paddleSize = 120;
  }

  // getter koordinat Y dari paddle A
  public int getaY() {
    return this.aY;
  }

  // getter koordinat Y dari paddle B
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

  // setter koordinat Y dari paddle A
  public void setaY(int aY) {
    this.aY = aY;
  }

  // setter koordinat Y dari paddle B
  public void setbY(int bY) {
    this.bY = bY;
  }

  public void moveA(int d) {
    aY += d;
		
		// Agar paddle kiri tidak bisa keluar batas layar
		if (aY <= paddleSize/2){
			aY = paddleSize/2;
		} else if (aY + paddleSize >= getHeight() + paddleSize/2){
			aY = getHeight() - paddleSize/2;
		} 
  }

  public void moveB(int d) {
    bY += d;

		// Agar paddle kanan tidak bisa keluar batas layar
		if (bY <= paddleSize/2){
			bY = paddleSize/2;
		} else if (bY + paddleSize >= getHeight() + paddleSize/2){
			bY = getHeight() - paddleSize/2;
		}
  }

  public void draw(Graphics g) {
    g.setColor(Color.BLUE);
		g.fillRect(5, aY - paddleSize/2, 15, paddleSize);
		g.setColor(Color.BLUE);
		g.fillRect(getWidth() - 20, bY - paddleSize/2, 15, paddleSize)
  }
}