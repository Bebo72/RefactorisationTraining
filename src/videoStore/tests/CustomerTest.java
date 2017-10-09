package videoStore.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.Customer;
import videoStore.EnglishStatement;
import videoStore.Movie;
import videoStore.Rental;
import videoStore.Statement;

public class CustomerTest
{

    private Customer grandmaman;
    private Movie movies[] = new Movie[5];
    private Rental rental[] = new Rental[3];
    private Statement statement;

    /**
     * 
     */
    @Before
    public void setup()
    {
        movies[0] = new Movie("Caillou a le cancer", Movie.CHILDRENS);
        movies[1] = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
        movies[2] = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
        movies[3] = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
        movies[4] = new Movie("Les gars chauds se cachent pour vomir", Movie.REGULAR);

        rental[0] = new Rental(movies[0], 10); // Childrens
        rental[1] = new Rental(movies[1], 10); // New Release
        rental[2] = new Rental(movies[3], 10); // Regular

        grandmaman = new Customer("Grand-m�man");

        grandmaman.addRentals(new Rental(movies[0], 4));
        grandmaman.addRentals(new Rental(movies[1], 1));
        grandmaman.addRentals(new Rental(movies[2], 2));
        grandmaman.addRentals(new Rental(movies[3], 7));
        grandmaman.addRentals(new Rental(movies[4], 1));
        
        statement = new EnglishStatement(grandmaman);
    }

    @Test
    public void testEnglishWholeTextStatement()
    {

        String expected = "Rental Record for Grand-m�man\n";
        expected += "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expected += "Amount owed is 23.5\n";
        expected += "You earned 7.0 frequent renter points\n";
        // System.out.println(expected);
        // System.out.println(grandmaman.statement());
        assertEquals(grandmaman.englishStatement(), expected);
    }

    @Test
    public void testFrenchhWholeTextStatement()
    {

        String expected = "Enregistrement de location pour Grand-m�man\n";
        expected += "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expected += "Le montant dû est 23.5\n";
        expected += "Vous avez gagné 7.0 points de fidélité\n";
        // System.out.println(expected);
        // System.out.println(grandmaman.statement());
        assertEquals(grandmaman.frenchStatement(), expected);
    }

    @Test
    public void testCalculTotalPoints()
    {
        assertEquals(grandmaman.getTotalPoints(), 7, 0.001);
    }

    @Test
    public void testCalculTotalCharge()
    {
        assertEquals(grandmaman.getTotalCharge(), 23.5, 0.001);
    }

    @Test
    public void testPrintEnglishStatement()
    {
        String expected = "Rental Record for Grand-m�man\n";
        expected += "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expected += "Amount owed is 23.5\n";
        expected += "You earned 7.0 frequent renter points\n";
        // System.out.println(expected);
        // System.out.println(grandmaman.statement());

        assertEquals(grandmaman.englishStatement(), expected);
    }
    
    @Test
    public void testPrintSubdivisé()
    {
        String expected = "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";

        assertEquals(statement.printHeader(), "Rental Record for Grand-m�man\n");
        assertEquals(statement.printRentalLine(), expected);
        assertEquals(statement.printFooter(),"Amount owed is 23.5\nYou earned 7.0 frequent renter points\n");
    }

    @After
    public void teardown()
    {
        grandmaman = null;
    }

}
