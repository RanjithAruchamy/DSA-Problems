package scaler.heaps;

import util.Converter;

import java.util.ArrayList;

public class DistributeCandy {

    public static int candy(ArrayList<Integer> A) {
        int candies = 1;

        int[] leftSum = new int[A.size()];
        leftSum[0] = candies;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies++;
            } else {
                candies = 1;

            }
            leftSum[i] = candies;
        }

        candies = 1;
        int[] rightSum = new int[A.size()];
        rightSum[A.size() - 1] = candies;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies++;
            } else {
                candies = 1;

            }
            rightSum[i] = candies;
        }

        int totalCandies = 0;
        for (int i = 0; i < A.size(); i++) {
            totalCandies += Math.max(leftSum[i], rightSum[i]);
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        assert 3 == candy(Converter.convertToArrayList(new int[]{1,2}));
        assert 7 == candy(Converter.convertToArrayList(new int[]{1, 5, 2, 1}));
    }
}
