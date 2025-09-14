package scaler.arrays.carryforward;

public class ClosestMinMax {

    /**
     * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
     * and at least one occurrence of the minimum value of the array.
     *
     * 1 <= |A| <= 2000
     *
     * InputA:
     * A = [1, 3, 2]
     *
     * InputB:
     * A = [2, 6, 1, 6, 9]
     *
     * OutputA: 2
     *
     * OutputB: 3
     *
     */
    public static int solve(int[] A) {
        // Find min & max values from the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        // Find closest min & closest max
        int closestMin = -1;
        int closestMax = -1;
        int ans = A.length;
        for (int i = 0; i <A.length; i++) {
            if (A[i] == min) {
                closestMin = i;
                if (closestMax != -1) {
                    ans = Math.min(ans, closestMin - closestMax + 1 );
                }
            }

            if (A[i] == max) {
                closestMax = i;
                if (closestMin != -1) {
                    ans = Math.min(ans, closestMax - closestMin + 1 );
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputA = {1, 3, 2};
        assert 2 == solve(inputA);

        int[] inputB = {2, 6, 1, 6, 9};
        assert 3 == solve(inputB);
    }
}
