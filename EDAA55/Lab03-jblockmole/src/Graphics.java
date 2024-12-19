import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	private SimpleWindow w;
	private int width;
	private int height;
	private int blockSize;

	public Graphics(int w, int h, int bs) {
		width = w;
		height = h;
		blockSize = bs;
		this.w = new SimpleWindow(width * blockSize, height * blockSize, "Digging");
	}

	public void block(int x, int y, java.awt.Color color) {
		int left = x * blockSize;
		int right = left + blockSize - 1;
		int top = y * blockSize;
		int bottom = top + blockSize - 1;
		w.setLineColor(color);
		for (int row = top; row <= bottom; row++) {
			w.moveTo(left, row);
			w.lineTo(right, row);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return w.getX();
	}

	public int getY() {
		return w.getY();
	}

	public void moveTo(int x, int y) {
		w.moveTo(x, y);
	}

	public void rectangle(int x, int y, int width, int height, java.awt.Color c) {

		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				block(xx, yy, c);
			}
		}
	}

	public char waitForKey() {
		return w.waitForKey();
	}

	public void square() {
		w.moveTo(10, 10);
		w.lineTo(10, 20);
		w.lineTo(20, 20);
		w.lineTo(20, 10);
		w.lineTo(10, 10);
	}
}
