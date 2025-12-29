package scaler.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Given an unsorted integer array A of size N.
     * Find the length of the longest set of consecutive elements from array A.
     *
     * Input 1:
     * A = [100, 4, 200, 1, 3, 2]
     * Input 2:
     * A = [2, 1]
     *
     * Output 1:
     *  4
     * Output 2:
     *  2
     */

    public static int longestConsecutive(final int[] A) {

        Set<Integer> set = new HashSet<>();
        for (Integer num : A) {
            set.add(num);
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            if (set.contains(curr - 1)) {
                continue;
            } else {
                int next = curr;
                while (set.contains(next)) {
                    next = next + 1;
                }

                ans = Math.max(ans, (next - curr));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}
