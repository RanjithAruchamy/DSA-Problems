package scaler.binarysearch;

public class SortedInsertPosition {

    /**
     * You are given a sorted array A of size N and a target value B.
     * Your task is to find the index (0-based indexing) of the target value in the array.
     *
     * If the target value is present, return its index.
     * If the target value is not found, return the index of least element greater than equal to B.
     * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
     * Your solution should have a time complexity of O(log(N)).
     *
     * Input 1:
     * A = [1, 3, 5, 6]
     * B = 5
     *
     *  Input 2:
     * A = [1, 4, 9]
     * B = 3
     *
     * Output 1:
     * 2
     *
     * Output 2:
     * 1
     */

    public int searchInsert(int[] A, int B) {
        int low = 0, high = A.length - 1;
        int ans = A.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                return mid;
            } else if (A[mid] > B) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
