package google_problems;

import java.util.HashSet;
import java.util.Set;

public class NumberPairSum {

    /**
     * Question:
     * For the given array of numbers find the pair of numbers which sums up & matches the given input.
     * <p>
     * Sum: 8
     * <p>
     *
     * Input a: [1, 2, 3, 9]
     * Input b: [1, 2, 4, 4]
     * <p>
     * Return true if match found, else return false.
     */



    public static void main(String[] args) {
        int[] inputA = {1, 2, 3, 9};
        int[] inputB = {1, 2, 4, 4};
        int matcher = 8;

        System.out.println(isPairOfElementMatchesSumHashSet(inputB, matcher));
    }

    /** 2 nested loops like for(i) { for(j){ arr[i] == arr[j] return true}}
    * O(n^2)*/
    static boolean isPairOfElementMatchesSumNestedLoop(int[] array, int matcher) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == matcher) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Run a loop & get the complement of the current index with matcher & run a binary search
     * with the remaining indexes to find the complement
     * <p>
     *
     * Ex:  [1, 2, 3, 9] , Sum: 8
     * <p>
     * => 8-1 = 7 search 7 from the remaining index [2, 3, 9]
     * <p>
     * => 8-2 = 6 search 6 from the remaining index [3, 9]
     * <p>
     * => 8-3 = 5 search 5 from the remaining index [9]
     * */
    static boolean isPairOfElementMatchesSumSingleLoop(int[] array, int matcher) {
        for (int i = 0; i < array.length - 1; i++) {
            int complement = matcher - array[i];
            if (binarySearch(array, complement, i + 1, array.length - 1)) {
                return  true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /** Two pointer approach O(n)
     * <p>
     * sum the first & last index values & shift the positions accordingly.
     * <p>
     * if the sum < matcher increment the starting position by one
     * <p>
     * if the sum > matcher decrement the ending position by one
     * <p>
     * Ex: [1, 2, 3, 9] , Sum: 8
     * <p>
     * => start:0[1], end: 3[9]  ; sum= 1+9=10 ; It's greater than the matcher 8 so decrement the end position
     * <p>
     * => start:0[1], end: 2[3]  ; sum= 1+3=4 ; It's lesser than the matcher 8 so increment the starting position
     * <p>
     * => start:1[2], end: 2[3]  ; sum= 2+3=5 ; It's lesser than the matcher 8 so increment the starting position
     * <p>
     * => start:2[3], end: 2[3], the loop will close here as the both start & end index met each other.*/
    static boolean isPairOfElementMatchesSumTwoPointer(int[] array, int matcher) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == matcher) return true;
            else if (sum < matcher) left++;
            else right--;
        }
        return false;
    }

    /** Unsorted Array O(n)
     * Create a hash set which is faster for lookup search & store the complements of the current index with matcher.
     * <p></>
     * Ex:  [1, 2, 3, 9] , Sum: 8
     * => 8 - 1 = 7; Set = [] ; 7 is not found in the set, let's store it; Set = [7]
     * <p>
     * => 8 - 2 = 6; Set = [7] ; 7 is not found in the set, let's store it; Set = [7, 6]
     * <p>
     * => 8 - 3 = 5; Set = [7, 6] ; 5 is not found in the set, let's store it; Set = [7, 6, 5]
     * <p></>
     * => 8 - 9 = -1; Set = [7, 6, 5] ; -1 is not found in the set, let's store it; Set = [7, 6, 5, -1]
     * <p></>
     * Loop ends & return false
     * */
    static boolean isPairOfElementMatchesSumHashSet(int[] array, int matcher) {
        Set<Integer> complementValues = new HashSet<>();
        for (int element : array) {
            int complement = matcher - element;
            if (complementValues.contains(complement)) {
                return true;
            } else {
                complementValues.add(complement);
            }
        }
        return false;
    }

}
