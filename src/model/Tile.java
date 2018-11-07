package model;

public class Tile {

	int width, height, x, y;
	boolean isLargest;
	
	public Tile (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isLargest = false;
	}
	
	public int x() { return x; }
	public int y() { return y; }
	public int width() { return width; }
	public int height() { return height; }
	
	public void setLargest(boolean b) { isLargest = b; }
	public boolean isLargest() { return isLargest; }

}
