public class MoleTurtle extends RaceTurtle {
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	@Override
	public void raceStep() {
		if (rand.nextBoolean()) {
			penUp();
		} else {
			penDown();
		}
		super.raceStep();
	}

	@Override
	public String toString() {
		return super.toString() + " - MoleTurtle";
	}

}
