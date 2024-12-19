package bank;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	private Bank bank;
	private final Scanner s = new Scanner(System.in);

	public BankApplication() {
		bank = new Bank();
	}

	private BankAccount lookupAccount(String prompt) {
		int number = readInt(prompt);
		BankAccount b = bank.findByNumber(number);
		return b;
	}

	private void printList(List<?> list) {
		for (Object o : list) {
			println(o);
		}
	}

	public void runApplication() {
		while (true) {
			println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			println("1. Hitta konto utifrån innehavare");
			println("2. Sök kontoinnehavare utifrån (del av) namn");
			println("3. Sätt in");
			println("4. Ta ut");
			println("5. Överföring");
			println("6. Skapa konto");
			println("7. Ta bort konto");
			println("8. Skriv ut konton");
			println("9. Avsluta");
			
			// try...catch nedan hanterar fallet när användaren skriver in text när ett tal förväntas.
			// Studenterna behöver inte göra detta. I så fall kommer man att få NumberFormatException om man
			// exempelvis anger "tre" istället för "3" i menyn, och det är alltså okej i denna uppgift.

			try { 
				int choice = readInt("val: ");
				s.nextLine(); // klurigt: se Downey & Mayfield, "the Scanner bug"
				switch (choice) {
				case 1:
					printList(bank.findAccountsForHolder(readLong("id: ")));
					break;
				case 2:
					printList(bank.findByPartOfName(readLine("namn: ")));
					break;
				case 3: {
					BankAccount account = lookupAccount("konto: ");
					if (account == null) {
						println("kontot saknas!");
						break;
					}
					account.deposit(readDouble("belopp att sätta in: "));
					println(account);
					break;
				}
				case 4: {
					BankAccount account = lookupAccount("från konto: ");
					if (account == null) {
						println("kontot saknas!");
						break;
					}

					double amount = readDouble("belopp att ta ut: ");
					if (amount <= account.getAmount()) {
						account.withdraw(amount);
						println(account);
					} else {
						println("uttaget misslyckades, endast "
								+ account.getAmount() + " på kontot!");
					}
					break;
				}
				case 5:
					BankAccount src = lookupAccount("från konto: ");
					if (src == null) {
						println("kontot saknas!");
						break;
					}
					BankAccount dst = lookupAccount("till konto: ");
					if (dst == null) {
						println("kontot saknas!");
						break;
					}
					double amount = readDouble("belopp att överföra: ");
					if (amount <= src.getAmount()) {
						src.withdraw(amount);
						dst.deposit(amount);
						println(src);
						println(dst);
					} else {
						println("överföringen misslyckades, endast "
								+ src.getAmount() + " på kontot!");
					}
					break;
				case 6:
					String name = readLine("namn: ");
					long idNr = readLong("id: ");
					int number = bank.addAccount(name, idNr);
					println("konto skapat: " + number);
					break;
				case 7: {
					int accountNbr = readInt("konto: ");
					if (!bank.removeAccount(accountNbr)) {
						println("felaktigt kontonummer!");
					}
					break;
				}
				case 8:
					printList(bank.getAllAccounts());
					break;
				case 9:
					return;
				default:
					println("Felaktigt val.");
					break;
				}
			} catch (Exception e) {
			    // felhantering 
				println("fel: " + e);

				// användaren har skrivit fel: ignorera resten av raden
				s.nextLine();
			}
		}
	}

	// -----------------------------------------------------------------------

	// Dessa hjälpmetoder har deklarerats protected för att vi ska kunna
	// överskugga dem i ScriptedBankApplication (som inte tillhör inte uppgiften)

	protected int readInt(String prompt) {
	    System.out.print(prompt);
        return s.nextInt();
    }

    protected long readLong(String prompt) {
        System.out.print(prompt);
        return s.nextLong();
    }

    protected double readDouble(String prompt) {
        System.out.print(prompt);
        return s.nextDouble();
    }

    protected String readLine(String prompt) {
        System.out.print(prompt);
        return s.nextLine();
    }
	
	protected void println(Object o) {
		System.out.println(o.toString());
	}

	// -----------------------------------------------------------------------

	public static void main(String[] args) throws IOException {
		new BankApplication().runApplication();
	}
}
