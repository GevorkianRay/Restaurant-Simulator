import java.util.ArrayList;
/**
 * Class signifying single items within the menu.
 * Simply has methods to get the name and price of an item.
 */
public class ItemModel 
{
	 private double price = 0; 
	 private String name = "" ;

	 /**
	  * Constructor for the ItemModel.
	  * Initializes the name and price of an item.
	  * @param name
	  * @param price
	  */
	public ItemModel(String name, double price)
	   {
		  this.name = name;
	      this.price = price;
	   }
	
	/**
	 * Getter method for the name of an item.
	 * @return name - the name of a specific item.
	 */
	public String getName()
	{
		return name;		
	}
	
	/**
	 * Getter method for the price of an item.
	 * @return price - the price of a specific item.
	 */
	public double getPrice()
	{
		return price;
	}
}

