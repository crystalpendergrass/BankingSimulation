/**
 * Creates a Bank object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class Bank{

	// Declarations of the instance variables of Bank class
	private Account[] accounts;
	private int totalAccounts;

	// Constants for Bank class
	private final int ACCOUNT_INITIAL_SIZE = 100;
	// private final int ACCOUNT_INITIAL_SIZE = 5; // for testing
	private final int ARRAY_MULTIPLIER = 2;

	/**
	 * Default constructor for the Bank class.
	 * Assigns default values to the instance variables.
	 * Creates an empty Account[] of size ACCOUNT_INITIAL_SIZE
	 * 
	 * Default totalAccounts:0
	 */
	public Bank(){
		this.accounts = new Account[ACCOUNT_INITIAL_SIZE];
		this.totalAccounts = 0;
	}
	
	/**
	 * Default constructor for the Bank class.
	 * Assigns user input values to the instance variables.
	 * 
	 * @param accounts an array of references to Account objects
	 */
	public Bank(Account[] accounts){
		this.accounts = accounts;
		this.totalAccounts = accounts.length;
	}

	/*
	 * Modifies the the value of the bank's array of Account object
	 * 
	 * @param accounts A new array of references to Account objects
	 */
	public void setAccounts(Account[] accounts){
		this.accounts = accounts;
	}

	/*
	 * Modifies the the value for the total number of accounts the has
	 * 
	 * @param totalAccounts The new number of accounts a bank has
	 */
	public void setTotalAccounts(int totalAccounts){
		this.totalAccounts = totalAccounts;
	}

	/*
	 * Returns the current array holding the Bank's accounts
	 * 
	 * @return The current array holding the Bank's accounts
	 */
	public Account[] getAccountsArray(){
		return accounts;
	}

	/*
	 * Returns the current number of accounts a Bank has
	 * 
	 * @return The current value of the 'totalAccounts' instance variable
	 */
	public int getTotalAccounts(){
		return totalAccounts;
	}

	/*
	 * Increases the current size of the array by some multiple if the number of account exceeds the 
	 * size of the accounts array.  
	 */
	public void reallocate(){
		// This method would not be needed if using an ArrayList
		int newArraySize = getAccountsArray().length * ARRAY_MULTIPLIER;
		Account [] tempAcctArray = new Account[newArraySize];

		for(int i=0; i<(getAccountsArray().length); i++){
			tempAcctArray[i] = this.accounts[i];			
		}

		setAccounts(tempAcctArray);		
	}

	/*
	 * Add a new Account object to the Bank's accounts array
	 * 
	 * @param account A reference to the Account object to be added to the accounts array
	 */
	public void addAccount(Account account){
		// may need something if Account account is null
		// this method would be so much easier using an ArrayList
		if(accountExists(account.getAccountNumber())){
			System.out.println("An account already exists with that account Number.  Account not added to bank.");
		}
		else{
			setTotalAccounts(getTotalAccounts() + 1);
			if(getTotalAccounts() > getAccountsArray().length){
				reallocate();
			}
			this.accounts[getTotalAccounts() - 1] = account;	
		}
	}

	/*
	 * Deposits the specified amount into an account
	 * 
	 * @param t A reference to some arbitrary Transaction object
	 * @param account A reference to an Account object to which the deposit is added
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during the transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 * 
	 */
	public void makeDeposit(Transaction t, Account account, String transactionType, double amount, String date, String fees){
		account.deposit(amount);
		if(amount>0) makeTransaction(t, account, transactionType, amount, date, fees);
	}
	
	/*
	 * Withdraws the specified amount from an account. 
	 * 
	 * @param t A reference to some arbitrary Transaction object
	 * @param account A reference to an Account object from which the deposit is subtracted
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during the transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 * 
	 */
	public void makeWithdrawal(Transaction t, Account account, String transactionType, double amount, String date, String fees){
		account.withdraw(amount);
		if(amount>0) makeTransaction(t, account, transactionType, amount, date, fees);
		
		// Adding a separate transaction to process overdraft penalties
		if(account.getBalance() < 0) makeTransaction(t, account, "fee", account.getCustomer().getOverdraftPenalty(), date, "Overdraft penalty");
	}
	
	/*
	 * Adds earned interest to the account
	 * 
	 * @param t A reference to some arbitrary Transaction object
	 * @param account A reference to an Account object to which the earned interest is added
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during the transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 */
	public void makeInterestDeposit(Transaction t, Account account, String transactionType, double amount, String date, String fees){
		double earnedInterest = account.getBalance() * account.getCustomer().getSavingsInterest() / 100;
		account.addInterest();
		makeTransaction(t, account, transactionType, earnedInterest, date, fees);
	}
	
	/*
	 * Processes a transaction and adds it the accounts transaction array. 
	 * 
	 * @param t A reference to some arbitrary Transaction object
	 * @param account A reference to an Account object 
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during the transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 */
	private void makeTransaction(Transaction t, Account account, String transactionType, double amount, String date, String fees){
		// The method processTran in the Transaction class will perform the task of creating a 
		// transaction object and initializing it whenever a new transaction (e.g., a deposit 
		// or withdrawal) takes place on an account object. It will then add this transaction 
		// to the transaction array
		// It would be more appropriate for this method to behave as processTran
		t.processTran(account, transactionType, amount, date, fees);
	}
	
	/*
	 * Searches for an account number in the accounts array and returns index where account is located
	 * 
	 * @param accountNumber An account number for an account
	 * @return if account number found, a reference to the associated Account object  
	 */
	public Account getAccount(String accountNumber){
		for(int i=0; i<getAccountsArray().length; i++){
			if(this.accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber))
				return this.accounts[i];
		}
		
		// NullPointerException will be caught in BankTester
		return this.accounts[-1];		
	}

	/*
	 * Verifies the uniqueness of an account number in a bank
	 * 
	 * @param accountNumber An account number for an account
	 * @return true if an account already exists with that account number
	 */
	private boolean accountExists(String accountNumber){
		for(int i=0; i<getTotalAccounts(); i++){
			if(this.accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber)) 
				return true;
		}
		
		return false;
	}

	/*
	 * Returns a text description of a Bank object
	 * 
	 * @return A text description of a Bank object
	 */
	public String toString(){
		String message = "This Bank holds " + getTotalAccounts() + " accounts.\n";
		for(int i=0; i<getTotalAccounts(); i++){
			message = message + this.accounts[i].toString() + "\n"; 
		}

		return message;
	}
}
