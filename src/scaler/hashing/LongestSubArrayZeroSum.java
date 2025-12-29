package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayZeroSum {

    /**
     * Given an array A of N integers.
     * Find the length of the longest subarray in the array which sums to zero.
     *
     * If there is no subarray which sums to zero then return 0.
     *
     * Input 1:
     *  A = [1, -2, 1, 2]
     * Input 2:
     *  A = [3, 2, -1]
     *
     *  Output 1:
     * 3
     * Output 2:
     * 0
     */
    public static int solve(int[] A) {
        if (A == null || A.length == 0) return 0;

        int ans = 0;
        long sum = 0;
        Map<Long, Integer> sumOfIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == 0) {
                ans = i + 1;
                continue;
            }

            if (sumOfIndex.containsKey(sum)) {
                int index = sumOfIndex.get(sum);
                ans = Math.max(ans, (i - index));
            } else {
                sumOfIndex.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        solve(new int[]{9,-20,-11,-8,-4,2,-12,14,1});
    }
}
