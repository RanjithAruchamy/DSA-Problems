package scaler.arrays.slidingwindow;

public class MaximumSubarraySumOfFixedLength {
    /**
     * Given an array A of length N, Find the maximum subarray sum out of all possible subarray of length B.
     *
     * 1 <= N <= 10^5
     * 1 <= A[i] <= 10^6
     *
     * InputA:
     * A = [6, 7, 8, 2]
     * B = 2
     *
     * InputB:
     * A = [3, 9, 5, 6, 5, 11]
     * B = 3
     *
     * OutputA: 15
     *
     * OutputB: 22
     *
     */

    public static long solve(int[] A, int B) {
        int initialSubArraySum = 0;
        for (int i = 0; i < B; i++) {
            initialSubArraySum += A[i];
        }

        int maxSum = initialSubArraySum;
        for (int i = 1; i <= A.length - B; i++) {
            int subArraySum = initialSubArraySum - A[i - 1] + A[B + i - 1];
            maxSum = Math.max(maxSum, subArraySum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arrA = {6, 7, 8, 2};
        int B1 = 2;
        assert 15 == solve(arrA, B1);

        int[] arrB = {3, 9, 5, 6, 5, 11};
        int B2 = 3;
        assert 22 == solve(arrB, B2);
    }
}
