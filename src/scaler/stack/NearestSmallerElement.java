package scaler.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    /**
     *Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
     * More formally,
     * G[i] for an element A[i] = an element A[j] such that
     * j is maximum possible AND
     * j < i AND
     * A[j] < A[i]
     * Elements for which no smaller element exist, consider the next smaller element as -1.
     *
     * Example Input
     *
     * Input 1:
     *  A = [4, 5, 2, 10, 8]
     *
     * Input 2:
     *  A = [3, 2, 1]
     *
     * Example Output
     *
     * Output 1:
     *  [-1, 4, -1, 2, 2]
     *
     * Output 2:
     *  [-1, -1, -1]
     */

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (st.size() > 0) {
                if (st.peek() < A.get(i)){
                    result.add(i, st.peek());
                    st.push(A.get(i));
                    break;
                } else {
                    st.pop();
                }
            }
            if (st.size() == 0) {
                result.add(i, -1);
                st.push(A.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(4);
        result.add(-1);
        result.add(2);
        result.add(2);
        ArrayList<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(5);
        input.add(2);
        input.add(10);
        input.add(8);
//        assert result.equals(prevSmaller(input));

        ArrayList<Integer> result2 = new ArrayList<>();
        result2.add(-1);
        result2.add(-1);
        result2.add(-1);
        result2.add(-1);
        result2.add(4);
        result2.add(24);
        result2.add(24);
        result2.add(-1);
        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(39);
        input2.add(27);
        input2.add(11);
        input2.add(4);
        input2.add(24);
        input2.add(32);
        input2.add(32);
        input2.add(1);
        assert result2.equals(prevSmaller(input2));
    }
}
