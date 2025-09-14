package scaler.arrays.prefixsum;

public class EquilibriumIndexOfArray {

    /**
     * You are given an array A of integers of size N.
     *
     * Your task is to find the equilibrium index of the given array
     *
     * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     *
     * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
     *
     * Note:
     *
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     *
     * Constraints:
     * 1 <= N <= 105
     * -105 <= A[i] <= 105
     *
     * InputA:
     * A = [-7, 1, 5, 2, -4, 3, 0]
     *
     * InputB:
     * A = [1, 2, 3]
     *
     * OutputA:
     * 3
     *
     * OutputB:
     * -1
     */

    public static int solve(int[] A) {
        long totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }

        long totalSum2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            totalSum -= A[i];

            if (totalSum == totalSum2) {
                ans = i;
                break;
            }

            totalSum2 += A[i];
        }

        if (ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    public static int solveBF(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int sumOfLeft = 0, sumOfRight = 0;

            for (int j = 0; j < i; j++) {
                sumOfLeft += A[j];
            }

            for (int j = i+1; j < A.length; j++) {
                sumOfRight += A[j];
            }

            if (sumOfLeft == sumOfRight)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inputA = {-7, 1, 5, 2, -4, 3, 0};
        assert 3 == solve(inputA);

        int[] inputB = {1, 2, 3};
        assert -1 == solve(inputB);
    }
}
