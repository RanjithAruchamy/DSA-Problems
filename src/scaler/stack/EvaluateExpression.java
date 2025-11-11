package scaler.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    /**
     *
     * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     *
     * Valid operators are +, -, *, /. Each string may be an integer or an operator.
     *
     * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
     *
     * Input 1:
     * A =   ["2", "1", "+", "3", "*"]
     * Input 2:
     * A = ["4", "13", "5", "/", "+"]
     *
     * Output 1:
     * 9
     * Output 2:
     * 6
     */

    private static int evalRPN(ArrayList<String> A){
        Stack<String> st = new Stack<>();
        for (String character : A) {
            if (isOperator(character)) {
                if (st.size() >= 2) {
                    int b = Integer.parseInt(st.pop());
                    int a = Integer.parseInt(st.pop());
                    st.push(performArithmeticOperation(a, b, character));
                }
            } else {
                st.push(character);
            }
        }
        return Integer.parseInt(st.pop());
    }

    private static boolean isOperator(String character) {
        if (character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/")) {
            return true;
        }
        return false;
    }

    private static String performArithmeticOperation(int a, int b, String operand) {
        switch (operand) {
            case "+": return String.valueOf(a + b);
            case "-": return String.valueOf(a - b);
            case "*": return String.valueOf(a * b);
            case "/": return String.valueOf(a / b);
            default: return String.valueOf(a + b);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("2");
        input.add("1");
        input.add("+");
        input.add("3");
        input.add("*");
        assert 9 == evalRPN(input);
    }
}
