package scaler.heaps;

import java.util.PriorityQueue;

public class ConnectRopes {

    /**
     * You are given an array A of integers that represent the lengths of ropes.
     * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
     * Find and return the minimum cost to connect these ropes into one rope.
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5]
     * Input 2:
     *  A = [5, 17, 100, 11]
     *
     *  Output 1:
     *  33
     * Output 2:
     *  182
     */

    public static int solve(int[] A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            queue.add(A[i]);
        }

        int cost = 0;
        while (queue.size() > 1) {
            int first = queue.remove();
            int second = queue.remove();
            int sum = first + second;
            cost += sum;

            queue.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        assert 33 == solve(new int[]{1, 2, 3, 4, 5});
        assert 182 == solve(new int[]{5, 17, 100, 11});
    }
}
