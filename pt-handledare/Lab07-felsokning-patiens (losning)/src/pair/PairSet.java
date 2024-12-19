package pair;

import java.util.Random;

public class PairSet {
	private int n;
	private Pair[] pairs;
	private Random rand = new Random(); // kan vara static; spelar ingen roll

	/** Skapar en mängd av alla talpar (a,b) sådana att
	    0 <= a < rows  och  0 <= b < cols */
	public PairSet(int rows, int cols) {
		n = rows * cols;
		pairs = new Pair[n];

		int pos = 0;
		for (int a = 0; a < rows; a++) {
			for (int b = 0; b < cols; b++) {
				pairs[pos] = new Pair(a, b);
				pos++;
			}
		}
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		return n > 0;
	}

	/** Hämtar ett slumpmässigt valt talpar ur mängden. Mängden
    	blir ett element mindre. Om mängden är tom returneras null. */
	public Pair pick() {
		if (n > 0) {
			int idx = rand.nextInt(n);
			Pair p = pairs[idx];
			pairs[idx] = pairs[n - 1];
			pairs[n - 1] = null; // ej nödvändigt
			n--;
			return p;
		} else {
			return null;
		}
	}
}
