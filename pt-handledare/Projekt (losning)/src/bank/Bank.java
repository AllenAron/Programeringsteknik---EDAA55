package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private final ArrayList<BankAccount> accounts;
	
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}
	
	public int addAccount(String holderName, long idNr) {
		Customer holder = findCustomerByIdNr(idNr);
		if (holder == null) {
			holder = new Customer(holderName, idNr);
		}
		
		BankAccount account = new BankAccount(holder);
		accounts.add(account);
		return account.getAccountNumber();
	}
	
	public Customer findHolder(int number) {
		BankAccount account = findByNumber(number);
		if (account != null) {
			return account.getHolder();
		}

		return null;
	}
	
	/** @return true if account could be removed, false if it didn't exist */
	public boolean removeAccount(int number) {
		BankAccount account = findByNumber(number);
		if (account != null) {
			return accounts.remove(account);
		}
		
		return false;
	}

	public List<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		
		for (BankAccount account : accounts) {
			int i;
			for (i = 0; i < sorted.size(); i++) {
				if (sorted.get(i).getHolder().getName().compareToIgnoreCase(account.getHolder().getName()) > 0) {
					sorted.add(i, account);
					break;
				}
			}
			if (i >= sorted.size()) {
				sorted.add(account);
			}
		}
		
		return sorted;
	}

	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		
		return null;
	}
	
	public List<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> result = new ArrayList<BankAccount>();
		for (BankAccount account : accounts) {
			if (account.getHolder().getIdNr() == idNr) {
				result.add(account);
			}
		}
		return result;
	}
	
	public List<Customer> findByPartOfName(String namePart) {
		// komplexitet O(n^2): kan åtgärdas med separat kundlista
	    // (spelar i praktiken ingen roll här)
		ArrayList<Customer> result = new ArrayList<Customer>();
		for (BankAccount account : accounts) {
			Customer holder = account.getHolder();
			if (holder.getName().toLowerCase().contains(namePart.toLowerCase())) { //  && !result.contains(holder)) {
				result.add(holder);
			}
		}
		return result;
	}
	
	// =================================================================
	
	private Customer findCustomerByIdNr(long idNr) {
		for (BankAccount account : accounts) {
			Customer holder = account.getHolder();
			if (holder.getIdNr() == idNr) {
				return holder;
			}
		}
		
		return null;
	}
}
