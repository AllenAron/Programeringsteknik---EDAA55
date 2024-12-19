import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> start = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finished = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		Random rand = new Random();
		for (int i = 1; i <= 8; i++) {
			switch (rand.nextInt(4)) {
			case 0:
				RaceTurtle rt = new RaceTurtle(w, i);
				start.add(rt);
				break;
			case 1:
				MoleTurtle mt = new MoleTurtle(w, i);
				start.add(mt);
				break;
			case 2:
				AbsentMindedTurtle amt = new AbsentMindedTurtle(w, i, rand.nextInt(100));
				start.add(amt);
				break;
			case 3:
				DizzyTurtle dt = new DizzyTurtle(w, i, rand.nextInt(4) + 1);
				start.add(dt);
				break;
			}

		}
		for (int i = 0; i < 8; i++) {
			System.out.println(start.get(i));
		}

		w.waitForMouseClick();

		while (!start.isEmpty()) {
			for (int i = 0; i < start.size(); i++) {
				if (start.get(i).getX() < RaceWindow.X_END_POS) {
					start.get(i).raceStep();
				} else {
					finished.add(start.get(i));
					start.remove(start.get(i));
					i--;

				}
			}
			RaceWindow.delay(10);
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + finished.get(i));
		}

	}
}
