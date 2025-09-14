package scaler.arrays.prefixsum;

import java.util.Arrays;

public class RangeSumQuery {

    /**
    * You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
     * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
     *
     *
     * 1 <= N, M <= 105
     * 1 <= A[i] <= 109
     * 0 <= L <= R < N
     *
     *
     * Input A:
     * A = [1, 2, 3, 4, 5]
     * B = [[0, 3], [1, 2]]
     *
     * Output A:
     * [10, 5]
     *
     * Input B:
     * A = [2, 2, 2]
     * B = [[0, 0], [1, 2]]
     *
     * Output B:
     * [2, 4]
     * */

    public static long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int[] prefSum = new int[n];
        prefSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i-1] + A[i];
        }

        long[] resultArr = new long[B.length];
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
        int[] arrA = {1, 2, 3, 4, 5};
        int[][] twoDArrA = {{0,3},{1,2}};
        long[] expectedOutPutArrA = {10, 5};
        long[] outputArrA = rangeSum(arrA, twoDArrA);
        assert Arrays.equals(expectedOutPutArrA, outputArrA);

        int[] arrB = {2, 2, 2};
        int[][] twoDArrB = {{0, 0},{1,2}};
        long[] expectedOutPutArrB = {2, 4};
        long[] outputArrB = rangeSum(arrB, twoDArrB);
        assert Arrays.equals(expectedOutPutArrB, outputArrB);
    }
}
