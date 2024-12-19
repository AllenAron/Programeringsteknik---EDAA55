public class Mole {
	Graphics g = new Graphics(150, 80, 10);

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}
	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;
		while (true) {
			if (x > 150) {
				x -= 1;
			}
			if (x < 0) {
				x += 1;
			}
			if (y > 80) {
				y -= 1;
			}
			if (y < 19) {
				y += 1;
			}
			if (y > 18) {
				g.block(x, y, Colors.MOLE);
			}
			char key = g.waitForKey();
			if (y > 19) {
				g.block(x, y, Colors.TUNNEL);
			} else {
				g.block(x, y, Colors.SKY);
			}
			if (key == 'w') {
				y -= 1;
			} else if (key == 'a') {
				x -= 1;
			}

			else if (key == 's') {
				y += 1;
			} else if (key == 'd') {
				x += 1;
			}
			g.moveTo(x, y);
		}
	}
	private void drawWorld() {
		g.rectangle(0, 0, 150, 20, Colors.SKY);
		g.rectangle(0, 20, 150, 25, Colors.GRASS);
		g.rectangle(0, 25, 150, 80, Colors.SOIL);
	}

	

}
