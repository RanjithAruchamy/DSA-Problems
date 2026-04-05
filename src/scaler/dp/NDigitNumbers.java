package scaler.dp;

import java.util.Arrays;

public class NDigitNumbers {

    public static int solveTabulation(int A, int B) {
        int[][] dp = new int[A + 1][B + 1];

        for (int digit = 1; digit <= A; digit++) {
            for (int sum = 1; sum <= B; sum++) {
                if (digit == 1 && sum <= 9) dp[digit][sum] = 1;
                else if (digit == 1 && sum > 9) dp[digit][sum] = 0;
                else {
                    for (int i = 0; i <= Math.min(sum, 9); i++) {
                        dp[digit][sum] += dp[digit - 1][sum - i];
                        dp[digit][sum] %= 1000000007;
                    }
                }
            }
        }
        return dp[A][B];
    }

    public static int solve(int A, int B) {
        int[][] dp = new int[A+1][B+1];
        for (int i = 0; i < A + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return nDigit(A, B, true, dp);
    }

    private static int nDigit(int node, int sum, boolean isFirstDig, int[][] dp) {
        if (node == 0 && sum == 0) return dp[node][sum] = 1;
        if (node == 0 && sum > 0) return dp[node][sum] = 0;
        if (dp[node][sum] != -1) return dp[node][sum];
        int ways = 0;
        int st = isFirstDig ? 1 : 0;
        for (int d = st; d <= Math.min(sum, 9); d++) {
            ways += nDigit(node - 1, sum - d, false, dp);
            ways = ways % 1000000007;
        }
        return dp[node][sum] = ways;
    }

    public static void main(String[] args) {
        assert 10 == solveTabulation(3, 4);
        assert 4 == solveTabulation(2, 4);
        assert 1 == solveTabulation(1, 3);
    }
}
