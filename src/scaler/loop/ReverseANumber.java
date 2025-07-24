package scaler.loop;

public class ReverseANumber {

    public static void main(String[] args) {
        assert 123 == reverse(321);
        assert 21 == reverse(120);
        assert 0 == reverse(0);
    }

    public static int reverse(int A) {
        StringBuilder stringBuilder = new StringBuilder();
        if (A == 0) {
            return 0;
        }

        while (A > 0) {
            stringBuilder.append(A % 10);
            A = A / 10;
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
