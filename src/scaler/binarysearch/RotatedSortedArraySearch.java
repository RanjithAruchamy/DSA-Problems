package scaler.binarysearch;

public class RotatedSortedArraySearch {

    /**
     * Given a sorted array of integers A of size N and an integer B,
     * where array A is rotated at some pivot unknown beforehand.
     *
     * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
     *
     * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
     *
     * You can assume that no duplicates exist in the array.
     *
     * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
     *
     * Input 1:
     * A = [4, 5, 6, 7, 0, 1, 2, 3]
     * B = 4
     *
     *  Input 2:
     * A : [ 9, 10, 3, 5, 6, 8 ]
     * B : 5
     *
     * Output 1:
     *  0
     *
     *  Output 2:
     *  3
     */

    public int search(final int[] A, int B) {
        int low = 0, high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (A[mid] == B) return mid;
            if (A[low] <= A[mid]) {
                if (A[low] <= B && A[mid] > B) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[high] >= B && A[mid] < B) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


}
