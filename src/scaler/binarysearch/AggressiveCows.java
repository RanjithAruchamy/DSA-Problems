package scaler.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    /**
     * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N
     * where each element of the array represents the location of the stall and an integer B which represents the number of cows.
     * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
     * To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
     * such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
     */

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int size = A.length;
        int low = 1, high = A[size - 1] - A[0];

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checkIfAllCowsCanBePlaced(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean checkIfAllCowsCanBePlaced(int[] arr, int numberOfCows, int maxDistance) {
        int cowsPlaced = 1;
        int lastPlacedPosition = arr[0];
        for (Integer num : arr) {
            if (num >= lastPlacedPosition + maxDistance) {
                cowsPlaced++;
                lastPlacedPosition = num;
            }
            if (cowsPlaced == numberOfCows) return true;
        }
        return false;
    }
}
