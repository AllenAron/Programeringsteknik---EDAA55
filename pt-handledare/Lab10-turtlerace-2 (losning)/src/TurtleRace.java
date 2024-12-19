import java.util.*;

public class TurtleRace {
	public static final int NBR_TURTLES = 8;

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		List<RaceTurtle> racelist = new ArrayList<RaceTurtle>();
		Random rand = new Random();

		for (int i = 1; i <= NBR_TURTLES; i++) {
			switch (rand.nextInt(3)) {
			case 0:
				racelist.add(new MoleTurtle(w, i));
				break;
			case 1:
				racelist.add(new AbsentMindedTurtle(w, i, rand.nextInt(100)));
				break;
			case 2:
				racelist.add(new DizzyTurtle(w, i, 1 + rand.nextInt(5)));
				break;
			}
		}

		for (RaceTurtle t : racelist) {
			System.out.println(t);
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
			RaceWindow.delay(5);
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + winners.get(i));
		}
	}
}
