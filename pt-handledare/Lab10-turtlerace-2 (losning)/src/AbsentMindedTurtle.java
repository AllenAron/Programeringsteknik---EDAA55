public class AbsentMindedTurtle extends RaceTurtle {
	private int absentmindedness;
	
	public AbsentMindedTurtle(RaceWindow w, int nbr, int absentmindedness) {
		super(w, nbr);
		this.absentmindedness = absentmindedness;
	}

	@Override
	public void raceStep() {
		if (rand.nextInt(100) >= absentmindedness) {
			super.raceStep();
		}
	}

	@Override
	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + absentmindedness + "% frånvarande)";
	}
}
