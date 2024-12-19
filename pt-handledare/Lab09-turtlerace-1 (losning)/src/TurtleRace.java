import java.util.*;

public class TurtleRace {
	public static final int NBR_TURTLES = 8;

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		List<RaceTurtle> racelist = new ArrayList<RaceTurtle>();

		for (int i = 1; i <= NBR_TURTLES; i++) {
			racelist.add(new RaceTurtle(w, i));
		}

		List<RaceTurtle> winners = new ArrayList<RaceTurtle>();

		while (racelist.size() > 0) {
			for (int i = 0; i < racelist.size(); i++) {
				RaceTurtle t = racelist.get(i);
				t.raceStep();
				if (t.getX() > RaceWindow.X_END_POS) {
					winners.add(t);
					racelist.remove(t);
					i--; // VIKTIGT
				}
			}
			RaceWindow.delay(20);
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + winners.get(i));
		}
	}
}
