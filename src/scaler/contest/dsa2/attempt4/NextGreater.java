package scaler.contest.dsa2.attempt4;

import java.util.Stack;

public class NextGreater {

    /**
     * Given an array A, find the next greater element G[i] for every element A[i] in the array.
     * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
     *
     *  More formally:
     *
     * G[i] for an element A[i] = an element A[j] such that
     *     j is minimum possible AND
     *     j > i AND
     *     A[j] > A[i]
     * Elements for which no greater element exists, consider the next greater element as -1.
     *
     * Input 1:
     *  A = [4, 5, 2, 10]
     * Input 2:
     *  A = [3, 2, 1]
     *
     *  Output 1:
     *  [5, 10, 10, -1]
     * Output 2:
     *  [-1, -1, -1]
     */

    public int[] nextGreater(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(A[i]);
        }
        return res;
    }
}
