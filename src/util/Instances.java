package util;

public abstract class Instances {
  protected int maxHeight, maxWidth;

  // konstruktor nullary untuk instance tanpa parameter
  public Instances() {
  }

  // konstruktor dengan parameter untuk boundary
  public Instances(int height, int width) {
    setBoundary(height, width);
  }

  // menentukan ukuran lebar dan tinggi maksimum untuk pemakaian dalam method draw
  // dan logic pada child class
  public void setBoundary(int height, int width) {
    this.maxHeight = height;
    this.maxWidth = width;
  }
}