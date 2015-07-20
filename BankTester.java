/**
 * Banking program that simulates the operation of a local bank.
 * 
 * @version Assignment #2, 19 February 2014
 */

public class BankTester {

	private static final boolean TESTING = false; // or false to disable

	public static void main(String[] args){

		// Creating custom Customer objects
		Customer c1 = new Adult("Logica Machina", "Preferrably Anywhere But Columbus GA", 99, "1234567890", "1");

		if(TESTING){
			System.out.println("******* TESTING TOSTRING() FOR CUSTOMER CLASS *******");
			System.out.println(c1);
			System.out.println("******************************************************\n\n");
		}

		Customer c2 = new Adult("Logica", "100 Confused Street", 18, "1234567890", "2");
		Customer c3 = new Student("Logica", "100 Really Confused Street", 13, "1234567890", "3");
		Customer c4 = new Student("Logica", "100 Frustrated Street", 25, "1234567890", "4");
		Customer c5 = new Student("Logica", "100 Discouraged Street", 18, "1234567890", "5");
		Customer c6 = new Senior("Logica", "100 Perplexed Street", 65, "1234567890", "6");
		Customer c7 = new Senior("Logica", "100 Ulcer Avenue", 125, "1234567890", "7");
		Customer c8 = new Senior("Logica", "100 Headache Boulevard", 85, "1234567890", "8");

		if(TESTING){
			Customer c9 = new Adult("Logica", "100 Confused Street", 12, "1234567890", "9");

			System.out.println("******* TESTING AGE VERIFICATION FOR ADULT CLASS *******");
			System.out.println("**** This should have triggered an error message. ****");
			System.out.println("The age for this customer should have been set to 18.");
			System.out.println("The age of this customer is " + c3.getAge());
			System.out.println("******************************************************\n\n");

			Customer c10 = new Student("Logica", "100 Confused Street", 26, "1234567890", "10");

			System.out.println("******* TESTING AGE VERIFICATION FOR STUDENT CLASS *******");
			System.out.println("**** This should have triggered an error message. ****");
			System.out.println("The age for this customer should have been set to 13.");
			System.out.println("The age of this customer is " + c7.getAge());
			System.out.println("******************************************************\n\n");

			Customer c11 = new Senior("Logica", "100 Confused Street", 135, "1234567890", "11");

			System.out.println("******* TESTING AGE VERIFICATION FOR SENIOR CLASS *******");
			System.out.println("**** This should have triggered an error message. ****");
			System.out.println("The age for this customer should have been set to 65.");
			System.out.println("The age of this customer is " + c11.getAge());
			System.out.println("******************************************************\n\n");
		}

		// Creating custom Account objects 
		Account a1 = new SavingsAccount(c1, 100, "11");
		if(TESTING){
			System.out.println("******** TESTING TOSTRING() FOR ACCOUNT CLASS ********");
			System.out.println(a1);
			System.out.println("******************************************************\n\n");
		}
		Account a2 = new SavingsAccount(c2, 100, "12");
		Account a3 = new SavingsAccount(c3, 100, "13");
		Account a4 = new SavingsAccount(c4, 100, "14");
		Account a5 = new SavingsAccount(c5, 100, "15");
		Account a6 = new SavingsAccount(c6, 100, "16");
		Account a6Copy = new SavingsAccount(c6, 100, "16");

		// Creating default Bank object
		Bank myBank = new Bank();
		
		// The method processTran in the Transaction class will perform the task of creating a 
		// transaction object and initializing it whenever a new transaction (e.g., a deposit 
		// or withdrawal) takes place on an account object. It will then add this transaction 
		// to the transaction array
		//Creating a bogus transaction which I'm sure most financial institutes would consider shady
		Transaction securityLeak = new Transaction();

		if(TESTING){
			// remember to change the constant ACCOUNT_INITIAL_SIZE in the Bank class to 5
			System.out.println("******** TESTING REALLOCATE() FOR BANK CLASS ********");
			System.out.println("The current size of myBank's Account[] is " + myBank.getAccountsArray().length);
			System.out.println("The expected size: 5");
		}		
		myBank.addAccount(a1);
		myBank.addAccount(a2);
		myBank.addAccount(a3);
		myBank.addAccount(a4);
		myBank.addAccount(a5);
		myBank.addAccount(a6);

		if(TESTING){
			System.out.println("Six Account objects have been added to the Account[]");
			System.out.println("The current size of myBanks' Account[] is " + myBank.getAccountsArray().length);
			System.out.println("The expected size: 10");
			System.out.println("******************************************************\n\n");

			System.out.println("******** TESTING ADDING ACCOUNT WITH SAME ACCOUNT NUMBER ********");
			myBank.addAccount(a6Copy);
			System.out.println("This should trigger an error.  The account should not be added to Account[]");
			System.out.println("Verify this by testing the toString() method for the Bank class.");
			System.out.println("*****************************************************************\n\n");

			System.out.println("******** TESTING TOSTRING() FOR BANK CLASS ********");
			System.out.println(myBank);
			System.out.println("******************************************************\n\n");
		}

		String find = "55";
		if(TESTING){
			System.out.println("******** TESTING GETACCOUNT() FOR BANK CLASS FOR ACCOUNT THAT DOESN'T EXIST********");
			try{
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
			}catch(NullPointerException e){
				System.out.println("Account number " + find + " does not exist!");
			}
			System.out.println("This should trigger an error.");
			System.out.println("******************************************************\n\n");
		}

		// Now search for an account that actually exists.

		find = "11";
		try{
			if(TESTING){

				System.out.println("******** TESTING GETACCOUNT() FOR BANK CLASS ********");
				System.out.println("Expected balance: 100");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println("******************************************************\n\n");

				// Remember to change constant TRANSACTION_INITIAL_SIZE in Account class to 3
				System.out.println("******** BEGIN TESTING REALLOCATE() FOR ACCOUNT CLASS ********");
				System.out.println("The current size of account's Transaction[] is " + myBank.getAccount(find).getTransactionsArray().length);
				System.out.println("The expected size: 3");
				System.out.println("******************************************************\n\n");

				System.out.println("******** TESTING MAKEDEPOSIT() FOR BANK CLASS FOR NEGATIVE AMOUNT ********");
				myBank.makeDeposit(securityLeak, myBank.getAccount(find), "deposit", -12, "010101", "No extra fees");
				System.out.println("Should display an error message. Balance should not be changed. No transaction should be added.");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println(a1);
				System.out.println("******************************************************\n\n");

				System.out.println("******** TESTING MAKEWITHDRAWAL() FOR BANK CLASS FOR NEGATIVE AMOUNT ********");
				myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", -0.75, "010101", "No extra fees");
				System.out.println("Should display an error message. Balance should not be changed. No transaction should be added.");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println(a1);
				System.out.println("******************************************************\n\n");
			}

			// Making a deposit into an account
			myBank.makeDeposit(securityLeak, myBank.getAccount(find), "deposit", 12, "01012001", "No extra fees");
			if(TESTING){
				System.out.println("******** TESTING MAKEDEPOSIT() FOR BANK CLASS FOR POSITIVE AMOUNT ********");
				System.out.println("Expected balance: 112");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println("******************************************************\n\n");
			}

			// Making a withdrawal from an account
			myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 13, "02022002", "No extra fees");
			if(TESTING){
				System.out.println("******** TESTING MAKEWITHDRAWAL() FOR BANK CLASS FOR POSITIVE AMOUNT ********");
				System.out.println("Expected balance: 99");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println("******************************************************\n\n");
			}

			// Making another deposit into an account
			myBank.makeDeposit(securityLeak, myBank.getAccount(find), "deposit", 50.25, "01012001", "No extra fees");

			// Making another withdrawal from an account
			myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 0.25, "02022002", "No extra fees");

			if(TESTING){
				System.out.println("******** TESTING MAKEWITHDRAWAL() FOR BALANCE BELOW MINIMUM ********");
				// Making another withdrawal from an account that will result in a negative balance
				myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 250, "02022002", "No extra fees");
				System.out.println("This should trigger a error for being below minimum balance and decline transaction.");
				System.out.println("No transaction should be added to Transaction[].");
				System.out.println("Expected balance: 149.00");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println("******************************************************\n\n");

				System.out.println("******** TESTING MAKEWITHDRAWAL() THAT TRIGGERS AN OVERDRAFT PENALTY ********");
				// Making another withdrawal from an account that will result in a negative balance
				myBank.makeWithdrawal(securityLeak, myBank.getAccount(find), "withdrawal", 150, "02022002", "No extra fees");
				System.out.println("Expected balance: -36.00");
				System.out.println("Actual balance: " + myBank.getAccount(find).getBalance());
				System.out.println("******************************************************\n\n");

				System.out.println("******** END TESTING REALLOCATE() FOR ACCOUNT CLASS ********");
				System.out.println("Seven Transactions have been added to the Transaction[]");
				System.out.println("The current size of account's Transaction[] is " + myBank.getAccount(find).getTransactionsArray().length);
				System.out.println("The expected size: 12");
				System.out.println("******************************************************\n\n");
			}

			// Print account information		
			System.out.println(myBank.getAccount("11"));
		}catch(NullPointerException e){
			System.out.println("Account number " + find + " does not exist!");
		}
	}
}

