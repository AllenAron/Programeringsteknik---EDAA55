import java.util.Random;

public class RaceTurtle extends Turtle {
	static protected Random rand = new Random();
	private int nbr;
	
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		penDown();
		left(-90);
	}
	
	public void raceStep() {
		forward(rand.nextInt(6) + 1);
	}
	
	public String toString() {
		return "Nummer " + nbr;
	}
}
