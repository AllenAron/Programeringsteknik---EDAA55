import java.util.ArrayList;
import java.util.Random;

public class RaceTurtle extends Turtle {
	private Random rand = new Random();
	private int nbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		x = RaceWindow.getStartXPos(nbr);
		y = RaceWindow.getStartYPos(nbr);
		penDown();
		left(-90);
		this.nbr = nbr;

	}

	protected void raceStep() {
		forward(rand.nextInt(5) + 1);
	}

	public String toString() {
		return "Nummer " + nbr;
	}
}
