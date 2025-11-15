package scaler.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinAndMax {

    /**
     * Given an array A of both positive and negative integers.
     * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
     * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
     *
     * Input 1:
     *  A = [2, 5, -1, 7, -3, -1, -2]
     *  B = 4
     *
     *  Input 2:
     *  A = [2, -1, 3]
     *  B = 2
     *
     *  Output 1:
     *  18
     *
     *  Output 2:
     *  3
     */

    public static int solve(int[] A, int B) {
        long sum = 0;
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = A.length;
        int mod = 1000 * 1000 * 1000 + 7;

        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        // First window
        for (int i = 0; i < B; i++) {
            while (!minQueue.isEmpty() && A[i] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(A[i]);

            while (!maxQueue.isEmpty() && A[i] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(A[i]);
        }
        if (!minQueue.isEmpty()) min = minQueue.peekFirst() + mod;
        if (!maxQueue.isEmpty()) max = maxQueue.peekFirst() + mod;
        sum = (min + max) % mod;

        for (int i = 1; i <= n - B; i++) {
            while (!minQueue.isEmpty() && A[i + B - 1] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(A[i + B - 1]);
            if (A[i - 1] == minQueue.peekFirst()) minQueue.removeFirst();
            if (!minQueue.isEmpty()) min = minQueue.peekFirst() + mod;

            while (!maxQueue.isEmpty() && A[i + B - 1] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(A[i + B - 1]);
            if (A[i - 1] == maxQueue.peekFirst()) maxQueue.removeFirst();
            if (!maxQueue.isEmpty()) max = maxQueue.peekFirst() + mod;

            sum = (sum + ((min + max) % mod)) % mod;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        assert 18 == solve(new int[]{2, 5, -1, 7, -3, -1, -2}, 4);
        assert 3 == solve(new int[]{2, -1, 3}, 2);
    }

}
