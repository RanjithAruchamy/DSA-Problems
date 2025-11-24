package scaler.binarysearch;

public class SpecialInteger {

    /**
     * Given an array of integers A and an integer B, find and return the maximum value K
     * such that there is no subarray in A of size K with the sum of elements greater than B.
     *
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = 10
     *
     *  Input 2:
     * A = [5, 17, 100, 11]
     * B = 130
     *
     * Output 1:
     *  2
     *
     *  Output 2:
     *  3
     *
     */

    public static int solve(int[] A, int B) {
        int low = 1, high = A.length;
        int ans = 0;    // Ans should be 0 if no sub array is less than B
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isSumGreaterThanB(A, B, mid)) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isSumGreaterThanB(int[] arr, int maxValue, int sizeOfWindow) {
        long sum = 0;
        boolean isSumMax = false;
        for (int i = 0; i < sizeOfWindow; i++) {
            sum += arr[i];
        }
        if (sum > maxValue) isSumMax = true;

        for (int i = 1; i < arr.length - sizeOfWindow + 1; i++) {
            sum = sum - arr[i - 1] + arr[i + sizeOfWindow - 1];
            if (sum > maxValue) isSumMax = true;
        }
        return isSumMax;
    }

    public static void main(String[] args) {
        assert 2 == solve(new int[]{1, 2, 3, 4, 5}, 10);
        assert 3 == solve(new int[]{5, 17, 100, 11}, 130);
    }
}
