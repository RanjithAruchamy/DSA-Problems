package scaler.contest.dsa2.attempt2;

import java.util.Stack;

public class PairOfPoles {

    /**
     * There are N poles, and the height of the poles is given by an integer array A.
     * You have to connect two poles such that all the poles between them have a height smaller than the minimum height of the two poles.
     * Find the total number of pairs of such poles.
     *
     * Input 1:
     *  A = [4, 3, 6, 1, 10]
     *
     *  Input 2:
     *  A = [1, 2, 4, 3, 5]
     *
     *  Output 1:
     *  6
     *
     *  Output 2:
     *  5
     *
     *  Explanation 1:
     *  All the pairs of poles are [4, 3], [4, 6], [3, 6], [6, 10], [6, 1], [1, 10].
     *
     *  Explanation 2:
     *  All the pairs of poles are [1, 2], [2, 4], [4, 3], [3, 5], [4, 5].
     */

    public static int solve(int[] A) {
        long count = 0;

        Stack<Integer> stack = new Stack<>();
        for (int height : A) {
            while (!stack.isEmpty() && stack.peek() < height){
                stack.pop();
                count++;
            }

            if (!stack.isEmpty())   count++;

            stack.push(height);
        }
        return (int) count;
    }

    public static void main(String[] args) {
//        assert 6 == solve(new int[]{4, 3, 6, 1, 10});
        assert 5 == solve(new int[]{1, 2, 4, 3, 5});
    }
}
