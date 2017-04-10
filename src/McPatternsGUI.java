import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
/**
 * GUI class for the Application.
 * Handles the User Interface operations such as confirming the order and canceling an order.
 */
class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	OrderModel order;

	/**
	 * Constructor for the McPatternsGUI.
	 * Displays the interface and initializes the order and presenter.
	 * @param presenter - the McPatternsPresenter.
	 */
	public McPatternsGUI(McPatternsPresenter presenter) {
		this.presenter = presenter;
		presenter.attachView(this);
		order = new OrderModel();
		showGUI();		
	}
	/**
	 * Displays the GUI.
	 * Handles JButtons and ActionListeners.
	 */
	private void showGUI() 
	{
		try  
		{ 
			presenter.loadMenuItems();
		} 
		catch (IOException e1) //Catches the file not found exception as an input stream error.
		{
			e1.printStackTrace();
		}

		/**
		 * Initializing JFrames and JPanels.
		 */
		JFrame mainFrame = new JFrame("Welcome to McPatterns!!!");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());
		
		JPanel receiptPanel = new JPanel();
		receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.PAGE_AXIS));
				
		JPanel menuPanel = new JPanel(new GridLayout());
		menuPanel.add(new JLabel("Please enter the items you want to order!"));

		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.PAGE_AXIS));
		
		JLabel orderInformation = new JLabel("Your order");
		orderPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPanel.add(orderInformation);
		
		JTextField creditCardEntry = new JTextField("Enter CC #"); 
		creditCardEntry.setDocument(new TextLimit(19)); //Limiting the amount of text to 19.

		CreditCardFactory cardFactory = new CreditCardFactory();
		/**
		 * JButton for the confirmation of an order.
		 * Handles the approval of a credit card.
		 * Prints a list of the ordered items and the card type used.
		 */
		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String creditCardNumber = creditCardEntry.getText();
				CreditCard card = cardFactory.getCreditCard(creditCardNumber);
				if(card != null && card.authorize()) //if the card is not null and has been authorized...
				{
					System.out.println("Your order has been approved!");
					System.out.println("Here is a list of your ordered items:");
					for(ItemModel orderedItem : order)
					{
						System.out.println(orderedItem.getName());
					}
					System.out.println("Your total cost is " + order.getTotalCost());
					String number = creditCardEntry.getText();
					orderInformation.setText("Payment method: " + card.getName());
					System.out.println("Your payment has been confirmed to " + 
					card.secureNumber(number) + " a " + card.getName()); 					
				}
				else
				{					
					orderInformation.setText("Card declined for " + creditCardEntry.getText());
					System.out.println("Card declined for " + creditCardEntry.getText());
				}
				mainFrame.pack();
			}
		});

		/**
		 * JButton for canceling an order.
		 */
		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				receiptPanel.removeAll(); //removes all of the items in the receiptPanel.
				order = new OrderModel(); //Instantiates a new order.
				System.out.println("Order cancelled.");
				orderInformation.setText("Order cancelled.");
				mainFrame.pack();
			}
		});

		/**
		 * Adding panels back into the interface.
		 */
		orderPanel.add(creditCardEntry);
		orderPanel.add(receiptPanel);
		orderPanel.add(confirm);
		orderPanel.add(cancel);

		/**
		 * Creating the menu item buttons and giving them their functionality.
		 */
		MenuModel menuItemButtons = presenter.getMenuModel();
		JPanel itemButtons = new JPanel();
		
		int rows = (int)Math.ceil(Math.sqrt(menuItemButtons.getSize()));
		int columns = (int)Math.ceil(Math.sqrt(menuItemButtons.getSize()));
		
		itemButtons.setLayout(new GridLayout(rows,columns)); 
		
		JLabel totalCost = new JLabel("Total: " + order.getTotalCost());
		
		/**
		 * Adding listeners to every item button.
		 */
		for(ItemModel it : menuItemButtons)
		{
			String itemName = it.getName();
			JButton menuItem = new JButton(itemName);
			menuItem.addActionListener(e -> { 
				order.add(it);
				receiptPanel.add(new JLabel (itemName));
				receiptPanel.remove(totalCost); //remove total cost, since it has been updated
				totalCost.setText("Total: " + order.getTotalCost());
				receiptPanel.add(totalCost); //add in the new total cost after the update.
				mainFrame.pack(); 
			});
			itemButtons.add(menuItem);
		
		}
		/**
		 * Setting layout of the created aspects.
		 */
		mainFrame.add(menuPanel, BorderLayout.NORTH);
		mainFrame.add(itemButtons, BorderLayout.CENTER);
		mainFrame.add(orderPanel, BorderLayout.SOUTH);
		mainFrame.setSize(800,600);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
