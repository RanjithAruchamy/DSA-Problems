package scaler.function;

public class AreaOfCircle {

    public static void main(String[] args) {
        assert 201.06 == solve(8);
        assert 706.86 == solve(15);
    }

    public static double solve(int A) {
        return Math.round(Math.PI * (A * A) * 100.0) / 100.0;
    }
}
