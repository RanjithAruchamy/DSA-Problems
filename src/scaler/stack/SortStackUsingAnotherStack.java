package scaler.stack;

import java.util.Stack;

public class SortStackUsingAnotherStack {

    /**
     * Given a stack of integers A, sort it using another stack.
     * Return the array of integers after sorting the stack using another stack.
     *
     * Input 1:
     *  A = [5, 4, 3, 2, 1]
     *
     *  Input 2:
     *  A = [5, 17, 100, 11]
     *
     *  Output 1:
     *  [1, 2, 3, 4, 5]
     *
     *  Output 2:
     *  [5, 11, 17, 100]
     */

    public int[] solve(int[] A) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        for (Integer num: A) {
            while (!stackA.isEmpty() && num > stackA.peek()) {
                stackB.push(stackA.pop());
            }
            stackA.push(num);
            while (!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
        }

        int[] resArr = new int[A.length];
        int index = 0;
        while (!stackA.isEmpty()) {
            resArr[index++] = stackA.pop();
        }
        return resArr;
    }

}
