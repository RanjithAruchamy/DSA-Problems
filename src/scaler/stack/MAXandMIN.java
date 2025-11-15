package scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXandMIN {

    /**
     * Given an array of integers A.
     * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
     * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
     *
     * Example Input
     * Input 1:
     *  A = [1]
     *
     * Input 2:
     *  A = [4, 7, 3, 8]
     *
     * Example Output
     * Output 1:
     *  0
     *
     *  Output 2:
     *  26
     */

    public static int solve(ArrayList<Integer> A) {
        // Nearest smaller left element
        ArrayList<Integer> leftSmallest = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (st.size() > 0) {
                if (A.get(st.peek()) < A.get(i)) {
                    leftSmallest.add(st.peek());
                    st.push(i);
                    break;
                } else {
                    st.pop();
                }
            }
            if (st.size() == 0) {
                leftSmallest.add(-1);
                st.push(i);
            }
        }

        // Nearest smaller right element
        ArrayList<Integer> rightSmallest = new ArrayList<>();
        for (Integer num : A) {
            rightSmallest.add(0);
        }
        Stack<Integer> st1 = new Stack<>();
        for (int i = A.size() -1 ; i >= 0; i--) {
            while (st1.size() > 0) {
                if (A.get(st1.peek()) < A.get(i)) {
                    rightSmallest.set(i, st1.peek());
                    st1.push(i);
                    break;
                } else {
                    st1.pop();
                }
            }
            if (st1.size() == 0) {
                rightSmallest.set(i, A.size());
                st1.push(i);
            }
        }

        // Nearest greater left element
        ArrayList<Integer> leftGreatest = new ArrayList<>();
        Stack<Integer> stGreatestLeft = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (stGreatestLeft.size() > 0) {
                if (A.get(stGreatestLeft.peek()) > A.get(i)) {
                    leftGreatest.add(stGreatestLeft.peek());
                    stGreatestLeft.push(i);
                    break;
                } else {
                    stGreatestLeft.pop();
                }
            }
            if (stGreatestLeft.size() == 0) {
                leftGreatest.add(-1);
                stGreatestLeft.push(i);
            }
        }


        // Nearest greater right element
        ArrayList<Integer> rightGreatest = new ArrayList<>();
        for (Integer num : A) {
            rightGreatest.add(0);
        }
        Stack<Integer> stGreatestRight = new Stack<>();
        for (int i = A.size() -1 ; i >= 0; i--) {
            while (stGreatestRight.size() > 0) {
                if (A.get(stGreatestRight.peek()) > A.get(i)) {
                    rightGreatest.set(i, stGreatestRight.peek());
                    stGreatestRight.push(i);
                    break;
                } else {
                    stGreatestRight.pop();
                }
            }
            if (stGreatestRight.size() == 0) {
                rightGreatest.set(i, A.size());
                stGreatestRight.push(i);
            }
        }

        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            int j = leftGreatest.get(i), k = rightGreatest.get(i);
            int max = (i - j) * (k - i);
            int p = leftSmallest.get(i), q = rightSmallest.get(i);
            int min = (i - p) * (q - i);
            int count = max - min;
            ans += A.get(i) * count;
            ans %= 1000 * 1000 * 1000 + 7;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(7);
        input.add(3);
        input.add(8);

        System.out.println(solve(input));
    }
}
