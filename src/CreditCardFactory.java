/**
 * Factory method for creating Credit Cards.
 * Instantiates a credit-card based off a given String.
 * Newer types of credit-cards can be easily added to the factory.
 */
public class CreditCardFactory 
{
	public CreditCard getCreditCard(String creditCardNumber)
	   {
	      if (CreditCard.authorize(creditCardNumber))
	      {
	         if (AmExCC.authorize(creditCardNumber)) return new AmExCC(creditCardNumber);
	         if (DiscoverCC.authorize(creditCardNumber)) return new DiscoverCC(creditCardNumber);
	         if (MasterCC.authorize(creditCardNumber)) return new MasterCC(creditCardNumber);
	         if (VisaCC.authorize(creditCardNumber)) return new VisaCC(creditCardNumber);
	         return null;
	      }
	      else return null;
	   }
}
