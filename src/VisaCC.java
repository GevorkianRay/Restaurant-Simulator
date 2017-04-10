/**
 * Visa Credit Card class.
 * Sub-class of Credit Card.
 * Validates whether or not a given Credit Card number matches the following case:
 * First digit is a 4. Length is either 13 or 16 digits.
 */
public class VisaCC extends CreditCard
{
	public static final int[] APPROVED_CARD_LENGTHS = {13, 16}; //Array of the two sizes of acceptable credit card lengths for Visa.
	
	/**
	 * Constructor for initializing a Visa Credit Card.
	 * @param creditCardNumber
	 */
	public VisaCC(String creditCardNumber)
	{
		super(creditCardNumber);
	}
	
	/**
	 * Static method that checks if the Visa Card passes the given cases.
	 * @param creditCardNumber
	 * @return whether or not the Visa Card is valid
	 */
	public static boolean authorize(String creditCardNumber)
	{
		      if (CreditCard.authorize(creditCardNumber))
		      {
		    	  if(!creditCardNumber.substring(0, 1).equals("4")) return false; //checks if the first digit is a 4.
		    	  if(creditCardNumber.length() != 16 && creditCardNumber.length() != 13) return false; //checks if the length is 16 or 13, or neither.
		    	  return true;
		}
		      return true;
	}
}
