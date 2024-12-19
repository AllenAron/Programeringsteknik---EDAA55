
public class Monster {
	private int hp;
	private int ap;
	private Monster m;

	public Monster(int temphp, int tempap) {
		hp=temphp;
		ap=tempap;
	}

	public void createMonster(Monster b) {
		b = new Monster(5, 2);
	}

	public int gethp() {
		return hp;
	}

	public int getap() {
		return ap;
	}

	public void sethp(int newhp) {
		hp = newhp;
	}

	public void setap(int newap) {
		ap = newap;
	}

}
