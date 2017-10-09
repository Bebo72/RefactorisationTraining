/**
 * 
 */
package videoStore;

/**
 * @author Bebo
 *
 */
public class EnglishStatement extends Statement
{

    /**
     * @param c
     */
    public EnglishStatement(Customer c)
    {
        super(c);
    }
    
    public String printHeader()
    {
        return "Rental Record for " + customer.getName() + "\n";
    }

    public String printRentalLine()
    {
        String result = "";

        for (Rental each : customer.getRentals())
        {

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.calculatePrice() + "\n";
        }

        return result;
    }

    public String printFooter()
    {
        return "Amount owed is " + customer.getTotalCharge() + "\n" + "You earned " + customer.getTotalPoints() + " frequent renter points\n";
    }
}
