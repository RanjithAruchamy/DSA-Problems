package scaler.dp;

public class UniqueBSTII {

    public static int numTrees(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;
        if (A == 0 || A == 1) return dp[A];

        for (int i = 2; i <= A; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {
        assert 1 == numTrees(1);
        assert 2 == numTrees(2);
        assert 5 == numTrees(3);
        assert 42 == numTrees(5);
    }
}
