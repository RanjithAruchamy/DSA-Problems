package scaler.binarysearch;

public class MaximumHeightOfStaircase {

    /**
     * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
     * The first stair would require only one block, and the second stair would require two blocks, and so on.
     * Find and return the maximum height of the staircase.
     *
     * Input 1:
     *  A = 10
     *
     *  Input 2:
     *  A = 20
     *
     *  Output 1:
     *  4
     *
     *  Output 2:
     *  5
     */

    // Sum of N natural number is n (n + 1) / 2  => Since we have to calculate sum of n steps to calculate the total number of blocks.
    public int solveBinarySearch(int A) {
        int low = 0, high = A;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum <= A) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int solve(int A) {
        int qty = A;
        for (int i = 1; i < A; i++) {
            qty = qty - i;
            if (qty == 0) return i;
            else if (qty < 0) {
                return i - 1;
            }
        }
        return 0;
    }
}
