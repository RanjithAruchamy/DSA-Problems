package scaler.arrays.subarray;

public class MaximumContiguousSubArray {

    /**
     * Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
     * In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
     *
     * 1 <= N <= 106
     * -1000 <= A[i] <= 1000
     *
     *  InputA:
     *  A = [1, 2, 3, 4, -10]
     *
     *  InputB:
     *   A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     *
     *   OutputA:   10
     *
     *   OutputB:   6
     */

    public static int maxSubArrayKadaneSAlgo(final int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > maxSum)
                maxSum = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static int maxSubArrayCarryForward(final int[] A) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubArrayPrefSum(final int[] A) {
        int[] prefSum = new int[A.length];
        prefSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefSum[i] = prefSum[i-1] + A[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int sum = 0;
                if (i == 0) {
                    sum = prefSum[j];
                } else {
                    sum = prefSum[j] - prefSum[i - 1];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubArrayBF(final int[] A) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += A[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] inputA = {1, 2, 3, 4, -10};
        assert 10 == maxSubArrayKadaneSAlgo(inputA);

        int[] inputB = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert 6 == maxSubArrayKadaneSAlgo(inputB);

        int[] inputC = {-500};
        assert -500 == maxSubArrayKadaneSAlgo(inputC);
    }
}
