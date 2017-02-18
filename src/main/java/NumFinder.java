import java.util.ArrayList;

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

            for (Integer value : values) {
                if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
                    throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT, value, MINIMUM_VALUE, MAXIMUM_VALUE));
                }
            }

        }

        return 0;
    }

}
