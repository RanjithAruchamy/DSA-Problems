package scaler.binarysearch;

public class SingleElementInSortedArray {

    /**
     * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
     * Elements which are appearing twice are adjacent to each other.
     * NOTE: Users are expected to solve this in O(log(N)) time.
     *
     * Input 1:
     * A = [1, 1, 7]
     *
     *  Input 2:
     * A = [2, 3, 3]
     *
     * Output 1:
     *  7
     *
     *  Output 2:
     *  2
     */

    public int solve(int[] A) {
        if (A.length == 1) return A[0];
        if (A[0] != A[1]) return A[0];
        if (A[A.length - 1] != A[A.length - 2]) return A[A.length - 1];

        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) return A[mid];
            if (A[mid] == A[mid - 1]) mid = mid - 1;

            if (mid % 2 == 0) low = mid + 2;    // As the mid is in even position we need to increment low to 2 position to start with new number.
            else high = mid - 1;
        }
        return -1;
    }
}
