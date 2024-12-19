package pair;

public class onetwothree {
	private static final int NBR_ITERATIONS = 1000000;

	public static void main(String[] args) {
		/*
		 * Patiensen 1–2–3 läggs på följande sätt: Man tar en kortlek, blandar den och
		 * lägger sedan ut korten ett efter ett. Samtidigt som man lägger korten räknar
		 * man 1–2–3–1–2–. . . , det vill säga när man lägger det första kortet säger
		 * man 1, när man lägger det andra kortet säger man 2, osv. Patiensen går ut om
		 * man lyckas lägga ut alla kort i leken utan att någon gång få upp ett ess när
		 * man säger 1, någon 2-a när man säger 2 eller någon 3-a när man säger 3.
		 */
		double losses = 0;

		for (int i = 0; i < NBR_ITERATIONS; i++) {
			PairSet deck = new PairSet(4, 13);
			boolean status = true;
			while (deck.more() && status) {
				for (int j = 0; j < 3; j++) {
					Pair pickedpair = deck.pick();
					if (pickedpair.second() == j) {
						status = false;
						losses++;
						break;
					}
					if (!deck.more()) {
						break;
					}
				}
			}
		}
		double prob = (NBR_ITERATIONS - losses) / NBR_ITERATIONS;
		System.out.println("Sannolikheten att vinna är: " + prob);
	}

}
