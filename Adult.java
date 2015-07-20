/**
 * Creates an Adult object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class Adult extends Customer{

	// Declarations of the instance variables of Adult class
	private final double SAVINGS_INTEREST = 0.07;
	private final double CHECK_INTEREST = 0.03;
	private final double CHECK_CHARGE = 1.00;
	private final double OVERDRAFT_PENALTY = 35.00;
	private final double MINIMUM_BALANCE = -100.00;

	// Constants for Adult class
	private final int ADULT_MIN_AGE = 18;
	private final int ADULT_MAX_AGE = 125;
	/**
	 * Default constructor for the Adult class.
	 * Creates the constructor by calling the default constructor of the superclass Customer
	 */
	public Adult(){
		super();
		super.setAge(ADULT_MIN_AGE);
	}

	/**
	 * Custom constructor for the Adult class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param name The name of the customer
	 * @param address The address of the customer
	 * @param age The age of the customer
	 * @param telephoneNumber The telephone number of the customer
	 * @param customerNumber The unique customer number assigned to a customer
	 */
	public Adult(String name, String address, int age, String telephoneNumber,
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
	 * @precondition The age value must be >= ADULT_MIN_AGE
	 * @postcondition If age value is >= ADULT_MIN_AGE, then age value is updated. Otherwise age is set equal to ADULT_MIN_AGE.
	 */
	public void setAge(int age){
		if (ageWithinRange(age)) super.setAge(age);
		else{
			super.setAge(ADULT_MIN_AGE);
			System.out.println("Invalid age. \nAge has been set to " + ADULT_MIN_AGE
					+ ", the minimum age for an Adult.");
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
	 * Verifies input age for an Adult customer
	 * 
	 * @param age the age of the customer
	 * @return true if age is within the appropriate age range for an Adult customer. Returns false if not within range.
	 */
	private boolean ageWithinRange(int age){
		return (age >= ADULT_MIN_AGE && age <= ADULT_MAX_AGE);			
	}
}