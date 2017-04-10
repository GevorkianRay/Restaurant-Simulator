import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Forms an ongoing orderedItems that will be later purchased.
 * Has add methods to add items to the orderedItems as they are added.
 * Has getTotalCost method to return the total cost of the orderedItems.
 * Attributions to CS club / Mitchell L / Aaron Lee on why implementing iterators is beneficial.
 */
public class OrderModel implements Iterable<ItemModel>
{
	ArrayList<ItemModel> orderedItems;
	double price = 0;
	
	/**
	 * Constructor for the Order.
	 * Initializes the price and the orderedItems.
	 */
	public OrderModel()
	{
		this.price = price;
		orderedItems = new ArrayList<>();
	}
	
	/**
	 * Adds an item to the orderedItems and increments the price.
	 * @param item - the item that is being added to the orderedItems.
	 */
	public void add(ItemModel item)
	{
		price += item.getPrice();
		orderedItems.add(item);
	}

	/**
	 * Removes an item to the orderedItems and decreases the price.
	 * @param item - the item that is being removed to the orderedItems.
	 */
	public void remove(ItemModel item)
	{
		price -= item.getPrice();
		orderedItems.add(item);
	}
	
	/**
	 * Returns the total price that was obtained while adding items to the orderedItems.
	 * @return price - the formatted total price of the orderedItems.
	 */
	public String getTotalCost()
	{
		return String.format("$%.2f", price); //Attributions to peers who helped me with formatting of price.
	}
	
	/**
	 * Returns an iterator of the orderedItems.
	 */
	public Iterator<ItemModel> iterator() 
	{
		return orderedItems.iterator();
	}
}
