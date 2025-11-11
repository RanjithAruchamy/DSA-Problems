package scaler.stack;

import java.util.Stack;

public class BalancedParanthesis {

    /**
     * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
     * Refer to the examples for more clarity.
     *
     * Example Input
     *
     * Input 1:
     *  A = {([])}
     *
     *  Input 2:
     *  A = (){
     *
     *  Input 3:
     *  A = ()[]
     *
     * Example Output
     *
     * Output 1:    1
     * Output 2:    0
     * Output 3:    1
     */

    public static int solve(String A) {
        Stack<Character> st = new Stack<>();
        for (Character bracket : A.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                st.push(bracket);
            } else if (st.size() > 0 && bracket == ')') {
                if (st.peek() == '(') st.pop();
                else return 0;
            } else if (st.size() > 0 && bracket == ']') {
                if (st.peek() == '[') st.pop();
                else return 0;
            } else if (st.size() > 0 && bracket == '}') {
                if (st.peek() == '{') st.pop();
                else return 0;
            } else {
                return 0;
            }
        }
        if (st.size() == 0) return 1;
        else return 0;
    }

    public static void main(String[] args) {
//        assert 1 == solve("{([])}");
//        assert 0 == solve("(){");
//        assert 1 == solve("()[]");
        assert 0 == solve("))))))))");
    }
}
