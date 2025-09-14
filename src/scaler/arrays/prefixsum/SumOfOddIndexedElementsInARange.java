package scaler.arrays.prefixsum;

import java.util.Arrays;

public class SumOfOddIndexedElementsInARange {

    /**
     * You are given:
     * An integer array A representing the array of numbers of size N.
     * A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1], representing the range [L, R].
     *
     * For each query in B, calculate the sum of elements in A at odd indices within the specified range [L, R] and return the results as an array.
     *
     * 1 <= N <= 10^5
     * -10^5 <= A[i] <= 10^5
     * 1 <= Q <= 10^5
     * 0 <= B[i][0], B[i][1] < N
     * B[i][0] <= B[i][1].
     *
     * InputA:
     * A = [2, 8, 3, 9, 15]
     * B = [ [1, 4],
     *       [0, 2],
     *       [2, 3] ]
     *
     * InputB:
     *  A = [5, 15, 25, 35, 45]
     *  B = [ [2, 2],
     *       [2, 4] ]
     *
     * OutputA:
     * [17, 8, 9]
     *
     * OutputB:
     * [0, 35]
     */

    public static int[] sumOfOddIndexedElements(int[] A, int[][] B) {
        int[] prefOddSum = new int[A.length];
        prefOddSum[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (i %2 != 0) {
                prefOddSum[i] = prefOddSum[i - 1] + A[i];
            } else {
                prefOddSum[i] = prefOddSum[i - 1];
            }
        }

        int[] resultArr = new int[B.length];
        for (int i = 0; i < B.length ; i++) {
            int start = B[i][0], end = B[i][1];
            if (start == 0) {
                resultArr[i] = prefOddSum[end];
            } else {
                resultArr[i] = prefOddSum[end] - prefOddSum[start - 1];
            }
        }
        return resultArr;

    }

    public static void main(String[] args) {
        int[] arrA = {2, 8, 3, 9, 15};
        int[][] queryA = { {1, 4},
                {0, 2},
                {2, 3} };
        int[] expectedOutputA = {17, 8, 9};
        int [] actualOutputA = sumOfOddIndexedElements(arrA, queryA);
        assert Arrays.equals(expectedOutputA, actualOutputA);

        int[] arrB = {5, 15, 25, 35, 45};
        int[][] queryB = { {2, 2},
                {2, 4} };
        int[] expectedOutputB = {0, 35};
        int [] actualOutputB = sumOfOddIndexedElements(arrB, queryB);
        assert Arrays.equals(expectedOutputB, actualOutputB);
    }
}
