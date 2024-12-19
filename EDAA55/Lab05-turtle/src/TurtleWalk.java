import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleWalk {
	
	public static void main(String[] args) {
		int width = 600;
		int height = 600;
		SimpleWindow w = new SimpleWindow(width, height, "TurtleWalkFigure");
		Turtle t = new Turtle(w, width/2, height/2);
		Random rand = new Random();
		t.penDown();
		w.setLineWidth(1);
		for (int i = 0; i<1000; i++) {
			t.forward(rand.nextInt(9)+1);
			t.left(rand.nextInt(360)-180);
			w.delay(10);
			
		}
		

	}

}
