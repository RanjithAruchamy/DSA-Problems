package scaler.arrays.slidingwindow;

public class SubarrayWithGivenSumAndLength {

    /**
     * Given an array A of length N. Also given are integers B and C.
     * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
     *
     * 1 <= N <= 10^5
     * 1 <= A[i] <= 10^4
     * 1 <= B <= N
     * 1 <= C <= 10^9
     *
     * InputA:
     * A = [4, 3, 2, 6, 1]
     * B = 3
     * C = 11
     *
     * InputB:
     * A = [4, 2, 2, 5, 1]
     * B = 4
     * C = 6
     *
     * OutputA: 1
     *
     * OutputB: 0
     */

    public static int solve(int[] A, int B, int C) {
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        if (sum == C) {
            return 1;
        }

        for (int i = 1; i <= A.length - B; i++) {
            int subArraySum = sum - A[i - 1] + A[B + i - 1];
            if (subArraySum == C) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arrA = {4, 3, 2, 6, 1};
        int B1 = 3;
        int C1 = 11;
        assert 1 == solve(arrA, B1, C1);

        int[] arrB = {4, 2, 2, 5, 1};
        int B2 = 4;
        int C2 = 6;
        assert 0 == solve(arrB, B2, C2);
    }
}
