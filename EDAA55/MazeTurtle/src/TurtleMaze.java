import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;

public class TurtleMaze {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Maze m = new Maze(scan.nextInt());
		SimpleWindow w = new SimpleWindow(600, 600, "Maze");
		m.draw(w);
		Turtle t = new Turtle(w, m.getXEntry(), m.getYEntry());
		MazeWalker mw = new MazeWalker(t);
		t.penDown();
		mw.walk(m);
	}
}
