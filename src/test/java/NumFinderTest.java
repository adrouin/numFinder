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

}
