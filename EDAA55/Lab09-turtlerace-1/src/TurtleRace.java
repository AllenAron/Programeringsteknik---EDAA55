import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> start = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finished = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		for (int i = 1; i <= 8; i++) {
			RaceTurtle turtle = new RaceTurtle(w, i);
			start.add(turtle);
		}

		w.waitForMouseClick();

		while (!start.isEmpty()) {
			for (int i = 0; i < start.size(); i++) {
				if (start.get(i).getX() < RaceWindow.X_END_POS) {
					start.get(i).raceStep();
				} else {
					finished.add(start.get(i));
					start.remove(start.get(i));

				}
			}
			RaceWindow.delay(10);
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + finished.get(i));
		}

	}
}
