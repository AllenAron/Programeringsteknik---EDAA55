package memory;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {

	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow mw = new MemoryWindow(board);
		int size = board.getSize();
		mw.drawBoard();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				mw.drawCard(r, c);
			}
		}
		int n = 0;
		while (!board.hasWon()) {
			mw.waitForMouseClick();
			int c1 = mw.getMouseCol();
			int r1 = mw.getMouseRow();
			if (!board.frontUp(r1, c1)) {
				board.turnCard(r1, c1);
				mw.drawCard(r1, c1);
				mw.waitForMouseClick();
				int c2 = mw.getMouseCol();
				int r2 = mw.getMouseRow();
				while(board.frontUp(r2,c2)) {
					mw.waitForMouseClick();
					c2 = mw.getMouseCol();
					r2 = mw.getMouseRow();
				}
				if (!board.frontUp(r2, c2)) {
					board.turnCard(r2, c2);
					mw.drawCard(r2, c2);
					
				}
				if (!board.same(r1, c1, r2, c2)) {
					mw.delay(1000);
					board.turnCard(r1, c1);
					mw.drawCard(r1, c1);
					board.turnCard(r2, c2);
					mw.drawCard(r2, c2);
					
				}
			}
			n++;
		}
		System.out.println("Du vann! Du tog" + " " + n + " " + "försök på dig.");
	}
}
