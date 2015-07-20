/**
 * Defines the abstract Customer class
 * 
 * @version Assignment #2, 19 February 2014
 */

public abstract class Customer{

	// Declarations of the instance variables of Customer class
	private String name;
	private String address;
	private int age;
	private String telephoneNumber;
	private String customerNumber;

	/**
	 * Default constructor for the Customer class.
	 * Assigns default values to the instance variables.
	 * Default name: Unknown
	 * Default address: Unknown
	 * Default age: 18
	 * Default phoneNumber: 0000000000
	 * Default customerNumber: 000000
	 */
	public Customer(){
		name = "Unknown";
		address = "Unknown";
		age = 18;
		telephoneNumber = "0000000000";
		customerNumber = "000000";
	}

	/**
	 * Custom constructor for the Customer class.
	 * Assigns user inputs to the instance variables.
	 * 
	 * @param name The name of the customer
	 * @param address The address of the customer
	 * @param age The age of the customer
	 * @param telephoneNumber The telephone number of the customer
	 * @param customerNumber The unique customer number assigned to a customer
	 */
	public Customer(String name, String address, int age, String telephoneNumber, String customerNumber){
		this.name = name;
		this.address = address;
		this.age = age;
		this.telephoneNumber = telephoneNumber;
		this.customerNumber = customerNumber;
	}

	/*
	 * Modifies the value of the customer's name
	 * 
	 * @param name the new value for the customer's name
	 */
	public void setName(String name){
		this.name = name;
	}

	/*
	 * Modifies the value of the customer's address
	 * 
	 * @param address the new value for the customer's address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/*
	 * Modifies the value of the customer's age
	 * 
	 * @param age the new value for the customer's age
	 */
	public void setAge(int age){
		this.age = age;
	}

	/*
	 * Modifies the value of the customer's telephone number
	 * 
	 * @param telephoneNumber the new value for the telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}

	/*
	 * Modifies the value of the customer's customer number
	 * 
	 * @param customerNumber the new value for the customer's customer number
	 */
	public void setCustomerNumber(String customerNumber){
		this.customerNumber = customerNumber;
	}

	/*
	 * Returns the current value of the customer's name
	 * 
	 * @return the current value of the 'name' instance variable
	 */
	public String getName(){
		return name;
	}

	/*
	 * Returns the current value of the customer's address
	 * 
	 * @return the current value of the 'address' instance variable
	 */
	public String getAddress(){
		return address;
	}

	/*
	 * Returns the current value of the customer's age
	 * 
	 * @return the current value of the 'age' instance variable
	 */
	public int getAge(){
		return age;
	}

	/*
	 * Returns the current value of the customer's telephone number
	 * 
	 * @return the current value of the 'telephoneNumber' instance variable
	 */
	public String getTelephoneNumber(){
		return telephoneNumber;
	}

	/*
	 * Returns the current value of the customer's customer number
	 * 
	 * @return the current value of the 'customerNumber' instance variable
	 */
	public String getCustomerNumber(){
		return customerNumber;
	}

	/*
	 * Abstract method for returning the interest earned for a savings account as a percentage
	 */
	abstract double getSavingsInterest();

	/*
	 * Abstract method for returning the interest earned for a checking account as a percentage
	 */
	abstract double getCheckInterest();

	/*
	 * Abstract method for returning the amount of a check charge
	 */
	abstract double getCheckCharge();

	/*
	 * Abstract method for returning the amount of a overdraft penalty
	 */	
	abstract double getOverdraftPenalty();

	/*
	 * Abstract method for returning the value of the minimum balance for a customer
	 */	
	abstract double getMinimumBalance();

	/*
	 * Returns a text description of a Customer subclass object
	 * 
	 * @return A text description of a Customer subclass object
	 */
	public String toString(){
		String listOfFees = "\n\nINTEREST RATES & FEES [" + getClass().getName() + " Account]\nSaving Interest: " + getSavingsInterest() + "%\tChecking Interest: " + getCheckInterest()
				+ "%\nCheck Charge: $" + String.format("%.2f", getCheckCharge()) + "\tOverdraft Penalty: $" + String.format("%.2f", getOverdraftPenalty());
		
		String formatPhoneNumber = "(" + getTelephoneNumber().substring(0,3) + ")" + getTelephoneNumber().substring(3,6) + "-" 
				+ getTelephoneNumber().substring(6);

		return "Customer Number: " + getCustomerNumber() + "\tName: " + getName() + "\tAge: " + getAge() + "\nAddress: " + getAddress() 
				+ "\t\tPhone Number: " + formatPhoneNumber + listOfFees;  
	}
}
