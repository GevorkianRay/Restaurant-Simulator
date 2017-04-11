import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Forms the main menu of the McPatterns project.
 * Utilizes the ItemModel class to from the menu.
 */
public class MenuModel implements Iterable<ItemModel>
{
   ArrayList<ItemModel> menuChoices = new ArrayList<>();

   /**
    * Constructor for the Menu.
    * Forms a new Menu as an ArrayList.
    */
   public MenuModel()
   {
      this.menuChoices = menuChoices;
   }

   /**
    * Adds an item to the menu.
    * @param name - the name of the item
    * @param price - the price of the item.
    */
   public void add(String name, Double price)
   {
      menuChoices.add(new ItemModel(name, price));
   }

   /**
    * Getter method for the menu size
    * @return the size of the menuChoices.
    */
   public int getSize()
   {
      return menuChoices.size();
   }

   /**
    * Iterator for the ItemModel class.
    * @return an iterator for the menuChoices.
    */
   public Iterator<ItemModel> iterator()
   {
      return menuChoices.iterator();
   }
}
