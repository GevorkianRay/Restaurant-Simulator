import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
/**
 * McPatternsPresenter - reads in a .txt file and adds items to the menu as they are read.
 */
public class McPatternsPresenter 
{
	String menuFileName = "";
    MenuModel menuModel = new MenuModel();
    McPatternsGUI view;
    Pattern formattedItem; 
    
    /**
     * Constructor for McPatternsPresenter.
     * Initializes the name of the file ( read in from the command line ).
     * Creates a new menu and formats the .txt file using a regular expression.
     * @param menuFileName
     */
    public McPatternsPresenter(String menuFileName) 
    {
    	this.menuFileName = menuFileName;  
    	formattedItem = Pattern.compile("(.+)\\|(\\d\\.\\d{2})");
    	/**
    	 (   - Opens up a new capture group.
    	 .   - wildcard character.
    	 +   - modifier, match as many as possible 
    	 )   - closes the capture group.
    	 \\| - Matches that character. (the pipe). (Escapes the or character).
    	 (   -  opens up a new capture group.
    	 \\d - matches any digit.
    	 \\. - matches a decimal (dot)
    	 \\d - matches any digit
    	 {2} - modifier on the d, match exactly two digits.
    	 )   - closes the capture group.
    	*/
    }
    
    /**
     * Loads the menu.txt file and adds the items as they are read in.
     * @throws IOException
     */
    void loadMenuItems() throws IOException
    {
    	URL url = getClass().getClassLoader().getResource(menuFileName);
    	if (url == null) 
    		throw new IOException("404");  	
    	Scanner input = new Scanner(url.openStream());
    	while (input.hasNextLine()) 
    		addMenuItem(input.nextLine());
    } 

    /**
     * Attaches the view.
     * @param view - the view to be attached to the GUI.
     */
    public void attachView(McPatternsGUI view) {
        this.view = view;
    }
    
    /**
     * Adds an item to the menu, by splitting it in two parts.
     * Passes the first part of the item, the name, and then the second part, the price.
     * @param menuItemData
     */
    private void addMenuItem(String menuItemData)
    {
    	Matcher split = formattedItem.matcher(menuItemData);
    	if(split.matches())
    	{
    		int parts = split.groupCount(); //ensuring there are two groups.
    		if(parts == 2) {
    		String name = split.group(1); //everything before the '|' is the item.
    		double price = Double.parseDouble(split.group(2)); //everything after the '|' is the price.
    		menuModel.add(name, price);
    		}
    		else ;
    	}
    }
    
    /**
     * Returns an instance of the menu.
     * @return menuModel - the menumenuModel.
     */
    public MenuModel getMenuModel()
    {
    	return menuModel;
    }
}
