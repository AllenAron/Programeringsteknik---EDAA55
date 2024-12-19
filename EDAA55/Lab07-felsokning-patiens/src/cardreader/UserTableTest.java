package cardreader;

public class UserTableTest {
	public static void main(String[] args) {
	UserTable ut = new UserTable();
	User u = new User (1234, "Hilbert Älg");
	User v = new User (6122, "Nils Thorin");
	ut.add(u);
	ut.add(v);
	System.out.println(ut.find(24073));
	System.out.println(ut.find(24074));
	System.out.println(ut.findByName("Nils Thorin"));
	System.out.println(ut.testFind());
	
	
	}

}
