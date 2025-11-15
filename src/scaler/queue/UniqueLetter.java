package scaler.queue;

import java.util.*;

public class UniqueLetter {

    /**
     * Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".
     * <p>
     * Here's a scenario:
     * <p>
     * A student says "a". It's the first letter. You write "a".
     * Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
     * A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
     * A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
     * A student says "c". "c" is unique. You add "c". The final is "aab#c".
     * Your task? Given the sequence the students call out A, determine the string on the board.
     * <p>
     * Input 1:
     * A = "abadbc"
     * <p>
     * Input 2:
     * A = "abcabc"
     * <p>
     * Output 1:
     * "aabbdd"
     * <p>
     * Output 2:
     * "aaabc#"
     */

    public static String solve(String A) {
        Map<Character, Integer> charactersCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (Character ch : A.toCharArray()) {
            if (charactersCount.containsKey(ch)) {
                int count = charactersCount.get(ch);
                charactersCount.put(ch, ++count);
                while (!queue.isEmpty() && charactersCount.get(queue.peek()) > 1) {
                    queue.remove();
                }
                if (queue.isEmpty()) {
                    builder.append('#');
                } else {
                    builder.append(queue.peek());
                }
            } else {
                queue.add(ch);
                charactersCount.put(ch, 1);
                builder.append(queue.peek());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        assert "aabbdd".equals(solve("abadbc"));
//        assert "aabbbcccccc".equals(solve("abacabdaeaf"));
//        assert "aabbbbbbbb".equals(solve("abacadaeaf"));
//        assert "aaabc####".equals(solve("abcabcabc"));
        System.out.println(solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }
}
