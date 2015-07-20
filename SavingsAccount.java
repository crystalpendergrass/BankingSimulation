/**
 * Creates a SavingsAccount object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class SavingsAccount extends Account{

	/**
	 * Default constructor for the SavingsAccount class.
	 * Creates the constructor by calling the default constructor of the superclass Account
	 */
	public SavingsAccount(){
		
	}

	/**
	 * Custom constructor for the SavingsAccount class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param customer A reference to a Customer object that owns the account
	 * @param balance The amount of money currently in the account
	 * @param accountNumber The account's unique account number
	 */
	public SavingsAccount(Customer customer, double balance, String accountNumber){
		super(customer, balance, accountNumber);
	}
	
	/*
	 * Deposits the specified amount into an account
	 * 
	 * @param amount The amount that is being deposited into the account
	 * @precondition The amount value > 0
	 * @postcondition If amount value is > 0, then it is added to the balance of the account.  If amount <= 0, balance remains the same.
	 */
	public void deposit(double amount){
		if(amount > 0)
			setBalance(getBalance() + amount);

		else
			System.out.println("Invalid amount.  Cannot deposit a negative amount.");
	}

	/*
	 * Withdraws the specified amount from an account. If the new balance is lesser than zero, 
	 * but greater than the minimum balance, then an overdraft penalty is subtracted from the
	 * account's balance.  
	 * 
	 * @param amount The amount that is being withdrawn from the account
	 * @precondition The amount value > 0 and the new balance is > the minimum balance
	 * @postcondition If amount value is > 0 , then it is subtracted from the balance of the account.  If amount <= 0, balance remains the same.
	 */
	public void withdraw(double amount){
		// if withdrawal amount is positive, create a temporary balance
		if(amount > 0){
			double tempBalance = getBalance() - amount;
			
			// if the temporary balance is greater than the minimum continue to process the withdrawal
			if(tempBalance >= getCustomer().getMinimumBalance()){
				// if the temporary balance is negative, add an overdraft fee
				if(tempBalance < 0){
					setBalance(tempBalance - getCustomer().getOverdraftPenalty());					
				}
				// if the temporary balance is positive, set the balance equal to the temporary balance
				else setBalance(tempBalance);
			}
			// if the temporary balance is less than the minimum decline the withdrawal
			else{
				System.out.println("Transaction declined.  Resulting balance $" + String.format("%.2f", tempBalance) 
						+ " would be below allowed minimum balance $" + String.format("%.2f", getCustomer().getMinimumBalance()));
				// I am so generous and not adding on an insufficient funds fee.  
			}
		}
		// if the withdrawal amount is equal to or less than zero, decline the withdrawal.  
		else{
			System.out.println("Invalid amount.  Cannot withdraw a negative amount.");
		}
	}

	/*
	 * Adds earned interest to the account's balance the specified amount from an account
	 * 
	 * @precondition The account's balance > 0, 
	 * @postcondition If balance > earned interest is added to the balance. If balance <= 0, balance remains the same.
	 */
	public void addInterest(){
		if(getBalance() > 0){
			deposit(getBalance() * getCustomer().getSavingsInterest() / 100);
		}
	}
}
