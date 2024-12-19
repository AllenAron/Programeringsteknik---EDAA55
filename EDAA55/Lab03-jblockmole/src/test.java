import java.util.Random;
public class test {

	public static void main(String[] args) {
		Random rand = new Random();
		while (true) {
		int nbr = rand.nextInt(6)+10;
			System.out.println(nbr);
		}
	}
}
