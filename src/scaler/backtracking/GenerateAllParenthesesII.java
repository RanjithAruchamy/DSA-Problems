package scaler.backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesesII {

    /**
     * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
     *
     * Input 1:
     *  A = 3
     *
     * Input 2:
     * A = 1
     *
     * Output 1:
     * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     *
     *  Output 2:
     * [ "()" ]
     */

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        paranthesis(A, result, "", 0, 0);
        return result;
    }

    private static void paranthesis(int A, ArrayList<String> result, String bracket, int openCount, int closeCount) {
        if (openCount > A || closeCount > openCount) return;

        if (2*A == bracket.length()) {
            result.add(bracket);
        }

        paranthesis(A, result, bracket + "(", openCount + 1, closeCount);
        paranthesis(A, result, bracket + ")", openCount, closeCount + 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
