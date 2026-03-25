package leetcode.medium;

import java.util.Arrays;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return paths(0, 0, m, n, dp);
    }

    private static int paths(int x, int y, int m, int n, int[][] dp) {
        if (x == m - 1 && y == n - 1) return 1;

        if (x >= m || y >= n) return 0;

        if (dp[x][y] != -1) return dp[x][y];

        int down = paths(x + 1, y, m, n, dp);
        int right = paths(x, y + 1, m, n, dp);

        return dp[x][y] = down + right;
    }

    public static void main(String[] args) {
        assert 28 == uniquePaths(3, 7);
    }
}
