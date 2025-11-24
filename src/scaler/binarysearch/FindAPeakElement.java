package scaler.binarysearch;

public class FindAPeakElement {

    /**
     * Given an array of integers A, find and return the peak element in it.
     * An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
     *
     * NOTE:
     * It is guaranteed that the array contains only a single peak element.
     * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
     *
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     *
     *  Input 2:
     * A = [5, 17, 100, 11]
     *
     * Output 1:
     *  5
     *
     *  Output 2:
     *  100
     */

    public int solve(int[] A) {
        int size = A.length;
        if (size == 1) return A[0];
        if (A[0] > A[1]) return A[0];
        if (A[size - 1] > A[size - 2]) return A[size - 1];

        int low = 0, high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                return A[mid];
            } else if (A[mid] > A[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

}
