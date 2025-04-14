package leetcode.easy;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.isBlank()) return false;

        String temp = s;
        for (int i = 0; i < s.length() - 1; i++) {
            temp = temp.replace("{}", "");
            temp = temp.replace("()", "");
            temp = temp.replace("[]", "");

            if (temp.isBlank()) return true;
        }

        return false;
    }

    public static boolean isValidBetterUsingStack(String s) {
        if (s.isBlank())
            return false;

        Map<Character, Character> bracketsMap = Map.of(
                '}', '{',
                ')', '(',
                ']', '['
        );
        Stack<Character> brackets = new Stack<>();

        for (Character bracket : s.toCharArray()) {

            if (bracket.equals('{') || bracket.equals('(') || bracket.equals('[')) {
                brackets.push(bracket);
                continue;
            }

            if (brackets.isEmpty())
                return false;

            if (brackets.peek().equals(bracketsMap.get(bracket)))
                brackets.pop();
            else
                return false;
        }

        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        assert isValidBetterUsingStack("()");
        assert isValidBetterUsingStack("()[]{}");
        assert !isValidBetterUsingStack("(]");
        assert isValidBetterUsingStack("([])");
        assert !isValidBetterUsingStack("([)]");
        assert !isValidBetterUsingStack("]");
        assert !isValidBetterUsingStack(")(){}");
        assert !isValidBetterUsingStack("(])");
    }
}
