/**
 * Discover Credit Card class.
 * Sub-class of Credit Card.
 * Validates whether or not a given Credit Card number matches the following case:
 * First four digits are 6011. Length is 16 digits.
 */
public class DiscoverCC extends CreditCard
{
	public static final int APPROVED_CARD_LENGTH = 16; //Constant variable signifying the length an Discover Card must be.
	
	/**
	 * Constructor for initializing a Discover Card.
	 * @param creditCardNumber
	 */
	public DiscoverCC(String creditCardNumber)
	{
		super(creditCardNumber);
	}	
	
	/**
	 * Static method that checks if the Discover Card passes the given conditions
	 * @param creditCardNumber
	 * @return whether or not the Discover Card is valid
	 */
	public static boolean authorize(String creditCardNumber)
	{
		     if(creditCardNumber.length() !=  APPROVED_CARD_LENGTH) return false; //Checks if the given card number is of the length 16
		     if( !creditCardNumber.substring(0, 4).equals("6011")) return false; //checks if the card number begins with a "6011"
			return true;
	}	
}
