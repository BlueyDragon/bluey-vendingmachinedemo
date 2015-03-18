// VendingMachineDemo.java
// Small demo program showing off the VendingMachine and Product classes, allowing the user
// to view a vending machine, insert money, and purchase items.
// by Stephen Gatten
// Last update: March 5, 2015

import java.util.Scanner;
import java.util.Iterator;
import java.util.Vector;

public class VendingMachineDemo
{
	public static void main(String args[])
	{
		// Control objects and variables
		VendingMachine theMachine = new VendingMachine();
		Scanner inputReader = new Scanner(System.in);
		int choice, userProductChoice = 0;
		double userMoneyInsert = 0;

		// Products for the vending machine
		//Product boltCola = new Product("Bolt Cola","soda of some description.",1.25);
		Product barcowlTea = new Product("Barcowl Black Tea",1.00);
		Product boltCola = new Product("Bolt Cola",1.25);
		Product blazeCola = new Product("Blaze Cola",1.25);
		Product redDragon = new Product("Red Dragon Energy Drink",2.50);
		Product targetProduct = new Product(); // Blank product used as a placeholder
		//System.out.println(boltCola);

		// Add products to the vending machine
		theMachine.addProduct(barcowlTea);
		theMachine.addProduct(boltCola);
		theMachine.addProduct(blazeCola);
		theMachine.addProduct(redDragon);

		// Have a clone copy of the vending machine's inventory on hand so we can quickly iterate through it and get product data.
		Vector allProducts = theMachine.getAllProducts();
		Iterator i;

		// Main loop
		do {
			// If the vending machine has money inserted, display that as part of the initial
			// description.
			if(theMachine.getCredit() > 0)
				System.out.print("The vending machine currently has $" + theMachine.getCredit() + " inserted.");
			else
				System.out.print("The vending machine stands dormant.");

			// Print out a menu of options.
			System.out.println(" What would you like to do?");
			System.out.println("(1) Insert Money");
			System.out.println("(2) View Products");
			System.out.println("(3) Purchase Product");
			System.out.println("(4) Return Change");
			System.out.println("(5) Quit");
			System.out.print(": ");
			choice = inputReader.nextInt();

			switch(choice)
			{
				case 1: // INSERT MONEY
					System.out.println("How much money would you like to insert?");
					System.out.print(": ");
					userMoneyInsert = inputReader.nextDouble();
					theMachine.insertMoney(userMoneyInsert);
					break;

				case 2: // VIEW PRODUCTS
					System.out.println("The vending machine has the following items:");
					i = allProducts.iterator();
					while(i.hasNext())
						System.out.println(i.next());
					break;

				case 3: // PURCHASE ITEM
					int productCount = 0;
					System.out.println("What would you like to purchase?");
					i = allProducts.iterator();
					while(i.hasNext()){
						productCount++;
						System.out.println("(" + productCount + ") " + i.next());
					}
					System.out.print(": ");
					userProductChoice = inputReader.nextInt();
					if(userProductChoice > 0 && userProductChoice <= allProducts.size()){
						targetProduct = (Product) allProducts.elementAt(userProductChoice - 1);
						if(theMachine.getCredit() >= targetProduct.getPrice()){
							System.out.println("The " + targetProduct.getName() + " slides down the chute.");
							theMachine.removeMoney(targetProduct.getPrice());
							double changeAmount = theMachine.provideChange();
							if(changeAmount > 0)
								System.out.println("The vending machine returns $" + changeAmount + " worth of change.");
						}
						else
							System.out.println("The " + targetProduct.getName() + " costs $" + targetProduct.getPrice() + ".");
					}
					else
						System.out.println("Invalid selection.");
					break;

				case 4: // RETURN CHANGE
					if(theMachine.getCredit() > 0)
						System.out.println("The vending machine returns $" + theMachine.provideChange() + " worth of change.");
					else
						System.out.println("The hollow click of the change return button mocks you.");
					break;
				case 5: // QUIT
					System.out.println("The vending machine bids you farewell.");
					break;
			}

			// How making selections originally worked, via characters instead of numbers.
			// This legacy code is preserved here in case this method needs to be reinstated
			// for any reason.
			/*if(choice.equals("Q") || choice.equals("q"))
			{
				chooseQuit = true;
			}*/

		} while( choice != 5 );
	}
}