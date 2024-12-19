package bank;

public class BankAccount {
	private static int nextAccountNumber = 1001;
	private final int accountNumber;
	private Customer holder;
	private double balance;
	
	public BankAccount(String holderName, long holderId) {
		this(new Customer(holderName, holderId));
	}
	
	public BankAccount(Customer holder) {
		this.accountNumber = nextAccountNumber++;
		this.holder = holder;
		this.balance = 0;
	}

	public Customer getHolder() {
		return holder;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getAmount() {
		return balance;
	}
	
	public void setAmountXXX(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public String toString() {
		return "konto " + accountNumber + " (" + holder + "): " + balance;
	}
}
