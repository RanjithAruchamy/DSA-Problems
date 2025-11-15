package scaler.binarysearch;

import java.util.Arrays;

public class SearchForARange {

    /**
     *  Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
     *
     * Return an array of size 2, such that
     *           First element = Left most index of B in A
     *           Second element = Right most index of B in A.
     * If B is not found in A, return [-1, -1].
     *
     * Note : Note: The time complexity of your algorithm must be O(log n)..
     *
     * Input 1:
     *  A = [5, 7, 7, 8, 8, 10]
     *  B = 8
     *
     *  Input 2:
     *  A = [5, 17, 100, 111]
     *  B = 3
     *
     *  Output 1:
     *  [3, 4]
     *
     *  Output 2:
     *  [-1, -1]
     */

    public static int[] searchRange(final int[] A, int B) {
        int[] resArr = new int[]{-1,-1};
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B) {
                resArr[0] = mid;
                high = mid - 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else if (A[mid] < B) {
                low = mid + 1;
            }
        }

        low = 0;
        high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B) {
                resArr[1] = mid;
                low = mid + 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else if (A[mid] < B) {
                low = mid + 1;
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 17, 100, 111}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 10)));
    }
}
