package data_structures.hash_table;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    /** Return the first recurring character
     *
     * [2,5,1,2,3,5,1,2,4]
     * It should return 2
     *
     * [2,1,1,2,3,5,1,2,4]
     * It should return 1
     *
     * [2, 3, 4, 5]
     * It should return null
     * */

    public static Integer findFirstRecurringCharacter(int[] inputArray) {
        Set<Integer> inputNumbers = new HashSet<>();
        for (int number : inputArray) {
            if (inputNumbers.contains(number)) return number;
            else inputNumbers.add(number);
        }
        return null;
    }

    public static void main(String[] args) {
        assert 2 == findFirstRecurringCharacter(new int[]{2,5,1,2,3,5,1,2,4});
        assert 1 == findFirstRecurringCharacter(new int[]{2,1,1,2,3,5,1,2,4});
        assert null == findFirstRecurringCharacter(new int[]{2, 3, 4, 5});
    }
}
