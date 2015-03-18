// Product.java
// Defines a Product object.
// by Stephen Gatten
// Last update: March 5, 2015

public class Product
{
	// Private variables.
	private String name;
	private String description;
	private double price;

	// CONSTRUCTOR III allows the programmer to design a Product with all variables set.
	public Product(String newName, String newDescription, double newPrice)
	{
		name = newName;
		description = newDescription;
		price = newPrice;
	}

	// CONSTRUCTOR II is the standard constructor, as the description is no longer needed by the demo.
	public Product(String newName, double newPrice)
	{
		name = newName;
		description = "";
		price = newPrice;
	}

	// CONSTRUCTOR I is a blank constructor, allowing the programmer to create placeholder Products.
	public Product()
	{
		name = "???";
		description = "???";
		price = 0.0;
	}

	// SET NAME sets the product's name variable.
	public void setName(String newName)
	{
		name = newName;
	}

	// GET NAME returns the product's name variable as a string.
	public String getName()
	{
		return name;
	}

	// SET DESCRIPTION sets the product's description variable.
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}

	// GET DESCRIPTION returns the product's description variable as a string.
	public String getDescription()
	{
		return description;
	}

	// SET PRICE sets the product's price variable.
	public void setPrice(double newPrice)
	{
		price = newPrice;
	}

	// GET PRICE returns the product's price variable as a double.
	public double getPrice()
	{
		return price;
	}

	// TO STRING allows the product to be used in a print or println command.
	public String toString()
	{
		return name + ", priced at $" + price;
		//return name + ", " + description + " Price $" + price;
	}
}