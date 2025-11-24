package scaler.binarysearch;

public class MedianOfTwoSortedArrays {

    /**
     *  Given two sorted arrays A and B of size M and N respectively, return the median of the two sorted arrays.
     * Round of the value to the floor integer [2.6=2, 2.2=2]
     *
     * Input 1:
     * A = [5, 7]
     * B = [6]
     *
     * Input 2:
     * A = [1, 2]
     * B = [3, 4]
     *
     * Output 1:
     * 6
     *
     * Output 2:
     * 2
     */

    public int solve(int[] A, int[] B) {
        if (B.length < A.length) return solve(B, A);    // Make sure to return the recursive call

        int m = A.length, n = B.length;

        int low = 0, high = m;
        while (low <= high) {
            int cut1 = (low + high) / 2;    // The mid value should be sum of 2 arrays size / 2
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : B[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : A[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : B[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    long sum = Math.max(l1, l2) + Math.min(r1, r2);
                    return (int) Math.floorDiv(sum, 2);
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;    // When the l1 is greater than r2 then we will try to reduce the number of elements from L1 array so will reduce the high value.
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }

}
