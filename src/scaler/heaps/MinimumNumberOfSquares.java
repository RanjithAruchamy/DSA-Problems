package scaler.heaps;

import java.util.Arrays;

public class MinimumNumberOfSquares {

    public static int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return minSquare(A, dp);
    }

    private static int minSquare(int A, int[] dp) {
        if (A == 0) return dp[A] = 0;

        if (dp[A] != -1) return dp[A];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= A; i++) {
            ans = Math.min(ans, minSquare(A - i * i, dp));
        }
        return dp[A] = ans + 1;
    }

    public static void main(String[] args) {
        assert 3 == countMinSquares(6);
        assert 2 == countMinSquares(5);
    }
}
