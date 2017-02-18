import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by adr on 18/02/2017.
 */
public class NumFinder {

    /** Minimum authorized value in list. */
    private final static int MINIMUM_VALUE = -273;

    /** Maximum authorized value in list. */
    private final static int MAXIMUM_VALUE = 5526;

    private final static String ILLEGAL_ARGUMENT =  "Le nombre %1$s dans la liste n'est pas compris entre %2$s et %3$s";

    /**
     * Find the closest number to zero in ArrayList
     * - Empty or null list return 0
     * - Only number between -273 and 5526 are accepted
     */
    public int findClosestZero(ArrayList<Integer> values) throws IllegalArgumentException{

        if (values != null) {

            // Check if numbers are between MINIMUM_VALUE and MAXIMUM_VALUE
            this.areAuthorizedNumbers(values);


        }

        return 0;
    }

    /**
     * Check if numbers are between MINIMUM_VALUE and MAXIMUM_VALUE
     * @param values number list
     */
    protected void areAuthorizedNumbers(ArrayList<Integer> values) {
        for (Integer value : values) {
            if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
                throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT, value, MINIMUM_VALUE, MAXIMUM_VALUE));
            }
        }
    }

    /**
     * Add zero to list and sort it
     */
    protected void addZeroAndSort(ArrayList<Integer> values) {

        values.add(0);
        Collections.sort(values);
    }

    /**
     * Find index of zero value
     * If zero is not present return -1
     */
    protected int findIndexOfZeroValue(ArrayList<Integer> values) {

        int index = -1;

        for (int i=0; i<values.size(); i++) {
            if (values.get(i) == 0) {
                index = i;
            }
        }

        return index;
    }
}
