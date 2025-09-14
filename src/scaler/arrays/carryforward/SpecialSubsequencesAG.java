package scaler.arrays.carryforward;

public class SpecialSubsequencesAG {

    /**
     * You have given a string A having Uppercase English letters.
     *
     * You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
     *
     * 1 <= length(A) <= 105
     *
     * InputA:
     *  A = "ABCGAG"
     *
     * InputB:
     *  A = "GAB"
     *
     * OutputA:
     * 3
     *
     * OutputB:
     * 0
     */

    public static long solve(String A) {
        int countOfA = 0;
        long ans = 0L;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') {
                countOfA++;
            } else if (A.charAt(i) == 'G') {
                ans += countOfA;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String inputA = "ABCGAG";
        assert 3L == solve(inputA);

        String inputB = "GAB";
        assert 0L == solve(inputB);
    }
}
