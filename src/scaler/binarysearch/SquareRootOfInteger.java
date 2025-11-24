package scaler.binarysearch;

public class SquareRootOfInteger {

    /**
     * Given an integer A. Compute and return the square root of A.
     * If A is not a perfect square, return floor(sqrt(A)).
     *
     * NOTE:
     *    The value of A*A can cross the range of Integer.
     *    Do not use the sqrt function from the standard library.
     *    Users are expected to solve this in O(log(A)) time.
     *
     * Input 1:
     *  11
     *
     *  Input 2:
     *  9
     *
     *  Output 1:
     *  3
     *
     *  Output 2:
     *  3
     */

    public int sqrt(int A) {
        int low = 0, high = A;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long product = mid * mid;

            if (product == A) {
                return mid;
            } else if (product < A) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
