package scaler.contest.dsa2.attempt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WarmerTemperature {

    /**
     * You are given an array A of daily temperatures of N days, where A[i] represents the temperature on the i-th day.
     * Your task is to find the minimum number of days you have to wait after each day until you can see a warmer day.
     * If there is no future day for which this is possible, put 0 instead.
     *
     * 1 <= N <= 105
     * 30 <= A[i] <= 100
     *
     * Input 1:
     * A = [73, 74, 75, 76, 77, 78, 79, 80]
     *
     *  Input 2:
     * A = [75, 71, 69, 72, 76, 73]
     *
     * Output 1:
     * [1, 1, 1, 1, 1, 1, 1, 0]
     *
     *  Output 2:
     * [4, 2, 1, 1, 0, 0]
     *
     * Explanation 1:
     * For all the elements, the next warmer temperature is the one immediately to their right,
     * except for the last element 80, which has no warmer temperature on the right, so for that day it is 0.
     *
     * Explanation 2:
     *
     * For the given temperatures, the number of days we need to wait to find a warmer temperature are as follows:
     *
     *
     * For the temperature at index 0 (75), we need to wait for 4 days to find a warmer temperature which is 76 at index 4.
     * For the temperature at index 1 (71), we need to wait for 2 days to find a warmer temperature which is 72 at index 3.
     * For the temperature at index 2 (69), we need to wait for 1 day to find a warmer temperature which is 72 at index 3.
     * For the temperature at index 3 (72), we need to wait for 1 day to find a warmer temperature which is 76 at index 4.
     * For the temperature at index 4 (76), there is no warmer temperature to be found, hence we put 0 at index 4.
     * For the temperature at index 5 (73), there is no warmer temperature to be found, hence we put 0 at index 5.
     * Therefore, the resulting array will be [4, 2, 1, 1, 0, 0].
     */

    // Time-Complexity : O(N), Space-Complexity : O(1)
    public static ArrayList<Integer> solveUsingStack(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : A) {
            result.add(0);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)){
                stack.pop();
            }

            if (stack.isEmpty()) result.set(i, 0);
            else result.set(i, stack.peek() - i);
            stack.push(i);
        }
        return result;
    }

    // Time-Complexity : O(N^2), Space-Complexity : O(1)
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : A) {
            result.add(0);
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j) > A.get(i)) {
                    result.set(i, j - i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(75, 71, 69, 72, 76, 73);
        List<Integer> outPut = Arrays.asList(4, 2, 1, 1, 0, 0);
        assert new ArrayList<>(outPut).equals(solveUsingStack(new ArrayList<>(input)));
    }

}
