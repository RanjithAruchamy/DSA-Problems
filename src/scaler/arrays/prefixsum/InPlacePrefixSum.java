package scaler.arrays.prefixsum;

import java.util.Arrays;

public class InPlacePrefixSum {
    /**
     * Given an array A of N integers. Construct prefix sum of the array in the given array itself.
     *
     * 1 <= N <= 105
     * 1 <= A[i] <= 103
     *
     * InputA:
     * A = [1, 2, 3, 4, 5]
     *
     * InputB:
     * A = [4, 3, 2]
     *
     * OutputA:
     * [1, 3, 6, 10, 15]
     *
     * OutputB:
     * [4, 7, 9]
     */

    public static int[] solve(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i-1];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] inputA = {1, 2, 3, 4, 5};
        int[] expectedOutputA = {1, 3, 6, 10, 15};
        int[] actualOutputA = solve(inputA);
        assert Arrays.equals(expectedOutputA, actualOutputA);

        int[] inputB = {4, 3, 2};
        int[] expectedOutputB = {4, 7, 9};
        int[] actualOutputB = solve(inputB);
        assert Arrays.equals(expectedOutputB, actualOutputB);
    }
}
