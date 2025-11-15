package scaler.queue;

import java.util.ArrayDeque;

public class ParkingIceCreamTruck {

    /**
     *Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.
     *
     * For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.
     *
     * You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.
     *
     * For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.
     *
     * NOTE: If B > length of the array, return 1 element with the max of the array.
     *
     * Input 1:
     *  A = [1, 3, -1, -3, 5, 3, 6, 7]
     *  B = 3
     *
     *  Input 2:
     *  A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
     *  B = 6
     *
     *  Output 1:
     *  [3, 3, 5, 5, 6, 7]
     *
     *  Output 2:
     *  [7, 7, 7, 7]
     */

    public static int[] slidingMaximum(final int[] A, int B) {
        // BF: Find all subarrays of length B & find the max element in all the sub arrays
        /*int n = A.length;
        int[] resArr = new int[n - B + 1];
        for (int i = 0; i <= n - B; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + B ; j++) {
                max = Math.max(max, A[j]);
            }
            resArr[i] = max;
        }
        return resArr;*/

        // Optimized
        int n = A.length;
        int[] resArr = new int[n - B + 1];

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.removeLast();
            }
            deque.addLast(A[i]);
        }
        resArr[0] = deque.peekFirst();

        for (int i = 1; i <= n-B; i++) {
            if (deque.peekFirst() == A[i - 1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < A[i + B - 1]) {
                deque.removeLast();
            }
            deque.addLast(A[i + B - 1]);
            resArr[i] = deque.peekFirst();
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = slidingMaximum(input, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
