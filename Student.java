/**
 * Creates a Student object
 * 
 * @version Assignment #2, 19 February 2014
 */

public class Student extends Customer{

	// Declarations of the instance variables of Student class
	private final double SAVINGS_INTEREST = 0.05;
	private final double CHECK_INTEREST = 0.0;
	private final double CHECK_CHARGE = 2.00;
	private final double OVERDRAFT_PENALTY = 25.00;
	private final double MINIMUM_BALANCE = 0.00;

	// Constants for Student class
	private final int STUDENT_MIN_AGE = 13;
	private final int STUDENT_MAX_AGE = 25;

	/**
	 * Default constructor for the Student class.
	 * Creates the constructor by calling the default constructor of the superclass Customer
	 */
	public Student(){
		super();
		super.setAge(STUDENT_MIN_AGE);
	}

	/**
	 * Custom constructor for the Student class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param name The name of the customer
	 * @param address The address of the customer
	 * @param age The age of the customer
	 * @param telephoneNumber The telephone number of the customer
	 * @param customerNumber The unique customer number assigned to a customer
	 */
	public Student(String name, String address, int age,
			String telephoneNumber, String customerNumber){
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
	 * @precondition The age value must be >= STUDENT_MIN_AGE
	 * @postcondition If age value is >= STUDENT_MIN_AGE, then age value is updated. Otherwise age is set equal to STUDENT_MIN_AGE.
	 */
	public void setAge(int age){
		if (ageWithinRange(age)) super.setAge(age);
		else{
			super.setAge(STUDENT_MIN_AGE);
			System.out.println("Invalid age. \nAge has been set to " + STUDENT_MIN_AGE 
					+ ", the minimum age for a Student.");
		}
	}

	/**
	 * Returns the interest percentage earned for a savings account
	 * 
	 * @return the interest percentage earned for a savings account
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
	 * Verifies input age for a Student customer
	 * 
	 * @param age the age of the customer
	 * @return true if age is within the appropriate age range for a Student customer. Returns false if not within range.
	 */
	private boolean ageWithinRange(int age){
		return (age >= STUDENT_MIN_AGE && age <= STUDENT_MAX_AGE);			
	}
}
