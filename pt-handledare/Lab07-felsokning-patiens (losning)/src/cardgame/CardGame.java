package cardgame;

import pair.Pair;
import pair.PairSet;

public class CardGame {
	private static final int NBR_ITERATIONS = 10000000;

	public static void main(String[] args) {
		int failures = 0;
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < NBR_ITERATIONS; i++) {
			PairSet seq = new PairSet(4, 13);

			int counter = 0; // index för kort 1
			while (seq.more()) {
				Pair p = seq.pick();
				if (p.second() == counter) {
					failures++;
					break;
				}
				counter = (counter + 1) % 3;
			}
		}
		long t1 = System.currentTimeMillis();
		System.out.println("Success rate: " + (1 - (failures / (double) NBR_ITERATIONS)));
		System.out.println("Execution time: " + (t1 - t0) + "ms");
	}
}
