
public class Mole {
	private Graphics g = new Graphics(30, 50, 10);

	/*
	 * Nedanstående variabler kan med fördel deklareras som konstanter, dvs
	 * exempelvis
	 * 
	 * private static final int SKY_LIMIT = 10;
	 * 
	 * Men det är inte så viktigt just nu.
	 */
	private int skyLimit = 10;
	private int grassHeigth = 2;

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, skyLimit + grassHeigth, g.getWidth(), g.getHeight(), Colors.SOIL);
		g.rectangle(0, 0, g.getWidth(), skyLimit, Colors.SKY);
		g.rectangle(0, skyLimit, g.getWidth(), grassHeigth, Colors.GRASS);
	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;
		while (true) {
			if (x >= g.getWidth()) {
				x = x - 1;
			} else if (x < 0) {
				x = x + 1;
			}

			if (y >= g.getHeight()) {
				y = y - 1;
			} else if (y <= skyLimit) {
				g.block(x, y, Colors.GRASS);
				y = y + 1;
			}

			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();

			if (y >= skyLimit + grassHeigth) {
				g.block(x, y, Colors.TUNNEL);
			} else {
				g.block(x, y, Colors.GRASS);
			}

			if (key == 'w') {
				y = y - 1;
			} else if (key == 'a') {
				x = x - 1;
			} else if (key == 's') {
				y = y + 1;
			} else if (key == 'd') {
				x = x + 1;
			}
			g.block(x, y, Colors.MOLE);
		}
	}
}
