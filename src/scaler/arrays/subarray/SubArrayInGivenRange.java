package scaler.arrays.subarray;

import java.util.Arrays;

public class SubArrayInGivenRange {
    /**
     * Given an array A of length N, return the subarray from B to C.
     *
     * Constraint:
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= 109
     *
     * 0 <= B <= C < N
     *
     * InputA:
     * A = [4, 3, 2, 6]
     * B = 1
     * C = 3
     *
     * InputB:
     * A = [4, 2, 2]
     * B = 0
     * C = 1
     *
     * OutputA:
     * [3, 2, 6]
     *
     * OutputB:
     * [4, 2]
     */

    public static int[] solve(int[] A, int B, int C) {
        int index = 0;
        int[] resultArr = new int[C-B+1];
        for (int i = B; i <= C; i++) {
            resultArr[index++] = A[i];
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arrA = {4, 3, 2, 6};
        int B1 = 1, C1 = 3;
        int[] expectedOutputA = {3, 2, 6};
        int[] actualOutputA = solve(arrA, B1, C1);
        assert Arrays.equals(expectedOutputA, actualOutputA);

        int[] arrB = {4, 2, 2};
        int B2 = 0, C2 = 1;
        int[] expectedOutputB = {4, 2};
        int[] actualOutputB = solve(arrB, B2, C2);
        assert Arrays.equals(expectedOutputB, actualOutputB);
    }
}
