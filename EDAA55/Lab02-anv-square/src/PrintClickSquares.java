import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class PrintClickSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClickSquares");
		Square sq = new Square(-50, -50, 100);
		while (true) {
			w.waitForMouseClick();
			sq.erase(w);
			int x = w.getClickedX();
			int y = w.getClickedY();
			int x0 = sq.getX();
			int y0 = sq.getY();
			sq.move(x - x0, y - y0);
			sq.draw(w);

		}
	}

}
