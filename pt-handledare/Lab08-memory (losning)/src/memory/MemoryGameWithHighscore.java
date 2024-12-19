package memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Lite större lösningsförslag, med rekordlista.
 */
public class MemoryGameWithHighscore {

    private static final int NBR_SCORES = 3;
    private static final String HIGHSCORE_FILE = "memory-highscore.dat";

    private static String[] FRONT_FILE_NAMES = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg",
            "mother_ladybird.jpg", "mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

    private ArrayList<Integer> highscores;

    /** Skapa ett spel och läs in rekorden från fil. */
    public MemoryGameWithHighscore() {
        highscores = new ArrayList<Integer>();

        try {
            Scanner scan = new Scanner(new File(HIGHSCORE_FILE));
            while (scan.hasNextInt()) {
                highscores.add(scan.nextInt());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            // om filen inte finns låter vi det bero:
            // den kommer att skapas när vi sparar rekorden
        }
    }

    /** Spara rekorden till fil. */
    public void saveHighscores() {
        try {
            PrintStream out = new PrintStream(new File(HIGHSCORE_FILE));
            for (int a : highscores) {
                out.println(a);
            }
            out.close();
        } catch (FileNotFoundException e) {
            // om filen inte gick att skapa är det skumt,
            // så då vill vi veta det
            System.err.println("oväntat fel:");
            System.err.println(e);
        }
    }

    /** Låt användaren spela en omgång av spelet. Antalet drag returneras. */
    public int play(MemoryBoard board, MemoryWindow w) {
        w.drawBoard();
        int numberOfMoves = 0;
        while (!board.hasWon()) {
            w.waitForMouseClick(); // vänd första kortet
            int r1 = w.getMouseRow();
            int c1 = w.getMouseCol();
            while (board.frontUp(r1, c1)) {
                w.waitForMouseClick();
                r1 = w.getMouseRow();
                c1 = w.getMouseCol();

            }
            board.turnCard(r1, c1);
            w.drawCard(r1, c1);

            w.waitForMouseClick(); // vänd andra kortet
            int r2 = w.getMouseRow();
            int c2 = w.getMouseCol();
            while (board.frontUp(r2, c2)) {
                w.waitForMouseClick();
                r2 = w.getMouseRow();
                c2 = w.getMouseCol();

            }
            board.turnCard(r2, c2);
            w.drawCard(r2, c2);

            if (!board.same(r1, c1, r2, c2)) {
                MemoryWindow.delay(1000);
                board.turnCard(r1, c1);
                w.drawCard(r1, c1);
                board.turnCard(r2, c2);
                w.drawCard(r2, c2);
            }
            numberOfMoves++;
        }

        return numberOfMoves;
    }

    /**
     * Visa antalet drag för användaren.
     * Uppdatera rekordlistan och spara den på fil.
     */
    public void showScore(int score) {
        // ta reda på plats på listan
        int pos = 0;
        while (pos < highscores.size() && score >= highscores.get(pos)) {
            pos++;
        }
        highscores.add(pos, score);
        while (highscores.size() > NBR_SCORES) {
            highscores.remove(highscores.size() - 1);
        }

        saveHighscores();

        StringBuilder sb = new StringBuilder();
        if (!highscores.isEmpty()) {
            sb.append("rekordlista:\n\n");
            for (int i = 0; i < highscores.size(); i++) {
                sb.append(highscores.get(i));
                if (i == pos) {
                    sb.append("  <<< nytt rekord!");
                }
                sb.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "antal drag: " + score, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        MemoryGameWithHighscore memory = new MemoryGameWithHighscore();
        while (true) {

            MemoryBoard mb = new MemoryBoard(4, "back.jpg", FRONT_FILE_NAMES);
            MemoryWindow mw = new MemoryWindow(mb);

            int n = memory.play(mb, mw);
            memory.showScore(n);
            mw.close();
        }
    }
}
