/**
 * Creates a Transaction object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class Transaction{

	// Declarations of the instance variables of Transaction class
	private String customerNumber;
	private String transactionType;
	private double amount;
	private String date;
	private String fees;

	/**
	 * Default constructor for the Transaction class.
	 * Assigns default values to the instance variables.
	 * Default customerNumber: 000000
	 * Default transactionType: Unknown
	 * Default amount: 0.0
	 * Default date: mmddyyyy
	 * Default fees: There are no extra fees.
	 */
	public Transaction() {
		customerNumber = "000000";
		transactionType = "Unknown";
		amount = 0.0;
		date = "mmddyyyy";
		fees = "There are no extra fees.";
	}

	/**
	 * Custom constructor for the Transaction class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param customerNumber The customer number of the customer completing the transaction
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during a transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 * @precondition The amount value must be >= 0
	 * @postcondition If amount value is >= 0, then amount value is updated. Otherwise amount is set equal to zero.
	 */
	public Transaction(String customerNumber, String transactionType, double amount, String date, String fees) {
		this.customerNumber = customerNumber;
		this.transactionType = transactionType;

		if(amount>0) this.amount = amount;
		else{
			this.amount = 0;
			System.out.println("Invalid amount.  Amount is negative. \nAmount has been set equal to zero.");
		}

		this.date = date;
		this.fees = fees;
	}

	/*
	 * Modifies the the value of the customer number of the customer completing the transaction 
	 * 
	 * @param customerNumber The new value for the customer's name
	 */
	public void setCustomerNumber(String customerNumber){
		this.customerNumber = customerNumber;
	}

	/*
	 * Modifies the the value of the transaction's type
	 * 
	 * @param transactionType The new value for the transaction type
	 */
	public void setTransactionType(String transactionType){
		this.transactionType = transactionType;
	}

	/*
	 * Modifies the amount processed during a transaction
	 * 
	 * @param amount The new value of the amount being processed during the transaction
	 * @precondition The amount value must be >= 0
	 * @postcondition If amount value is >= 0, then amount value is updated. Otherwise amount is set equal to zero.
	 */
	public void setAmount(double amount){
		if(amount<0) this.amount = amount;
		else{
			this.amount = 0;
			throw new IllegalArgumentException("Invalid amount.  Amount is negative. \nAmount has been set equal to zero.");
			// System.out.println("Invalid amount.  Amount is negative. \nAmount has been set equal to zero.");
		}
	}

	/*
	 * Modifies the the value of the transaction's date
	 * 
	 * @param date The new value for the transaction's date
	 */
	public void setDate(String date){
		this.date = date;
	}

	/*
	 * Modifies the the value of the transaction's fees
	 * 
	 * @param fees The new value for the transaction's fees
	 */
	public void setFees(String fees){
		this.fees = fees;
	}

	/*
	 * Returns the current value of the customer number of the customer completing the transaction
	 * 
	 * @return The current value of the 'customerNumber' instance variable
	 */
	public String getCustomerNumber(){
		return customerNumber;
	}

	/*
	 * Returns the current value of the transaction's type
	 * 
	 * @return The current value of the 'transactionType' instance variable
	 */
	public String getTransactionType(){
		return transactionType;
	}

	/*
	 * Returns the current value of the transaction's amount
	 * 
	 * @return The current value of the 'amount' instance variable
	 */
	public double getAmount(){
		return amount;
	}

	/*
	 * Returns the current value of the transaction's date
	 * 
	 * @return The current value of the 'date' instance variable
	 */
	public String getDate(){
		return date;
	}

	/*
	 * Returns the current description of the transaction's fee
	 * 
	 * @return The current value of the 'fees' instance variable
	 */
	public String getFees(){
		return fees;
	}

	
	/*
	 * Creates a transaction object and initializing it whenever a new transaction takes place on 
	 * an Account object. The transaction is then added to the Account's transaction array.
	 * 
	 * @param account A reference to an Account object to which the transaction will be added
	 * @param transactionType The type of transaction (eg deposit, withdrawal)
	 * @param amount The amount processed during a transaction
	 * @param date The date of the transaction in the form mmddyyyy
	 * @param fees A description of any unusual fees
	 * 
	 * @precondition The amount value must be >= 0
	 * @postcondition If amount value is >= 0, then amount value is updated. Otherwise amount is set equal to zero. 
	 */
	public void processTran(Account account, String transactionType, double amount, String date, String fees){
		// The method processTran in the Transaction class will perform the task of creating a 
		// transaction object and initializing it whenever a new transaction (e.g., a deposit 
		// or withdrawal) takes place on an account object. It will then add this transaction 
		// to the transaction array
		// Won't this lead to creating a fake transaction to process real transactions???
		// This method would be better in either Bank or Account class
		Transaction newTransaction = new Transaction(account.getCustomer().getCustomerNumber(), transactionType, amount, date, fees);

		account.addTransaction(newTransaction);		
	}

	/*
	 * Returns a text description of a Transaction object
	 * 
	 * @return A text description of a Transaction object
	 */
	public String toString(){
		
		String formatDate = getDate().substring(0,2) + "/" + getDate().substring(2,4) + "/" + getDate().substring(4);
						
		return formatDate + "\t$"  + String.format("%.2f", getAmount()) + "\t " + getTransactionType() + "    \t" + getFees();
	}	
}
