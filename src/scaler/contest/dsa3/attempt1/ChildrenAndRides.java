package scaler.contest.dsa3.attempt1;

import java.util.Arrays;

public class ChildrenAndRides {

    /**
     * In an amusement park, there are rides being constructed for N children. Each ride has a maximum capacity limit of B for the total weight of the children on board.
     * You are given an array of weights of children, where A[i] is the weight of the ith child and an infinite number of rides. Each ride can carry atmost 2 children
     * at the same time, provided the sum of their weights is at most the ride's capacity limit.
     * Find the minimum number of rides to accommodate all the children.
     *
     * Input1:
     * A = [1,2,3] B = 4
     *
     * Input2:
     * A = [3,2,2,0,1] B = 4
     *
     * Output1: 2
     * Output2: 3
     */

    public static int solve(int[] A, int B) {
        Arrays.sort(A);

        int start = 0, end = A.length - 1;
        int ride = 0;
        while (start <= end) {
            long sum = A[start] + A[end];
            if (sum <= B) {
                start++;
                end--;
            } else  {
                end--;
            }
            ride++;
        }
        return ride;
    }

    public static void main(String[] args) {

    }
}
