package scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    /**
     * Given an array of integers A.
     * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
     * Find the area of the largest rectangle formed by the histogram.
     *
     * Input 1:
     *  A = [2, 1, 5, 6, 2, 3]
     *
     *  Input 2:
     *  A = [2]
     *
     *  Output 1:
     *  10
     *
     *  Output 2:
     *  2
     */

    public static int largestRectangleArea(ArrayList<Integer> A) {
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

        // Core logic to find the max rectangle
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int height = A.get(i);
            int width = rightSmallest.get(i) - leftSmallest.get(i) - 1;
            int area = height * width;
            maxValue = Math.max(area, maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
//        input.add(1);
//        input.add(5);
//        input.add(6);
//        input.add(2);
//        input.add(3);
        System.out.println(largestRectangleArea(input));
    }
}
