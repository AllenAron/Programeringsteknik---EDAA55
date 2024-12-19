public class Character {
	private int hp;
	private int ap;
	private int kills;
	private String name;
	private Character c;
	Nbrgenerator n = new Nbrgenerator();
	Monster m = new Monster(0, 0);

	public Character(String ne, int tempkills, int temphp, int tempap) {
		name = ne;
		kills = tempkills;
		hp = temphp;
		ap = tempap;
	}

	public void createCharacter(Character c) {
		c = new Character(name, 0, 5, 5);
	}

	public void move(Monster m) {
		m.sethp(n.getNbr(5));
		m.setap(n.getNbr(5));
	}

	public void loot(Monster m) {
		this.setap(this.getap() + m.getap());
		m.setap(0);
	}

	public void pannkaka() {
		sethp(gethp() + 2);
	}

	public int gethp() {
		return hp;
	}

	public int getap() {
		return ap;
	}

	public int getkills() {
		return kills;
	}

	public void sethp(int newhp) {
		hp = newhp;
	}

	public void setap(int newap) {
		ap = newap;
	}

	public void setkills(int newkills) {
		kills = newkills;
	}
}
