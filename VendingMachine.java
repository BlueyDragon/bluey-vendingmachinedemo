// VendingMachine.java
// Defines a VendingMachine object.
// by Stephen Gatten
// Last update: March 5, 2015

import java.util.Vector;

public class VendingMachine
{
	// Private variables.
	private double credit;
	private Vector inventory;

	// CONSTRUCTOR I is the standard constructor, as it makes the most sense for a vending machine
	// to start empty and be filled up manually.
	public VendingMachine()
	{
		credit = 0;
		inventory = new Vector();
	}

	// INSERT MONEY allows a user to place money into the vending machine, raising the
	// credit variable.
	public void insertMoney(double insertedValue)
	{
		credit += insertedValue;
	}

	// REMOVE MONEY allows the vending machine to remove money from itself, as in, charging
	// users for the products they are purchasing.
	public void removeMoney(double removingValue)
	{
		if(credit > removingValue)
			credit -= removingValue;
		else
			credit = 0.0;
	}

	// PROVIDE CHANGE clears the vending machine's credit variable, and returns a double
	// representing the amount of change it needs to give back.
	public double provideChange()
	{
		double changeAmount = credit;
		credit = 0.0;
		return changeAmount;
	}

	// GET CREDIT returns the credit variable as a double.
	public double getCredit()
	{
		return credit;
	}

	// ADD PRODUCT allows the programmer to add an existing Product to the vending machine's
	// inventory.
	public void addProduct(Product product)
	{
		inventory.addElement(product);
		//System.out.println("Adding " + product.getName() + " to inventory.");
	}

	// REMOVE PRODUCT allows the programmer to pull an existing Product from the vending
	// machine.
	public void removeProduct(Product product)
	{
		if(inventory.contains(product))
			inventory.removeElement(product);
	}

	// GET PRODUCTS returns a vector of the machine's products.
	public Vector getAllProducts()
	{
		// We don't want an external object to modify the original vector, so to preserve 
		// integrity, this method returns a clone.
		return (Vector) inventory.clone();
	}
}