import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class SquareMover {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "SquareMover");
		Square sq = new Square(250, 250, 100);
		int x = 250;
		int y = 250;
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int dx = (w.getClickedX() - x) / 10;
			int dy = (w.getClickedY() - y) / 10;
			for (int i = 0; i < 10; i++) {
				sq.erase(w);
				sq.move(dx, dy);
				sq.draw(w);
				SimpleWindow.delay(10);
			}

			// Överkurs: flytta till exakt rätt position
//			dx = (w.getClickedX() - x) % 10;
//			dy = (w.getClickedY() - y) % 10;
//			sq.erase(w);
//			sq.move(dx, dy);
//			sq.draw(w);
//			SimpleWindow.delay(10);

			x = w.getClickedX();
			y = w.getClickedY();
		}
	}
}
