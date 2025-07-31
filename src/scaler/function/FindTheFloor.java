package scaler.function;

public class FindTheFloor {
    public static void main(String[] args) {
        assert 10 == solve(2113);
        assert -11 == solve(-2113);
        assert -2 == solve(-400);
    }

    public static int solve(int A) {
        return (int) Math.floor( (double)A/200);
    }
}
