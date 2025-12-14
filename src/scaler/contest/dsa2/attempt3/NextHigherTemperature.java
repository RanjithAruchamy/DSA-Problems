package scaler.contest.dsa2.attempt3;

import java.util.Arrays;
import java.util.Stack;

public class NextHigherTemperature {

    /**
     * You are given an array A of daily temperatures of N days, where A[i] represents the temperature on the i-th day.
     * Your task is to find the minimum number of days you have to wait after each day until you can see a warmer day and return the difference of temperatures for each day.
     * If there is no future day for which this is possible, put -1 instead.
     *
     * Input 1:
     * A = [73, 75, 76, 71, 77]
     *
     *  Input 2:
     * A = [30, 40, 35, 45]
     *
     * Output 1:
     * [2, 1, 1, 6, -1]
     *
     * Output 2:
     * [10, 5, 10, -1]
     */

    public static int[] solve(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek() - A[i];
            }
            stack.push(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{73, 75, 76, 71, 77})));
        System.out.println(Arrays.toString(solve(new int[]{30, 40, 35, 45})));
    }

}
