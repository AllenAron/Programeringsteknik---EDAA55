package memory;

import javax.swing.JOptionPane;

public class MemoryGame {	
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		MemoryBoard mb = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow sw = new MemoryWindow(mb);

		sw.drawBoard();
		int numberOfMoves = 0;
		while (!mb.hasWon()) {
			sw.waitForMouseClick();  // turn first card
			int r1 = sw.getMouseRow();
			int c1 = sw.getMouseCol();
			while (mb.frontUp(r1, c1)) {
				sw.waitForMouseClick();
				r1 = sw.getMouseRow();
				c1 = sw.getMouseCol();

			}
			mb.turnCard(r1, c1);
			sw.drawCard(r1, c1);

			sw.waitForMouseClick();  // turn second card
			int r2 = sw.getMouseRow();
			int c2 = sw.getMouseCol();
			while (mb.frontUp(r2, c2)) {
				sw.waitForMouseClick();
				r2 = sw.getMouseRow();
				c2 = sw.getMouseCol();

			}
			mb.turnCard(r2, c2);
			sw.drawCard(r2, c2);
	
			if (! mb.same(r1, c1, r2, c2)) {
				MemoryWindow.delay(1000);
				mb.turnCard(r1, c1);
				sw.drawCard(r1, c1);
				mb.turnCard(r2, c2);
				sw.drawCard(r2, c2);
			}
			numberOfMoves ++;
		}

		JOptionPane.showMessageDialog(null, numberOfMoves + " drag", "Du klarade det!", JOptionPane.INFORMATION_MESSAGE);	
		
	}
}
