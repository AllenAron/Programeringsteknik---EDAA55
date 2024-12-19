import java.util.ArrayList;
import java.util.Random;

public class RaceTurtle extends Turtle {
	Random rand = new Random();
	int nbr;

	RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		x = RaceWindow.getStartXPos(nbr);
		y = RaceWindow.getStartYPos(nbr);
		penDown();
		left(-90);
		this.nbr = nbr;

	}

	void raceStep() {
		forward(rand.nextInt(5) + 1);
	}

	public String toString() {
		return "Nummer " + nbr;
	}
}
