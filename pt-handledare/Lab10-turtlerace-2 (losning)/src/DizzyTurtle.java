/**
 * En vinglig sköldpadda som minns sin ursprungliga Y-koordinat och försöker
 * hålla sig i närheten av den. Har en viss tendens till självsvängning.
 */
public class DizzyTurtle extends RaceTurtle {
	private int dizziness;
	private int correctY;

	public DizzyTurtle(RaceWindow w, int nbr, int dizziness) {
		super(w, nbr);
		this.dizziness = dizziness;
		correctY = getY();
	}

	@Override
	public void raceStep() {
		if (Math.abs(getY() - correctY) < 5) {
			// någorlunda på banan
			left((rand.nextInt(3) - 1) * dizziness);
		} else {
			// av banan
			left(getY() > correctY ? 2 : -2);
		}

		super.raceStep();
	}

	@Override
	public String toString() {
		return super.toString() + " - DizzyTurtle (yrhetsgrad " + dizziness
				+ ")";
	}

}
