package cardreader;

public class UserTableTest {

	public static void main(String[] args) {
		UserTable table = new UserTable();

		// deluppgift 3: lägg in en ny användare
		table.add(new User(1234, "Alfons Åberg"));
		table.print();

		// i deluppgift 2 skriver följande två rader ut null
		System.out.println(table.find(24073)); // löses i deluppgift 4
		System.out.println(table.findByName("Jens Holmgren")); // löses i deluppgift 5
		
		// deluppgift 6
		int nbr = table.testFind();
		if (nbr != 0) {
			System.out.println("binärsökningen misslyckades på kort " + nbr);
		} else {
			System.out.println("binärsökningen fungerar.");
		}
	}
}
