package scaler.dp;

import java.util.Arrays;

public class UniquePathsInGrid {

    public static int uniquePathsWithObstacles(int[][] A) {
        if (A[0][0] == 1) return 0;

        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return ways(A, 0, 0, dp);
    }

    private static int ways(int[][] A, int x, int y, int[][] dp) {
        int m = A.length, n = A[0].length;

        if (x >= m || y >= n || A[x][y] == 1) return 0;

        if (x == m - 1 && y == n - 1) return dp[x][y] = 1;

        if (dp[x][y] != -1) return dp[x][y];

        int down = ways(A, x + 1, y, dp);
        int right = ways(A, x, y + 1, dp);

        return dp[x][y] = down + right;
    }

    public static void main(String[] args) {
        assert 2 == uniquePathsWithObstacles(new int[][] { {0,0,0}, {0,1,0}, {0,0,0} });
        assert 0 == uniquePathsWithObstacles(new int[][] { {0,0,0}, {1,1,1}, {0,0,0} });
        assert 0 == uniquePathsWithObstacles(new int[][] { {1,0} });
    }
}
