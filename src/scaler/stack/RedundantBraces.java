package scaler.stack;

import java.util.Stack;

public class RedundantBraces {

    /**
     *Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
     *
     * Check whether A has redundant braces or not.
     *
     * NOTE: A will be always a valid expression and will not contain any white spaces.
     *
     * Example Input
     *
     * Input 1:
     *  A = "((a+b))"
     *
     * Input 2:
     *  A = "(a+(a+b))"
     *
     * Example Output
     *
     * Output 1:
     *  1
     *
     *  Output 2:
     *  0
     */

    public static int braces(String A) {
        Stack<Character> st = new Stack<>();
        for (Character element : A.toCharArray()) {
            int elementsCountBetweenBraces = 0;
            if (element != ')') st.push(element);
            else {
                while (st.size() > 0 && st.peek() != '(') {
                    st.pop();
                    elementsCountBetweenBraces++;
                }
                if (elementsCountBetweenBraces < 2)    return 1;
                else st.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assert 1 == braces("((a+b))");
        assert 0 == braces("(a+(a+b))");
        assert 0 == braces("(a+(a+b)) * (b+(a+b))");
        assert 0 == braces("(a+b+c)");
        assert 0 == braces("((a+b)+(a+c))");
    }

}
