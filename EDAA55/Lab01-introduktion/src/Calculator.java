import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		double sum = nbr1 + nbr2;
		double dif = nbr1 - nbr2;
		double prod = nbr1 * nbr2;
		double frac = nbr1/nbr2;
		System.out.println("Summan av talen är " + sum + "\nSkillnaden mellan talen är " + dif  + "\nProdukten av talen är " + prod  + "\nKvoten av talen är " + frac);
	
	}
}
