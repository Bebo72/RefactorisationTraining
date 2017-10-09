/**
 * 
 */
package videoStore;

/**
 * @author Bebo
 *
 */
public class FrenchStatement extends Statement
{

    /**
     * @param c
     */
    public FrenchStatement(Customer c)
    {
        super(c);
    }
    
    public String printHeader()
    {
        return "Enregistrement de location pour " + customer.getName() + "\n";
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
        return "Le montant dû est " + customer.getTotalCharge() + "\n" + "Vous avez gagné " + customer.getTotalPoints() + " points de fidélité\n";
    }

}
