import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.maze.Maze;

public class MazeWalker {
	private Turtle turtle;

	public MazeWalker(Turtle t) {
		turtle = t;
	}

	public void walk(Maze m) {
		while (m.atExit(turtle.getX(), turtle.getY()) == false) {
			if (!m.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.left(90);
			} else if (m.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.left(-90);
			}

		turtle.forward(1);
		SimpleWindow.delay(1);
		}

	}
}