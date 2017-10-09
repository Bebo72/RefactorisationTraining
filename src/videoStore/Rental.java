/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package videoStore;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The class Rental is just a simple data class
 */

public class Rental {
	private int daysRented_;
	private Movie movie_;

	public Rental(Movie movie, int daysRented) {
		movie_ = movie;
		daysRented_ = daysRented;
	}

	public int getDaysRented() {
		return daysRented_;
	}

	public Movie getMovie() {
		return movie_;
	}

    /**
     * @return
     */
    public double calculatePrice()
    {
        double thisAmount = 0;
        
        // determines amount for each line
        switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (getDaysRented() > 2)
                thisAmount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            thisAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (getDaysRented() > 3)
                thisAmount += (getDaysRented() - 3) * 1.5;
            break;
        }
        
        return thisAmount;
    }

    /**
     * @return
     */
    public double getPoints()
    {
        // add bonus for a new release rental
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE)
            return 2;
        return 1;
    }
}
