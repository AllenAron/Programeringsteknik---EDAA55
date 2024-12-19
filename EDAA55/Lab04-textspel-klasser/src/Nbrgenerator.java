import java.util.Random;

public class Nbrgenerator {
	public int getNbr(int a) {
		Random random = new Random();
		int nbr = random.nextInt(a)+1;
		return nbr;
	}

}
