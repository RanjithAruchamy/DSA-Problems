package scaler.arrays;

public class FrequencyOfXInArray {
    public static void main(String[] args) {
        assert 2 == solve(new int[]{1, 1, 2, 4, 2}, 2);
    }

    public static int solve(int[] A, int B) {
        int sum = 0;
        for (int j = 0; j < A.length; j++) {
            if (B == A[j]) {
                sum++;
            }
        }
        return sum;
    }
}
