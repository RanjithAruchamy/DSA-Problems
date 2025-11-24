package scaler.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class AddOrNot {

    /**
     * Given an array of integers A of size N and an integer B.
     *
     * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
     *
     * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
     * If there are several such numbers, your task is to find the minimum one.
     *
     * Input 1:
     *  A = [3, 1, 2, 2, 1]
     *  B = 3
     *
     *  Input 2:
     *  A = [5, 5, 5]
     *  B = 3
     *
     *  Output 1:
     *  [4, 2]
     *
     *  Output 2:
     *  [3, 5]
     */

    public static int[] solveBinarySearch(int[] A, int B) {
        int[] res = {-1, -1};
        Arrays.sort(A);

        long[] prefSum = new long[A.length + 1];
        prefSum[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            prefSum[i] = prefSum[i-1] + A[i-1];
        }

        for (int i = 0; i < A.length; i++) {
            int low = 1, high = i + 1, max = 0;

            while(low <= high) {
                int count = (high + low) / 2;
                if (checkIfOperationsLessThanB(count, A, B, i, prefSum)) {
                    max = count;
                    low = count + 1;
                } else {
                    high = count - 1;
                }
            }

            if (max > res[0]) {
                res[0] = max;
                res[1] = A[i];
            }
        }
        return res;
    }

    private static boolean checkIfOperationsLessThanB(int count, int[] arr, int B, int i, long[] prefSum) {
        if ((long) arr[i] * count  - (prefSum[i + 1] - prefSum[i - count + 1]) <= B) {
            return true;
        }
        return false;
    }

    public static int[] solve(int[] A, int B) {
        int[] res = {-1, -1};
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            int count = 0, operations = B;
            for (int j = i; j >= 0; j--) {
                if (A[i] - A[j] <= operations) {
                    count++;
                    operations = operations - (A[i] - A[j]);
                } else break;
            }
            if (count > res[0]) {
                res[0] = count;
                res[1] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] expOutput1 = {4,2};
        int[] input1 = {3, 1, 2, 2, 1};

        assert Arrays.equals(expOutput1, solveBinarySearch(input1, 3));

        int[] expOutput2 = {3,5};
        int[] input2 = {5, 5, 5};
//        assert Arrays.equals(expOutput2, solve(input2, 5));
    }
}
