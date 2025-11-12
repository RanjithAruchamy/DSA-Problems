package scaler.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreater {

    /**
     *Given an array A, find the next greater element G[i] for every element A[i] in the array.
     * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
     *
     * More formally:
     *
     * G[i] for an element A[i] = an element A[j] such that
     *     j is minimum possible AND
     *     j > i AND
     *     A[j] > A[i]
     * Elements for which no greater element exists, consider the next greater element as -1.
     *
     * Example Input
     *
     * Input 1:
     *  A = [4, 5, 2, 10]
     *
     *  Input 2:
     *  A = [3, 2, 1]
     *
     * Example Output
     *
     * Output 1:
     *  [5, 10, 10, -1]
     *
     *  Output 2:
     *  [-1, -1, -1]
     */

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> resArr = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            resArr.add(0);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {

            while (st.size() > 0) {
                if (st.peek() > A.get(i)) {
                    resArr.set(i, st.peek());
                    st.push(A.get(i));
                    break;
                } else {
                    st.pop();
                }
            }

            if (st.size() == 0) {
                resArr.set(i, -1);
                st.push(A.get(i));
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result2 = new ArrayList<>();
        result2.add(5);
        result2.add(10);
        result2.add(10);
        result2.add(-1);
        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(4);
        input2.add(5);
        input2.add(2);
        input2.add(10);
        assert result2.equals(nextGreater(input2));
    }
}
