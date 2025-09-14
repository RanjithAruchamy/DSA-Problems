package scaler.arrays.subarray;

import java.util.Arrays;

public class GenerateAllSubArrays {

    /**
     * You are given an array A of N integers.
     * Return a 2D array consisting of all the subarrays of the array
     *
     * Note : The order of the subarrays in the resulting 2D array does not matter.
     *
     * constraints:
     * 1 <= N <= 100
     * 1 <= A[i] <= 105
     *
     * InputA:
     * A = [1, 2, 3]
     *
     * InputB:
     * A = [5, 2, 1, 4]
     *
     * OutputA:
     * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
     *
     * OutputB:
     * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
     * */

    public static int[][] solve(int[] A) {
        int n = A.length;
        int totalSubArrayCount = n*(n+1)/2;

        int resultIndex = 0;
        int[][] resultSubArrays = new int[totalSubArrayCount][];

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                // Print sub Arrays
                int[] subArray = new int[end-start+1];
                for (int i = start; i <= end; i++) {
                    subArray[i - start]  = A[i];
                }
                resultSubArrays[resultIndex++] = subArray;

            }
        }
        System.out.println(Arrays.deepToString(resultSubArrays));
        return resultSubArrays;
    }

    public static void main(String[] args) {
        int[] arrA = {1,2,3};
        int[][] expectedOutputA = {{1}, {1, 2}, {1, 2, 3}, {2}, {2, 3}, {3}};
        int[][] actualOutputA = solve(arrA);
        assert Arrays.deepEquals(expectedOutputA, actualOutputA);

        int[] arrB = {5, 2, 1, 4};
        int[][] expectedOutputB = {{5}, {5, 2}, {5, 2, 1}, {5, 2, 1, 4}, {2}, {2, 1}, {2, 1, 4}, {1}, {1, 4}, {4}};
        int[][] actualOutputB = solve(arrB);
        assert Arrays.deepEquals(expectedOutputB, actualOutputB);
    }
}
