/**
 * Credit Card class.
 * Parent class of MasterCC, AmExCC, DiscoverCC, and VisaCC.
 * Creates instances of the various types of credit cards after checking their validity.
 * Is able to determine if the input was a string of numbers (part of validation process).
 * Relies on factory class to create instances of the various credit cards.
 * Is able to return the name of the various credit cards as strings.
 * Contains a mutate method to mask the credit card number in the output.
 */
public class CreditCard
{
	private String creditCardNumber; // This can also be declared as protected if needed.
	public static final int MAXIMUM_CARD_LENGTH = 19; //Maximum length a credit-card can be, thought input is limited in the JTextField.
	
	/**
	 * Constructor for a Credit Card. 
	 * Creates a Credit Card given an input of numbers.
	 * @param creditCardNumber - a customer's input.
	 */
	public CreditCard(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;		
	}
	
	/**
	 * Non-static method that validates the legitimacy of a Credit Card.
	 * @return true or false - whether or not the card is valid.
	 */
	public boolean authorize()
	{
		return authorize(creditCardNumber);
	}
	
	/**
	 * Static method that validates a the card numbers by checking the length and if they are numbers.
	 * @param creditCardNumber
	 * @return true or false - whether or not the numbers pass the given conditions.
	 */
	public static boolean authorize(String creditCardNumber)
	{
		if(creditCardNumber.length() > MAXIMUM_CARD_LENGTH) return false; //if the length is greater than 19 - return false
		if(!isDigitsOnly(creditCardNumber)) return false; //if the card has any digits that are not numbers, return false;
		return true; 
	}

	/**
	 * Determines the type of Credit Card and returns a String stating the name of said card.
	 * @return a String - stating what the credit card is.
	 */
	public String getName()
	{
		if (VisaCC.authorize(creditCardNumber))  return "Visa Credit Card";
		if (DiscoverCC.authorize(creditCardNumber))  return "Discover Credit Card";
		if(MasterCC.authorize(creditCardNumber))  return "Master Credit Card"; 
		if(AmExCC.authorize(creditCardNumber))  return "American Express Credit Card"; 
		else return "Sorry! Invalid Entry!";	
	}
	
	/**
	 * Determines whether or not the given String contains anything other than numbers.
	 * @param creditCardNumber
	 * @return true or false.
	 */
	public static boolean isDigitsOnly(String creditCardNumber)
	{
		String[] cardInput = creditCardNumber.split(""); //splits at every character
		for(int i = 0; i < cardInput.length; i++)
			if(!cardInput[i].matches("\\d")) return false; //returns false if it reaches a character that isn't a digit.
	      return true;
	}

	/**
	 * Method to mask the credit card number for security purposes. Replaces some digits with asterisks.
	 * @param numberToMask - the creditCardNumber to alter / manipulate.
	 * @return part + asterisk - The mutated credit card number, which now has the first 6 digits displayed normally followed by asterisks.
	 */
	public String secureNumber(String numberToMask)
	{
		int length = numberToMask.length();	
		String asterisk = "*";
		String part = numberToMask.substring(0, 6);	//Shows the first 6 digits as they normally appear.
		for(int i = 0; i < length - 7; i++)		//Makes a string of asterisks to 'mask' the rest of the digits with asterisks.
		{
			asterisk += "*";
		}
		return part + asterisk;
	}
}
