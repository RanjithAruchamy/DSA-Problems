package scaler.stack;

import java.util.Stack;

public class InfixToPostfix {

    /**
     *Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
     *
     * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
     *
     * Find and return the postfix expression of A.
     *
     * NOTE:
     *
     * ^ has the highest precedence.
     * / and * have equal precedence but greater than + and -.
     * + and - have equal precedence and lowest precedence among given operators.
     *
     * Example Input
     *
     * Input 1:
     *  A = "x^y/(a*z)+b"
     *
     *  Input 2:
     *  A = "a+b*(c^d-e)^(f+g*h)-i"
     *
     * Example Output
     */
     // Output 1:
    // "xy^az*/b+"
    //  Output 2:
    //      "abcd^e-fgh*+^*+i-"


    public static String solve(String A) {
        Stack<Character> st = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (Character character : A.toCharArray()) {
            if (!isOperator(character)) {
                builder.append(character);
            } else if (character == '(' || character == '^') {
                st.push(character);
            } else if (character == ')') {
                while (st.size() > 0) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    builder.append(st.pop());
                }
            } else if (character == '/') {
                while (st.size() > 0 && st.peek() == '^') {
                    builder.append(st.pop());
                }
                st.push(character);
            } else if (character == '*') {
                while (st.size() > 0 && (st.peek() == '^' || st.peek() == '/')) {
                    builder.append(st.pop());
                }
                st.push(character);
            } else if (character == '+') {
                while (st.size() > 0 && (st.peek() == '^' || st.peek() == '*' || st.peek() == '/')) {
                    builder.append(st.pop());
                }
                st.push(character);
            } else if (character == '-') {
                while (st.size() > 0 && (st.peek() == '^' || st.peek() == '*' || st.peek() == '/' || st.peek() == '+')) {
                    builder.append(st.pop());
                }
                st.push(character);
            }
        }
        while (st.size() > 0) {
            builder.append(st.pop());
        }
        return builder.toString();
    }

    private static boolean isOperator(Character character) {
        if (character == '^' || character == '+' || character == '-' || character == '*' || character == '/' || character == '(' || character == ')')
            return true;
        return false;
    }

    public static void main(String[] args) {
//        assert "xy^az*/b+".equals(solve("x^y/(a*z)+b"));
        assert "abcd^e-fgh*+^*+i-".equals(solve("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
