/**
 * @Raymond Gevorkian April 7th - April 14th 2016
 * Attributions to: CS Club Tutoring, Professor Rangasayee Office Hours / source code, online sources, and some purely logical advice from peers. 
 * Note: all logical advice from peers has been noted within the code. 
 * Note: all online sources have been noted within the code or README file.
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
