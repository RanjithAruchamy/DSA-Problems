package scaler.arrays.subarray;

public class MaximumSubarrayEasy {
    /**
     * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
     * But the sum must not exceed B.
     *
     * 1 <= A <= 103
     * 1 <= B <= 109
     * 1 <= C[i] <= 106
     *
     * InputA:
     * A = 5
     * B = 12
     * C = [2, 1, 3, 4, 5]
     *
     * InputB:
     * A = 3
     * B = 1
     * C = [2, 2, 2]
     *
     * OutputA: 12
     *
     * OutputA: 0
     */

    public static int maxSubarray(int A, int B, int[] C) {
        int maxSum = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C[j];
                if (sum <= B) {
                    maxSum = Math.max(sum, maxSum);
                } else {
                    break;
                }
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int A1 = 5;
        int B1 = 12;
        int[] C1 = {2, 1, 3, 4, 5};
        assert 12 == maxSubarray(A1, B1, C1);

        int A2 = 3;
        int B2 = 1;
        int[] C2 = {2, 2, 2};
        assert 0 == maxSubarray(A2, B2, C2);
    }
}
