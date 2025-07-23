package scaler.ifelse;

public class FindSecondLastNumber {
    public static void main(String[] args) {
        assert 4 == secondLastNumber(1249);
        assert 0 == secondLastNumber(900);
        assert 0 == secondLastNumber(0);
        assert 1 == secondLastNumber(18);
        assert 8 == secondLastNumber(8);
    }

    private static int secondLastNumber(int n) {
        if (n > 9) {
            return n % 100/10;
        } else {
            return n % 100 % 10;
        }
    }
}
