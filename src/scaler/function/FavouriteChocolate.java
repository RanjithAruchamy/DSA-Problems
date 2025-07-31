package scaler.function;

public class FavouriteChocolate {

    public static void main(String[] args) {
        assert 3 == solve(10, 3, 4);
        assert 2 == solve(10, 2, 2);
    }

    public static int solve(int A, int B, int C) {
        int numberOfChocolatesForBudget = A / B;

        return Math.min(numberOfChocolatesForBudget, C);
    }

}
