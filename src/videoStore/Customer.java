/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package videoStore;

import java.util.ArrayList;
import java.util.Vector;

import videoStore.Rental;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The Customer class represents the customer of the store.
 * 
 */

public class Customer
{
    private String name;
    private Vector<Rental> rentals;

    public Customer(String name)
    {
        this.name = name;
        rentals = new Vector<Rental>();
    }

    public void addRentals(Rental arg)
    {
        rentals.addElement(arg);
    }

    public String getName()
    {
        return name;
    }

    public String englishStatement()
    {
        EnglishStatement st = new EnglishStatement(this);
        
        return st.print();
    }

    public String frenchStatement()
    {
        String result = "Enregistrement de location pour " + getName() + "\n";

        for (Rental each : rentals)
        {

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.calculatePrice() + "\n";

        }
        // add footer lines
        result += "Le montant dû est " + getTotalCharge() + "\n";
        result += "Vous avez gagné " + getTotalPoints() + " points de fidélité\n";
        return result;
    }

    /**
     * @return
     */
    public double getTotalPoints()
    {
        double total = 0;

        for (Rental each : rentals)
        {

            total += each.getPoints();
        }

        return total;
    }

    /**
     * @return
     */
    public double getTotalCharge()
    {
        double totalAmount = 0;

        for (Rental each : rentals)
        {
            totalAmount += each.calculatePrice();
        }

        return totalAmount;
    }

    /**
     * @return
     */
    public Vector<Rental> getRentals()
    {
        return rentals;
    }
}
