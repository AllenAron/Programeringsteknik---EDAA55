package memory;
import java.util.Random;

// import pair.Pair;
// import pair.PairSet;

public class MemoryBoard {
	public int size;
	private MemoryCardImage[][] cards;
	private boolean[][] turned; 

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
    	för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
    	för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		cards = new MemoryCardImage[size][size];
		turned = new boolean[size][size];
		
		createCards(backFileName, frontFileNames);
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		for (int i = 0; i < frontFileNames.length; i++) {
			MemoryCardImage mi = new MemoryCardImage(frontFileNames[i], backFileName);
			for (int k = 0; k < 2; k++) {
				int row = rand.nextInt(size);
				int col = rand.nextInt(size); 
				while (cards[row][col] != null){
					row = rand.nextInt(size);
					col = rand.nextInt(size);
				} 
				cards[row][col] = mi;
			}
		}
	}

	/* Alternativ lösning för createCards (uppgift 5):
	   använd PairSet för att placera ut korten effektivare.
	   Utkommenterad eftersom EDAA20 inte har PairSet */
//	private void createCards2(String backFileName, String[] frontFileNames) {
//		PairSet seq = new PairSet(size, size);
//		for (int i = 0; i < frontFileNames.length; i++) {
//			MemoryCardImage mi = new MemoryCardImage(frontFileNames[i], backFileName);
//			for (int k = 0; k < 2; k++) {
//                Pair p = seq.pick();
//				cards[p.first()][p.second()] = mi;
//			}
//		}
//	}
	
	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return cards[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		turned[r][c] = ! turned[r][c];
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return turned[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return cards[r1][c1] == cards[r2][c2];
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (! turned[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}
