/**
 * Master-Card Credit Card class.
 * Sub-class of Credit Card.
 * Validates whether or not a given Credit Card number matches the following case:
 * First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.
 */
public class MasterCC extends CreditCard
{
	public static final int APPROVED_CARD_LENGTH = 16; //Constant variable signifying the length an Master Card must be.

	/**
	 * Constructor for initializing a Master Card.
	 * @param creditCardNumber
	 */
	public MasterCC(String creditCardNumber)
	{
		super(creditCardNumber);
	}

	/**
	 * Static method that checks if the Master Card passes the given conditions
	 * @param creditCardNumber
	 * @return whether or not the Master Card is valid
	 */
	public static boolean authorize(String creditCardNumber)
	{
		if(CreditCard.authorize(creditCardNumber))
		{
			if(creditCardNumber.length() != APPROVED_CARD_LENGTH) { return false; } //return false if the card is not of length 16
			else
			{
				if(!creditCardNumber.substring(0, 1).equals("5")) return false; //return false it the credit-card does not start with a 5.
				if(creditCardNumber.substring(1,2).equals("0") || //return false if the second digit of the card is a 0, 6, 7, 8, or 9.
				   creditCardNumber.substring(1,2).equals("6") ||
				   creditCardNumber.substring(1,2).equals("7") ||
				   creditCardNumber.substring(1,2).equals("8") ||
				   creditCardNumber.substring(1,2).equals("9")) return false;
			}
		}
		return true;
	}
}

