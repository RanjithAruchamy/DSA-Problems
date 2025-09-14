package scaler.arrays.contribution;

public class SumOfAllSubArrays {

    /**
     * You are given an integer array A of length N.
     * You have to find the sum of all subarray sums of A.
     * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
     * A subarray sum denotes the sum of all the elements of that subarray.
     *
     * Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.
     *
     * 1 <= N <= 10^5
     * 1 <= Ai <= 10^4
     *
     * InputA:
     * A = [1, 2, 3]
     *
     * InputB:
     * A = [2, 1, 3]
     *
     * OutputA: 20
     *
     * OutputB: 19
     */

    public static long subarraySum(int[] A) {
        long totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            long times = (long) (i+1) * (A.length - i);
            totalSum += A[i] * times;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] inputA = {1, 2, 3};
        assert 20 == subarraySum(inputA);

        int[] inputB = {2, 1, 3};
        assert 19 == subarraySum(inputB);
    }
}
