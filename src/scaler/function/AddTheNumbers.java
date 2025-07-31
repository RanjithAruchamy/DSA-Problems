package scaler.function;

public class AddTheNumbers {

    public static void main(String[] args) {
        assert 10 == solve(5, 5);
        assert 20 == solve(5, 15);
    }

    public static int solve(int A, int B) {
        return A + B;
    }
}
