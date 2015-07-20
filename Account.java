/**
 * Defines the abstract Account class
 * 
 * @version Assignment #2, 19 February 2014
 */

public abstract class Account{

	// Declarations of the instance variables of Account class
	private Customer customer;
	private double balance;
	private String accountNumber;
	private Transaction[] transactions;  // this would be better as an ArrayList
	private int totalTransactions;

	// Constants for Account class
	private final int TRANSACTION_INITIAL_SIZE = 20; 
	// private final int TRANSACTION_INITIAL_SIZE = 3; // for testing
	private final int ARRAY_MULTIPLIER = 2;

	/**
	 * Default constructor for the Account class.
	 * Assigns default values to the instance variables.
	 * Creates a default constructor for an Adult object
	 * Default balance: 0
	 * Default accountNumber: 00000000
	 * Creates an empty Transaction[] of size TRANSACTION_INITIAL_SIZE
	 * Default totalTransactions: 0 
	 */
	public Account(){
		customer = new Adult();
		balance = 0;
		accountNumber = "00000000";
		transactions = new Transaction[TRANSACTION_INITIAL_SIZE];
		totalTransactions = 0;
	}

	/**
	 * Custom constructor for the Customer class.
	 * Assigns user inputs to the instance variables.
	 * Creates an empty Transaction[] of size TRANSACTION_INITIAL_SIZE
	 * Sets the total number of transactions for the account equal to zero
	 * 
	 * @param customer A reference to a Customer object associated with the account
	 * @param balance The balance of the account
	 * @param accountNumber The unique account number of the account
	 */
	public Account(Customer customer, double balance, String accountNumber) {
		this.customer = customer;
		if(balance >= 0){
			this.balance = balance;
		}
		else{
			// Would prefer not to create the object at all
			this.balance = 0;
			System.out.println("Invalid initial balance. Initial balance cannot be negative.");
		}
		this.accountNumber = accountNumber;
		this.transactions = new Transaction[TRANSACTION_INITIAL_SIZE];
		this.totalTransactions = 0;
	}
	
	/**
	 * Custom constructor for the Customer class
	 * Assigns user inputs to the instance variables
	 * Sets the total number of transactions for the account equal to zero
	 * 
	 * @param customer A reference to a Customer object associated with the account
	 * @param balance The balance of the account
	 * @param accountNumber The unique account number of the account
	 * @param transactions An array of references to Transaction objects
	 */
	public Account(Customer customer, double balance, String accountNumber, Transaction[] transactions) {
		this.customer = customer;
		if(balance >= 0){
			this.balance = balance;
		}
		else{
			this.balance = 0;
			System.out.println("Invalid initial balance. Initial balance cannot be negative.");
		}
		this.accountNumber = accountNumber;
		this.transactions = transactions;
		this.totalTransactions = transactions.length;
	}

	/*
	 * Modifies the Customer object associated with the account
	 * 
	 * @param customer A reference to a new Customer object associated with the account
	 */
	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	/*
	 * Modifies the value of the account's balance
	 * 
	 * @param balance The new balance of the account
	 */
	public void setBalance(double balance){
		this.balance = balance;
	}

	/*
	 * Modifies the account number for the account
	 * 
	 * @param accountNumber The new account number for the account
	 */
	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}

	/*
	 * Modifies the the value of the Account's array of Transaction object
	 * 
	 * @param transactions A new array of Transaction objects
	 */
	public void setTransactions(Transaction[] transactions){
		this.transactions = transactions;
	}

	/*
	 * Modifies the number of transactions completed by the account
	 * 
	 * @param totalTransactions the number of transactions completed by the account
	 */
	public void setTotalTransactions(int totalTransactions){
		this.totalTransactions = totalTransactions;
	}

	/*
	 * Returns the current referenced Customer object associated with the Account
	 * 
	 * @return The current value of the 'customer' instance variable
	 */
	public Customer getCustomer(){
		return customer;
	}

	/*
	 * Returns the current value of the account's balance
	 * 
	 * @return The current value of the 'balancer' instance variable
	 */
	public double getBalance(){
		return balance;
	}

	/*
	 * Returns the current value of the account's account number
	 * 
	 * @return The current value of the 'accountNumber' instance variable
	 */
	public String getAccountNumber(){
		return accountNumber;
	}

	/*
	 * Returns the current array holding the Account's transactions
	 * 
	 * @return The current array holding the Account's transactions
	 */
	public Transaction[] getTransactionsArray(){
		return transactions;
	}

	/*
	 * Returns the current number of transactions the account has completed
	 * 
	 * @return The current value of the 'totalTransactions' instance variable
	 */
	public int getTotalTransactions(){
		return totalTransactions;
	}

	/*
	 * Increases the current size of the array by some multiple if the number of
	 * transactions exceeds the size of the transactions array.  
	 */
	public void reallocate(){
		int newArraySize = getTransactionsArray().length * ARRAY_MULTIPLIER;
		Transaction[] tempTransArray = new Transaction[newArraySize];

		for(int i=0; i<(getTransactionsArray().length); i++){
			tempTransArray[i] = this.transactions[i];			
		}

		setTransactions(tempTransArray);		
	}

	/*
	 * Adds a new reference to a Transaction object to the Account's transactions array
	 * 
	 * @param transaction A reference to a Transaction object to be added to the transactions array
	 */
	// may need something if Transaction transaction is null
	public void addTransaction(Transaction transaction){
		setTotalTransactions(getTotalTransactions() + 1);

		if(getTotalTransactions() > getTransactionsArray().length){
			reallocate();
		}

		transactions[getTotalTransactions() - 1] = transaction;
	}
	
	/*
	 * Abstract method for add a deposit to an account balance
	 * 
	 * @param amount the amount of money to add to the account
	 */
	abstract void deposit(double amount);

	/*
	 * Abstract method for withdrawing money from an account balance
	 * 
	 * @param amount the amount of money to subtract from the account
	 */	
	abstract void withdraw(double amount);

	/*
	 * Abstract method for adding earned interest to an account balance
	 */	
	abstract void addInterest();
	
	/**
	 * Determines if account balance is below customer's allowed minimum balance
	 * 
	 * @param customer A reference to an Customer object
	 * @param balance the current amount of money in an account
	 * @return Returns true if customer's account balance => the customer's minimum allowed balance.
	 */
	private boolean balanceWithinRange(Customer customer, double balance){
		return (balance >= customer.getMinimumBalance());			
	}

	/*
	 * Returns a text description of an Account object
	 * 
	 * @return A text description of an Account object
	 */
	
	public String toString(){
		String message = "\n\nTRANSACTION SUMMARY\n" + getTotalTransactions() + " total transactions have been perform on this account.\n";
		String transactionHeader = "DATE\t\tAMOUNT\t TYPE\t\tFEES\n";
		
		message = getCustomer().toString() + message + transactionHeader;
		
		for(int i=0; i<getTotalTransactions(); i++){
			message = message + this.transactions[i].toString() + "\n"; 
		}
		
		String finalBalance = "\n*** FINAL BALANCE = $" + String.format("%.2f", getBalance()) + " ***";

		return message + finalBalance;
	}
}

