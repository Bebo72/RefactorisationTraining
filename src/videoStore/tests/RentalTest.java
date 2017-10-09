/**
 * 
 */
package videoStore.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import videoStore.Customer;
import videoStore.Movie;
import videoStore.Rental;

/**
 * @author Bebo
 *
 */
public class RentalTest
{
    private Movie movies[] = new Movie[5];
    private Rental rental[] = new Rental[3];

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        movies[0] = new Movie("Caillou a le cancer", Movie.CHILDRENS);
        movies[1] = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
        movies[2] = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
        movies[3] = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
        movies[4] = new Movie("Les gars chauds se cachent pour vomir", Movie.REGULAR);

        rental[0] = new Rental(movies[0], 10); // Childrens
        rental[1] = new Rental(movies[1], 10); // New Release
        rental[2] = new Rental(movies[3], 10); // Regular
    }

    @Test
    public void testCalculMontant()
    {
        assertTrue(rental[0].calculatePrice() == 12); // Childrens Movie
        assertTrue(rental[1].calculatePrice() == 30); // New Release Movie
        assertTrue(rental[2].calculatePrice() == 14); // Regular Movie
    }

    @Test
    public void testCalculFidelite()
    {
        assertTrue(rental[0].getPoints() == 1); // Childrens Movie
        assertTrue(rental[1].getPoints() == 2); // New Release Movie
        assertTrue(rental[2].getPoints() == 1); // Regular Movie
    }
    
    @Test
    public void testMoviePriceCode()
    {
        assertEquals(movies[0].getTitle(), "Caillou a le cancer");
        assertEquals(movies[0].getPriceCode(), 2);

        assertEquals(movies[1].getTitle(), "Fast and furious 38: Diesel Cars vs Google Cars");
        assertEquals(movies[1].getPriceCode(), 1);

        assertEquals(movies[3].getTitle(), "Les oiseaux se cachent pour mourir");
        assertEquals(movies[3].getPriceCode(), 0);
    }
}
