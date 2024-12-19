import java.util.Scanner;
public class Nollning2022 {
	boolean fullmåne = true;
	boolean lessthanthree = true;
	

	public static void main(String[] args) {
		boolean astrologi = false;
		boolean astronomi = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vad heter överföset?");
		String överfös = överfösgenerator(scanner.next());
		while (mercury_retrograde()==true) {
		System.out.println(överfös);
		}
		
		

	}
	public static boolean mercury_retrograde() {
		boolean orbit = true;
		return orbit;
		}
	
	public static String överfösgenerator(String s) {
		return "Överkronk";
	}
	
}
