package scaler.stack;

import java.util.Stack;

public class DoubleCharacterTrouble {

    /**
     *You have a string, denoted as A.
     *
     * To transform the string, you should perform the following operation repeatedly:
     * Identify the first occurrence of consecutive identical pairs of characters within the string.
     * Remove this pair of identical characters from the string.
     * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
     * The final result will be the transformed string.
     *
     * Example Input
     * Input 1:
     *  A = "abccbc"
     *
     * Input 2:
     *  A = "ab"
     *
     * Example Output
     * Output 1:
     *  "ac"
     *
     *  Output 2:
     *  "ab"
     */

    public static String solve(String A) {
        Stack<Character> st = new Stack<>();
        for (Character character : A.toCharArray()) {
            if (st.size() > 0 && st.peek() == character) st.pop();
            else st.push(character);
        }

        StringBuilder builder = new StringBuilder();
        while (st.size() > 0) {
            builder.append(st.pop());
        }
        builder.reverse();
        return builder.toString();
    }

    public static void main(String[] args) {
        assert "ac".equals(solve("abccbc"));
        assert "ab".equals(solve("ab"));
    }
}
