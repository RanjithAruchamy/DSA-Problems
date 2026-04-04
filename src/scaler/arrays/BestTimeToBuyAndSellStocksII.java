package scaler.arrays;

public class BestTimeToBuyAndSellStocksII {

    public static int maxProfit(final int[] A) {
        int profit = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                profit += A[i + 1] - A[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        assert 2 == maxProfit(new int[] {1, 2, 3});
        assert 8 == maxProfit(new int[] {5, 2, 10});
    }
}
