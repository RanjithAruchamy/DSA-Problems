package scaler.queue;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class NIntegersContainingOnlyOneTwoAndThree {

    /**
     *Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
     * NOTE: All the A integers will fit in 32-bit integers.
     *
     * Input 1:
     *  A = 3
     *
     *  Input 2:
     *  A = 7
     *
     * Output 1:
     *  [1, 2, 3]
     *
     *  Output 2:
     *  [1, 2, 3, 11, 12, 13, 21]
     */

    public static int[] solve(int A) {
        int[] ans = new int[A];
        Queue<Integer> queue = new PriorityQueue<>();

        int count = 0, index = 0;
        int initialValue = Math.min(3, A);
        for (int i = 1; i <= initialValue; i++) {
            queue.add(i);
            count++;
        }

        while (count < A) {
            int num = 1;
            while (count < A && num <= 3) {
                queue.add((queue.peek() * 10) + num);
                count++;
                num++;
            }
            ans[index++] = queue.remove();
        }

        while (!queue.isEmpty()) {
            ans[index++] = queue.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] result = solve(50);
        for (Integer num : result) {
            System.out.print(num + ",");
        }
    }
}
