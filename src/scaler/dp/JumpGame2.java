package scaler.dp;

public class JumpGame2 {

    public static int solve(int[] A) {

        int[] dp = new int[A.length];

        int val = minJump(A, 0, dp);
        return val == Integer.MAX_VALUE ? - 1 : val;
    }

    private static int minJump(int[] A, int idx, int[] dp) {
        if (idx == A.length - 1) return dp[idx] = 0;

        if (dp[idx] != 0) return dp[idx];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= A[idx] && i + idx <= A.length - 1 ; i++) {
            int val = minJump(A, i + idx, dp);
            min = Math.min(val, min);
        }

        if (min == Integer.MAX_VALUE)
            return dp[idx] = Integer.MAX_VALUE;
        else
            return dp[idx] = min + 1;
    }

    public static void main(String[] args) {
//        assert 2 == solve(new int[] {2, 3, 1, 1, 4});
//        assert -1 == solve(new int[] {0, 1, 1, 4});
        assert 2 == solve(new int[] {2, 3, 0, 1, 4});
    }
}
