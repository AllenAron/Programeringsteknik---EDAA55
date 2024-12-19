package bank;

public class Customer {
	private final String name;
	private final long idNr;
	private final int customerNbr;
	private static int nextCustomerNbr = 101;
	
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.customerNbr = nextCustomerNbr ++;
	}
	
	public String getName() {
		return name;
	}
	
	public long getIdNr() {
		return idNr;
	}
	
	public long getCustomerNr() {
		return customerNbr;
	}
	
	public String toString() {
		return name + ", id " + idNr + ", kundnr " + customerNbr;
	}
}
