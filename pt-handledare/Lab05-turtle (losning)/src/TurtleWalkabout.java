import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TurtleWalkabout {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(700, 700, "TurtleWalkabout");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		int dist;
		do {
			int step1 = 1 + rand.nextInt(10);
			int angle1 = -90 + rand.nextInt(180);
			t1.left(angle1);
			t1.forward(step1);
			int step2 = 1 + rand.nextInt(10);
			int angle2 = -90 + rand.nextInt(180);
			t2.left(angle2);
			t2.forward(step2);
			int dx = t1.getX() - t2.getX();
			int dy = t1.getY() - t2.getY();
			dist = (int) Math.sqrt(dx*dx + dy*dy);
			SimpleWindow.delay(20);
		} while (dist >= 50);
	}

}
