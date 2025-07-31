package scaler.function;

public class FindTheCeil {

    public static void main(String[] args) {
        assert 11 == solve(2113);
        assert -10 == solve(-2113 );
    }

    public static int solve(int A) {
        return (int) Math.ceil( (double)A/200);
    }
}
