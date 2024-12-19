package memory;

import java.awt.Image;
import java.util.Random;

public class MemoryBoard {
	Image front;
	Image back;
	MemoryCardImage[][] board;
	Random rand = new Random();
	int size;
	MemoryCardImage deck;
	MemoryCardImage card;
	boolean[][] status;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		board = new MemoryCardImage[size][size];
		status = new boolean[size][size];
		createCards(backFileName, frontFileNames);
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		int n = size * size;
		MemoryCardImage[] deck = new MemoryCardImage[n];
		for (int i = 0; i < size * size / 2; i++) {
			MemoryCardImage card = new MemoryCardImage(frontFileNames[i], backFileName);
			deck[i] = card;
			deck[i + size * size / 2] = card;
		}
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				int randNbr = rand.nextInt(n);
				board[r][c] = deck[randNbr];
				deck[randNbr] = deck[n - 1];
				n--;
				status[r][c] = false;
			}
		}

	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		MemoryCardImage temp = getCard(r, c);
		Image flip = temp.getFront();
		front = getCard(r, c).getBack();
		back = flip;
		if (!status[r][c]) {
			status[r][c] = true;
		} else {
			status[r][c] = false;
		}

	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return status[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (getCard(r1, c1) == getCard(r2, c2)) {
			return true;
		} else {
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (!status[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}
