import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	Random rand = new Random();
	private int abs;

	public AbsentMindedTurtle(RaceWindow w, int nbr, int abs) {
		super(w, nbr);
		this.abs = abs;
		penDown();
	}

	public void raceStep() {
		if (rand.nextInt(100) > abs) {
			forward(rand.nextInt(5) + 1);
		}
	}

	public String toString() {
		return "Nummer " + nbr + " - AbsentMindedTurtle (" + abs + "% Absent)";
	}
}
