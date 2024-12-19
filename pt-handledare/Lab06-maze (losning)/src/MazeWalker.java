import java.awt.Color;
import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.window.WindowControls;

public class MazeWalker {
	private Turtle turtle;

	/** Skapar en ledsagare åt den givna sköldpaddan. */
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}

	/** Ledsagar sköldpaddan genom den givna labyrinten .*/
	public void walk(Maze maze) {
		while (! maze.atExit(turtle.getX(), turtle.getY())) {
			if (! maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				// an opening on the left, let's go there
				turtle.left(90);
				turtle.forward(1);
			} else if (! maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.forward(1);
			} else {
				turtle.left(-90);
			}
			SimpleWindow.delay(1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("maze (1-5):");
		int n = scan.nextInt();
		Maze maze;
		if (n >= 1 && n <= 5) {
			maze = new Maze(n);
		} else {
			maze = new Maze("crazy_maze.png", 242, 480);
		}
		SimpleWindow w = new SimpleWindow(520, 520, "Maze");
		w.setLineColor(Color.RED.darker());
		Turtle turtle = new Turtle(w, maze.getXEntry(), maze.getYEntry());
		turtle.penDown();
		maze.draw(w);
		MazeWalker walker = new MazeWalker(turtle);
		walker.walk(maze);
		scan.close();
	}
	
	/**
	 * Alternativ main-metod, där vi istället hämtar in användarens val
	 * från ritfönstret (med hjälp av WindowControls).  Detta är förstås
	 * inget studenterna måste göra, men kan vara kul för den som är intresserad.
	 */
	public static void mainWithWindowInput(String[] args) {
		SimpleWindow w = new SimpleWindow(520, 520, "Maze");
		WindowControls ctrl = w.getAdvancedControls();
		w.moveTo(100, 300);
		w.writeText("maze (1-5), or any other number for crazy maze)");
		String s = ctrl.input();
		w.clear();
		Scanner scan = new Scanner(s);
		int n = scan.nextInt();
		Maze maze;
		if (n >= 1 && n <= 5) {
			maze = new Maze(n);
		} else {
			maze = new Maze("crazy_maze.png", 242, 480);
		}
		w.setLineColor(Color.RED.darker());
		Turtle turtle = new Turtle(w, maze.getXEntry(), maze.getYEntry());
		turtle.penDown();
		maze.draw(w);
		MazeWalker walker = new MazeWalker(turtle);
		walker.walk(maze);
		scan.close();
	}
}
