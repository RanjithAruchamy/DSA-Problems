package scaler.arrays.prefixsum;

public class SpecialIndex {

    /**
     * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element
     * from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     *
     * 1 <= N <= 105
     * -105 <= A[i] <= 105
     * Sum of all elements of A <= 109
     *
     * InputA:
     * A = [2, 1, 6, 4]
     *
     * InputB:
     * A = [1, 1, 1]
     *
     * OutputA: 1
     *
     * OutputB: 3
     */

    public static int solve(int[] A) {
        int n = A.length;

        //Even Sum
        int[] prefEvenSum = new int[n];
        prefEvenSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                prefEvenSum[i] = A[i] + prefEvenSum[i-1];
            } else {
                prefEvenSum[i] = prefEvenSum[i - 1];
            }
        }

        //Odd Sum
        int[] prefOddSum = new int[n];
        prefOddSum[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                prefOddSum[i] = prefOddSum[i - 1];
            } else {
                prefOddSum[i] = A[i] + prefOddSum[i-1];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sumOfEvenNumbers = 0, sumOfOddNumbers = 0;

            if (i == 0) {
                sumOfOddNumbers = prefEvenSum[n - 1] - prefEvenSum[i];
                sumOfEvenNumbers = prefOddSum[n - 1] - prefOddSum[i];
            } else {
                sumOfOddNumbers = prefOddSum[i - 1] + (prefEvenSum[n - 1] - prefEvenSum[i]);
                sumOfEvenNumbers = prefEvenSum[i - 1] + (prefOddSum[n - 1] - prefOddSum[i]);
            }

            if (sumOfEvenNumbers == sumOfOddNumbers) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int [] inputA = {2, 1, 6, 4};
        assert 1 == solve(inputA);

        int [] inputB = {1, 1, 1};
        assert 3 == solve(inputB);
    }
}
