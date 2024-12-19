import java.util.Scanner;

public class Textspel {
	Character c;
	Monster m;
	Nbrgenerator n = new Nbrgenerator();

	public static void main(String[] args) {
		Textspel adv = new Textspel();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please name your character!");
		String name = scan.next();
		Character c = new Character(name, 0, 5, 2);
		Monster m = new Monster(3, 2);
		m.createMonster(m);
		c.createCharacter(c);
		while (true) {
			System.out.println("What do you want to do?");
			String input = scan.next();
			if (input.equals("attack")) {
				if (adv.attack(c, m) == 3) {
					System.out.println("There is no monster, stop attacking the air!");
				} else if (adv.attack(c, m) == 2) {
					System.out.println("You killed the monster but still took damage");
					c.sethp(c.gethp() - m.getap());
					c.setkills(c.getkills() + 1);
					if (c.getap() > m.gethp()) {
						m.sethp(0);
					} else {
						m.sethp(m.gethp() - c.getap());
					}

				} else if (adv.attack(c, m) == 1) {
					System.out.println("You inflicted damage but the monster didn't die");
					c.sethp(c.gethp() - m.getap());
					m.sethp(m.gethp() - c.getap());
				} else {
					System.out.println("Du dog :(");
					break;
				}
			}

			if (input.equals("stats")) {
				System.out.println("Namn:" + name + '\n' + "Kills:" + c.getkills() + '\n' + "HP:" + c.gethp() + '\n'
						+ "AP:" + c.getap());
			}
			if (input.equals("m.stats")) {
				System.out.println("HP:" + m.gethp() + '\n' + "AP:" + m.getap());
			}
			if (input.equals("pannkaka")) {
				c.pannkaka();
				System.out.println("mmm...pannkaka!");
				System.out.println("You restore 2 hp");
			}
			if (input.equals("move")) {
				c.move(m);
				System.out.println("A new challenger approaches!");
			}
			if (input.equals("loot")) {
				if (m.gethp() == 0) {
					if (m.getap() == 0) {
						System.out.println("You loot the monster but you can not find anything useful");
					} else {
						c.loot(m);
						System.out.println("You loot the monster and finds it weapon!");
					}

				} else {
					System.out.println("The monster is not dead yet, you have to kill it before you loot it!");
				}
			}
			if (input.equals("?")) {
				adv.help();
			}
		}
	}

	public void move() {
		m.sethp(n.getNbr(5));
		m.setap(n.getNbr(5));
	}

	public void help() {
		String stats = "To find the stats of your character, write \"stats\"";
		String mstats = "To find the stats of the monster, write \"m.stats\"";
		String attack = "To attack the monster, write \"attack\"";
		String move = "To move and fight a new monster, write \"move\"";
		String loot = "To loot the monster you just killed, write \"loot\"";
		String pannkaka = "To heal your character, write \"pannkaka\"";
		System.out.println(stats + '\n' + mstats + '\n' + attack + '\n' + move + '\n' + loot + '\n' + pannkaka);
	}

	public int attack(Character c, Monster m) {
		if (m.gethp() == 0) {
			return 3;
		} else if (c.getap() >= m.gethp() && c.gethp() > m.getap()) {
			return 2;
		} else if (c.getap() < m.gethp() && c.gethp() > m.getap()) {
			return 1;
		} else {
			return 0;
		}
	}
}
