package scaler.arrays.prefixsum;

import java.util.Arrays;

public class SumOfEvenIndexedElementsInRange {

    /**
     * You are given:
     * An integer array A representing the array of numbers of size N.
     * A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1], representing the range [L, R].
     *
     * For each query in B, calculate the sum of elements in A at EVEN indices within the specified range [L, R] and return the results as an array.
     *
     * Constraint:
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
     * A = [5, 15, 25, 35, 45]
     * B = [ [1, 1],
     *       [0, 0] ]
     *
     * OutputA:
     * [18, 5, 3]
     *
     * OutputB:
     * [0, 5]
     */

    public static int[] sumOfEvenIndexedElements(int[] A, int[][] B) {
        int n = A.length;
        int[] prefSum = new int[n];
        prefSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                prefSum[i] = prefSum[i-1] + A[i];
            } else {
                prefSum[i] = prefSum[i-1];
            }
        }

        int[] resultArr = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int left = B[i][0], right = B[i][1];
            if (left == 0) {
                resultArr[i] = prefSum[right];
            } else {
                resultArr[i] = prefSum[right] - prefSum[left - 1];
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arrA = {2, 8, 3, 9, 15};
        int[][] twoDArrA = { {1, 4}, {0, 2}, {2, 3} };
        int[] expectedOutPutArrA = {18, 5, 3};
        int[] outputArrA = sumOfEvenIndexedElements(arrA, twoDArrA);
        assert Arrays.equals(expectedOutPutArrA, outputArrA);

        int[] arrB = {5, 15, 25, 35, 45};
        int[][] twoDArrB = { {1, 1}, {0, 0} };
        int[] expectedOutPutArrB = {0, 5};
        int[] outputArrB = sumOfEvenIndexedElements(arrB, twoDArrB);
        assert Arrays.equals(expectedOutPutArrB, outputArrB);
    }
}
