import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	Random rand = new Random();

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	protected void raceStep() {
		forward(rand.nextInt(5) + 1);
		if (rand.nextBoolean()) {
			penDown();
		} else {
			penUp();
		}
	}

	public String toString() {
		return "Nummer " + nbr + " - MoleTurtle";
	}
}
