package scaler.arrays.prefixsum;

import java.util.Arrays;

public class EvenNumbersInARange {

    /**
     * You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
     * Each query consists of two integers B[i][0] and B[i][1].
     * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
     *
     * 1 <= N <= 105
     * 1 <= Q <= 105
     * 1 <= A[i] <= 109
     * 0 <= B[i][0] <= B[i][1] < N
     *
     * Input A:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0, 2]
     *         [2, 4]
     *         [1, 4]   ]
     *
     * Input B:
     * A = [2, 1, 8, 3, 9, 6]
     * B = [   [0, 3]
     *         [3, 5]
     *         [1, 3]
     *         [2, 4]   ]
     *
     * Output A:
     * [1, 1, 2]
     *
     * Output B:
     * [2, 1, 1, 1]
     */

    public static int[] solve(int[] A, int[][] B) {
        int[] prefEvenCount = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                count++;
            }
            prefEvenCount[i] = count;
        }

        int[] resultArr = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0], end = B[i][1];

            if (start == 0) {
                resultArr[i] = prefEvenCount[end];
            } else {
                resultArr[i] = prefEvenCount[end] - prefEvenCount[start - 1];
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 4, 5};
        int[][] queryA = {   {0, 2},
                {2, 4},
                {1, 4} };
        int[] expectedOutputA = {1, 1, 2};
        int[] actualOutputA = solve(arrA, queryA);
        assert Arrays.equals(expectedOutputA, actualOutputA);

        int[] arrB = {2, 1, 8, 3, 9, 6};
        int[][] queryB = {   {0, 3},
                {3, 5},
                {1, 3},
                {2, 4} };
        int[] expectedOutputB = {2, 1, 1, 1};
        int[] actualOutputB = solve(arrB, queryB);
        assert Arrays.equals(expectedOutputB, actualOutputB);
    }
}
