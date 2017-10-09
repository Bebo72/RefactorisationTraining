/**
 * 
 */
package videoStore;

/**
 * @author Bebo
 *
 */
public abstract class Statement
{
    Customer customer;

    public Statement(Customer c)
    {
        customer = c;
    }

    public String print()
    {
        return printHeader() + printRentalLine() + printFooter();
    }

    public abstract String printHeader();
    public abstract String printRentalLine();
    public abstract String printFooter();
}
