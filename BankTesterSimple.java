/**
 * Banking program that simulates the operation of a local bank.
 * 
 * @version Assignment #2, 19 February 2014
 */

public class BankTesterSimple{
	
	public static void main(String[] args){

		// Creating custom Customer objects
		Customer c1 = new Adult("Logica Machina", "Preferrably Anywhere But Columbus GA", 99, "1234567890", "1");

		// Creating custom Account objects 
		Account a1 = new SavingsAccount(c1, 100, "11");

		// Creating default Bank object
		Bank myBank = new Bank();

		// The method processTran in the Transaction class will perform the task of creating a 
		// transaction object and initializing it whenever a new transaction (e.g., a deposit 
		// or withdrawal) takes place on an account object. It will then add this transaction 
		// to the transaction array
		//Creating a bogus transaction which I'm sure most financial institutes would consider shady
		Transaction securityLeak = new Transaction();

		// Adding account to the bank
		myBank.addAccount(a1);
		
		String find = "11";
		
		try{
			// Making a deposit into an account
			myBank.makeDeposit(securityLeak, myBank.getAccount(find), "deposit", 12, "01012001", "No extra fees");

			// Making a withdrawal from an account
			myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 13, "02022002", "No extra fees");

			// Making another deposit into an account
			myBank.makeDeposit(securityLeak, myBank.getAccount(find), "deposit", 50.25, "01012001", "No extra fees");


			// Making another withdrawal from an account
			myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 0.25, "02022002", "No extra fees");


			// Print account information		
			System.out.println(myBank.getAccount(find));
		}catch(NullPointerException e){
			System.out.println("Account number " + find + " does not exist!");
		}
	}
}
