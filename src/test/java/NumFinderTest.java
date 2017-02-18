import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adr on 18/02/2017.
 *
 * NummFinder Test Case
 */
public class NumFinderTest {

    private NumFinder numFinder = new NumFinder();

    @Test
    public void empty_list_return_zero() {
        Assert.assertEquals(0, numFinder.findClosestZero(new ArrayList<Integer>()));
    }

    @Test
    public void null_list_return_zero() {
        Assert.assertEquals(0, numFinder.findClosestZero(null));
    }


    @Test
    public void minimum_value_is_negative_273() {

        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(-99999);

        try {
            numFinder.areAuthorizedNumbers(values);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Le nombre -99999 dans la liste n'est pas compris entre -273 et 5526", e.getMessage());
        }

    }

    @Test
    public void maximum_value_is_5526() {

        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(99999);

        try {
            numFinder.areAuthorizedNumbers(values);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Le nombre 99999 dans la liste n'est pas compris entre -273 et 5526", e.getMessage());
        }

    }

}
