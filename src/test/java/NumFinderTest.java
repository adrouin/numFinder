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

    @Test
    public void add_zero_to_list_and_sort() {

        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(45);
        values.add(-1);
        values.add(23);
        values.add(-9);

        ArrayList<Integer> expectedSortedValues = new ArrayList<Integer>();
        expectedSortedValues.add(-9);
        expectedSortedValues.add(-1);
        expectedSortedValues.add(0);
        expectedSortedValues.add(23);
        expectedSortedValues.add(45);

        numFinder.addZeroAndSort(values);

        Assert.assertEquals(expectedSortedValues, values);
    }

    @Test
         public void find_index_of_zero_in_list() {

        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(23);
        values.add(-9);
        values.add(0);
        values.add(45);
        values.add(-1);

        Assert.assertEquals(2, numFinder.findIndexOfZeroValue(values));

    }

    @Test
    public void find_index_of_zero_in_list_without_zero() {

        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(23);
        values.add(-9);
        values.add(45);
        values.add(-1);

        Assert.assertEquals(-1, numFinder.findIndexOfZeroValue(values));

    }
}
