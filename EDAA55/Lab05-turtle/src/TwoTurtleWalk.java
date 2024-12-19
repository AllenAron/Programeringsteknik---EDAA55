import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TwoTurtleWalk {

	public static void main(String[] args) {
		int width = 600;
		int height = 600;
		SimpleWindow w = new SimpleWindow(width, height, "TurtleWalkFigure");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		double dx = Math.abs(t1.getX() - t2.getX());
		double dy = Math.abs(t1.getY() - t2.getY());
		double dist = Math.sqrt((dx * dx) + (dy * dy));
		t1.penDown();
		t2.penDown();
		w.setLineWidth(1);
		while (dist >= 50) {
			t1.forward(rand.nextInt(9) + 1);
			t1.left(rand.nextInt(360) - 180);
			w.delay(10);
			t2.forward(rand.nextInt(9) + 1);
			t2.left(rand.nextInt(360) - 180);
			w.delay(10);
			dx = Math.abs(t1.getX() - t2.getX());
			dy = Math.abs(t1.getY() - t2.getY());
			dist = Math.sqrt((dx * dx) + (dy * dy));
		}

	}

}