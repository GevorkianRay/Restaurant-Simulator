/**
 * American-Express Credit Card class.
 * Sub-class of Credit Card.
 * Validates whether or not a given Credit Card number matches the following case:
 * First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
 */
public class AmExCC extends CreditCard
{
	public static final int APPROVED_CARD_LENGTH = 15; //Constant variable signifying the length an American Express must be.

	/**
	 * Initializes an American Express Credit Card
	 * @param creditCardNumber
	 */
	public AmExCC(String creditCardNumber)
	{
		super(creditCardNumber);
	}

	/**
	 * Static method that checks if the American Express passes the given conditions
	 * @param creditCardNumber
	 * @return whether or not the American Express is valid
	 */
	public static boolean authorize(String creditCardNumber)
	{
		if (CreditCard.authorize(creditCardNumber))
		{
			if( creditCardNumber.length() != APPROVED_CARD_LENGTH) return false;  //ensures the card length is 15.
			if(!creditCardNumber.substring(0, 1).equals("3"))   return false; // Checks to see if the card begins with a 3.
			if( creditCardNumber.substring(1, 2).equals("0") || //Checks to see if the second digit of the card is a 0, 1, 2, 3, 5, 6, 8, or 9.
				creditCardNumber.substring(1, 2).equals("1") || //This can be simplified by checking only for 4 or 7.
				creditCardNumber.substring(1, 2).equals("2") ||
				creditCardNumber.substring(1, 2).equals("3") ||
				creditCardNumber.substring(1, 2).equals("5") ||
				creditCardNumber.substring(1, 2).equals("6") ||
				creditCardNumber.substring(1, 2).equals("8") ||
				creditCardNumber.substring(1, 2).equals("9")) return false;		
		}
		return true;
	}
}

