/**
 * @Raymond Gevorkian April 7th - April 14th 2016
 * This program loads a menu file to stimulate a touch screen ordering system.
 * The menu is displayed and adds each ordered item as buttons on the screen.
 * The total price is always present and displayed accurately.
 * There are also confirm and cancel options for the order.
 * Finally, the "confirm" options rely on Credit Card validation.
 */

public class McPatterns 
{
    public static void main(String[] args)
    {
    	McPatternsGUI UserInterface = new McPatternsGUI(new McPatternsPresenter(args[0])); 
    }
 }
