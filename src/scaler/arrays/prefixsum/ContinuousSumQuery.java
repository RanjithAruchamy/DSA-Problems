package scaler.arrays.prefixsum;

import java.util.Arrays;

public class ContinuousSumQuery {
    /**
     * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
     *
     * Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
     * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
     *
     * 1 <= A <= 2 * 10^5
     * 1 <= L <= R <= A
     * 1 <= P <= 10^3
     * 0 <= len(B) <= 10^5
     *
     * InputA:
     * A = 5
     * B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     *
     * OutputA:
     * [10 55 45 25 25]
     */

    public static int[] solvePrefSum(int A, int[][] B) {
        int[] ansArr = new int[A];
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0], right = B[i][1], value = B[i][2];
            ansArr[start - 1] += value;
            if (right < A) {
                ansArr[right] += -value;
            }
        }

        for (int i = 1; i < ansArr.length; i++) {
            ansArr[i] += ansArr[i-1];
        }
        return ansArr;
    }

    public static int[] solveBf(int A, int[][] B) {
        int[] ansArr = new int[A];
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0], right = B[i][1], value = B[i][2];
            for (int j = start - 1; j < right; j++) {
                ansArr[j] += value;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int inputA = 5;
        int[][] queryA = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] expectedOutputA = {10 ,55, 45, 25, 25};
        int[] actualOutputA = solvePrefSum(inputA, queryA);

        assert Arrays.equals(expectedOutputA, actualOutputA);
    }
}
