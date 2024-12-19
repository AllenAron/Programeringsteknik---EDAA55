package cardgame;

import pair.Pair;
import pair.PairSet;

// Illustration av hur man kan lösa uppgiften stegvis,
// så som diskuteras i handledarhäftet. Varje metod nedan
// beskriver ett sådant steg. Metoderna step1..step5
// föreställer alltså studentens main-metod i varje steg.

public class CardGameInSteps {

    private static final int NBR_ITERATIONS = 10000000;

    /** Första steget: skriv ut 52 kort. */
    public static void step1() {
        // Det här exemplet finns i uppgiftshäftet.

        PairSet seq = new PairSet(4, 13);

        while (seq.more()) {
            Pair p = seq.pick();
            System.out.println(p);
        }
    }

    /** Andra steget: lägg till talet 0->1->2->0->1->... i utskriften. */
    public static void step2() {
        // Raderna märkta *** är tillagda.

        PairSet seq = new PairSet(4, 13);

        int s = 0;                                          // ***
        while (seq.more()) {
            Pair p = seq.pick();
            System.out.println(p + " " + s);                // ändrad

            s++;                                            // ***
            if (s == 3) {                                   // ***
                s = 0;                                      // ***
            }                                               // ***
        }
    }

    /** Tredje steget: upptäck när patiensen inte går ut. */
    public static void step3() {
        // Raderna märkta *** är tillagda.

        PairSet seq = new PairSet(4, 13);

        int s = 0;
        while (seq.more()) {
            Pair p = seq.pick();
            System.out.println(p + " " + s);
            if (p.second() == s) {                          // ***
                System.out.println("gick inte ut");         // ***
                break;                                      // ***
            }                                               // ***

            s++;
            if (s == 3) {
                s = 0;
            }
        }
    }

    /** Fjärde steget: räkna hur många gånger patiensen inte går ut. */
    public static void step4() {
        // Utskrifterna är borttagna, och raderna märkta *** tillagda.

        int failures = 0;                                   // ***
        for (int i = 0; i < NBR_ITERATIONS; i++) {          // ***
            PairSet seq = new PairSet(4, 13);

            int s = 0;
            while (seq.more()) {
                Pair p = seq.pick();
                if (p.second() == s) {
                    failures++;                             // ***
                    break;
                }

                s++;
                if (s == 3) {
                    s = 0;
                }

            }
        }                                                   // ***

        System.out.println("failures=" + failures);         // ***
    }

    /** Femte steget: beräkna sannolikheten för att patiensen går ut. */
    public static void step5() {
        // Raderna märkta *** är tillagda.

        int failures = 0;
        for (int i = 0; i < NBR_ITERATIONS; i++) {
            PairSet seq = new PairSet(4, 13);

            int s = 0;
            while (seq.more()) {
                Pair p = seq.pick();
                if (p.second() == s) {
                    failures++;
                    break;
                }

                s++;
                if (s == 3) {
                    s = 0;
                }

            }
        }

        System.out.println("failures=" + failures);
        int successes = (NBR_ITERATIONS - failures);        // ***
        double prob = successes / (double) NBR_ITERATIONS;  // ***
        System.out.println("probability=" + prob);          // ***
    }

    public static void main(String[] args) {
        step5();
    }
}
