package scaler.arrays;

public class IsXPresent {

    public static void main(String[] args) {
        assert 1 == solve(new int[]{4, 1, 5, 9, 1}, 5);
    }

    public static int solve(int[] A, int B) {

        for (int j = 0; j < A.length; j++) {
            if (B == A[j]) {
                return 1;
            }
        }
        return 0;
    }
}
