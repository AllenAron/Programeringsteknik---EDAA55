import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintSquareSequence");
		Square sq = new Square(0, 0, 100);
		while (true) {
			w.waitForMouseClick();
			int x = w.getClickedX();
			int y = w.getClickedY();
			int x0 = sq.getX();
			int y0 = sq.getY();
			int dx = x - x0;
			int dy = y - y0;
			int stepx = dx / 10;
			int stepy = dy / 10;
			for (int i = 0; i < 10; i++) {
				if (i != 0) {
					sq.erase(w);
					sq.move(stepx, stepy);
					sq.draw(w);
					w.delay(50);

				}
			}

		}
	}
}
