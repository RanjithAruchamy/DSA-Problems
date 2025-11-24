package scaler.binarysearch;

public class PaintersPartitionProblem {

    /**
     * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
     * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
     *
     * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
     * NOTE:
     * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
     * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
     *
     * Return the ans % 10000003.
     *
     * Input 1:
     *  A = 2
     *  B = 5
     *  C = [1, 10]
     *
     *  Input 2:
     *  A = 10
     *  B = 1
     *  C = [1, 8, 11, 3]
     *
     *  Output 1:
     *  50
     *
     *  Output 2:
     *  11
     */


    public int paint(int A, int B, int[] C) {
        long[] maxAndSumArr = findMaxAndSum(C);
        long low =  maxAndSumArr[0] * B, high = maxAndSumArr[1] * B;

        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            int minPainters = minPainters(C, B, mid);

            if (minPainters <= A) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) (ans % 10000003);      // Make sure the ans % 10000003 is enclosed within bracket for type casting
    }

    private static int minPainters(int[] arr, int timePerBoard, long minTime) {
        int painter = 1;
        long timeLeft = minTime;
        for (Integer board : arr) {
            long timeToPaintBoard = (long) board * timePerBoard;

            if (timeToPaintBoard > minTime) return -1;

            if (timeLeft >= timeToPaintBoard) {
                timeLeft = timeLeft - timeToPaintBoard;
            } else {
                painter++;
                timeLeft = minTime - timeToPaintBoard;
            }
        }
        return painter;
    }

    private static long[] findMaxAndSum(int[] arr) {
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (Integer num : arr) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        return new long[]{max, sum};
    }

}
