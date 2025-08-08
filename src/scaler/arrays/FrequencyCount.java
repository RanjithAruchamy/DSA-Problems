package scaler.arrays;

import java.util.Arrays;

public class FrequencyCount {

    public static void main(String[] args) {
        int[] expectedOutput = new int[]{3, 1, 2, 3, 2, 3};
        int[] output = solve(new int[] {1, 2, 5, 1, 5, 1});
        assert Arrays.equals(expectedOutput, output);
    }

    public static int[] solve(int[] A) {
        int[] arr = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]) {
                    sum++;
                }
            }
            arr[i] = sum;
        }
        return arr;
    }
}
