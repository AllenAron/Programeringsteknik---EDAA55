import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	Random rand = new Random();
	private int diz;
	private int alpha;

	public DizzyTurtle(RaceWindow w, int nbr, int diz) {
		super(w, nbr);
		this.diz = diz;
		alpha = 0;
		penDown();
	}

	protected void raceStep() {
		if (Math.abs(alpha) > 40) {
			left(-alpha);
			alpha = 0;
		}
		switch (diz) {
		case 1:
			int turn1 = rand.nextInt(20) - 10;
			left(turn1);
			forward(rand.nextInt(5) + 1);
			alpha += turn1;
			break;
		case 2:
			int turn2 = rand.nextInt(40) - 20;
			left(turn2);
			forward(rand.nextInt(5) + 1);
			alpha += turn2;
			break;
		case 3:
			int turn3 = rand.nextInt(60) - 30;
			left(turn3);
			forward(rand.nextInt(5) + 1);
			alpha += turn3;
			break;
		case 4:
			int turn4 = rand.nextInt(80) - 40;
			left(turn4);
			forward(rand.nextInt(5) + 1);
			alpha += turn4;
			break;
		case 5:
			int turn5 = rand.nextInt(100) - 50;
			left(turn5);
			forward(rand.nextInt(5) + 1);
			alpha += turn5;
			break;
		}
	}

	public String toString() {
		return "Nummer " + nbr + " - DizzyTurtle (Dizziness: " + diz + ")";
	}
}
