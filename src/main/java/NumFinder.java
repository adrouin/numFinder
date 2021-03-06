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

        if (this.notEmptyAndNotNull(values)) {

            // Check if numbers are between MINIMUM_VALUE and MAXIMUM_VALUE
            this.areAuthorizedNumbers(values);

            // Add zero to the list and sort it
            this.addZeroAndSort(values);

            // Find the zero index
            int zeroIndex = this.findIndexOfZeroValue(values);

            // return the closest to zero, the two parameter is the two values next to 0
            return this.findClosestZero(

                    this.findValueBeforeIndex(values, zeroIndex),
                    this.findValueAfterIndex(values, zeroIndex)

            );

        }

        return 0;
    }

    /**
     * Return true if list is not empty and not null
     * @param values
     * @return
     */
    private boolean notEmptyAndNotNull(ArrayList<Integer> values) {
        return values != null && !values.isEmpty();
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
     * If list already contain 0 don't add it
     */
    protected void addZeroAndSort(ArrayList<Integer> values) {

        if (!values.contains(0)) {
            values.add(0);
        }

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

    /**
     * Return the closest to zero value between 2 value
     */
    protected int findClosestZero(int valueBeforeZero, int valueAfterZero) {

        if (Math.abs(valueBeforeZero) < Math.abs(valueAfterZero)) {
            return valueBeforeZero;
        } else {
            return valueAfterZero;
        }

    }

    /**
     * Return the value at index-1 of the list
     * In case of IndexOutOfBounds return Integer.MIN_VALUE
     */
    protected int findValueBeforeIndex(ArrayList<Integer> values, int index) {

        if (index-1 < 0) {
            return Integer.MIN_VALUE;
        } else {
            return values.get(index-1);
        }

    }

    /**
     * Return the value at index+1 of the list
     * In case of IndexOutOfBounds return Integer.MAX_VALUE
     */
    protected int findValueAfterIndex(ArrayList<Integer> values, int index) {

        if(index+1 >= values.size()) {
            return Integer.MAX_VALUE;
        } else {
            return values.get(index+1);
        }
    }
}
