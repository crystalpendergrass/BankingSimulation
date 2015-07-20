/**
 * Creates a Senior object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class Senior extends Customer{

	// Declarations of the instance variables of Senior class
	private final double SAVINGS_INTEREST = 0.1;
	private final double CHECK_INTEREST = 0.05;
	private final double CHECK_CHARGE = 0.75;
	private final double OVERDRAFT_PENALTY = 20.00;
	private final double MINIMUM_BALANCE = -25.00;

	// Constants for Senior class
	private final int SENIOR_MIN_AGE = 65;
	private final int SENIOR_MAX_AGE = 125;

	/**
	 * Default constructor for the Senior class.
	 * Creates the constructor by calling the default constructor of the superclass Customer
	 */
	public Senior(){
		super();
		super.setAge(SENIOR_MIN_AGE);
	}

	/**
	 * Custom constructor for the Senior class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param name The name of the customer
	 * @param address The address of the customer
	 * @param age The age of the customer
	 * @param telephoneNumber The telephone number of the customer
	 * @param customerNumber The unique customer number assigned to a customer
	 */
	public Senior(String name, String address, int age, String telephoneNumber,
			String customerNumber){
		super.setName(name);
		super.setAddress(address);
		this.setAge(age);
		super.setTelephoneNumber(telephoneNumber);
		super.setCustomerNumber(customerNumber);
	}

	/*
	 * Modifies the value of the customer's age
	 * 
	 * @param age The new value for the customer's age
	 * @precondition The age value must be >= SENIOR_MIN_AGE
	 * @postcondition If age value is >= SENIOR_MIN_AGE, then age value is updated. Otherwise age is set equal to SENIOR_MIN_AGE.
	 */
	public void setAge(int age){
		if (ageWithinRange(age)) super.setAge(age);
		else{
			super.setAge(SENIOR_MIN_AGE);
			System.out.println("Invalid age. \nAge has been set to " + SENIOR_MIN_AGE 
					+  ", the minimum age for a Senior.");
		}
	}

	/**
	 * Returns the interest earned for a savings account as a percentage
	 * 
	 * @return the interest earned for a savings account as a percentage
	 */
	double getSavingsInterest(){
		return SAVINGS_INTEREST;
	}

	/**
	 * Returns the interest earned for a checking account as a percentage
	 * 
	 * @return the interest earned for a checking account as a percentage
	 */
	double getCheckInterest(){
		return CHECK_INTEREST;
	}

	/**
	 * Returns the amount of a check charge
	 * 
	 * @return the amount of a check charge
	 */
	double getCheckCharge(){
		return CHECK_CHARGE;
	}

	/**
	 * Returns the amount of a overdraft penalty
	 * 
	 * @return the amount of a overdraft penalty
	 */
	double getOverdraftPenalty(){
		return OVERDRAFT_PENALTY;
	}

	/**
	 * Returns the value of the minimum balance for a customer
	 * 
	 * @return the value of the minimum balance for a customer
	 */
	double getMinimumBalance(){
		return MINIMUM_BALANCE;				
	}

	/**
	 * Verifies input age for a Senior customer
	 * 
	 * @param age the age of the customer
	 * @return true if age is within the appropriate age range for a Senior customer. Returns false if not within range.
	 */
	private boolean ageWithinRange(int age){
		return (age >= SENIOR_MIN_AGE && age <= SENIOR_MAX_AGE);			
	}
}
