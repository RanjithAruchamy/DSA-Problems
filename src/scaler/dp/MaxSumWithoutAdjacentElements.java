package scaler.dp;

public class MaxSumWithoutAdjacentElements {

    public static int adjacent(int[][] A) {
        int length = A[0].length;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Math.max(A[0][i], A[1][i]);
        }

        if (length == 1) return arr[0];

        int[] dp = new int[length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        assert 2 == adjacent(new int[][]{ {1}, {2} });
        assert 8 == adjacent(new int[][]{ {1, 2, 3, 4}, {2, 3, 4, 5} });
    }
}
