package leetcode.easy;

public class FindIndexOfFirstOccurenceInString {

    /** 28. Find the Index of the First Occurrence in a String
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     *
     *
     *
     * Example 1:
     *
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     * Example 2:
     *
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     * */

    public static int findIndexOfFirstOccurenceNaive(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int findIndexOfFirstOccurenceStringMatching(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        assert 0 == findIndexOfFirstOccurenceStringMatching("sadbutsad", "sad");
        assert -1 == findIndexOfFirstOccurenceStringMatching("leetcode", "leeto");
        assert 4 == findIndexOfFirstOccurenceStringMatching("goodbaduglybad", "bad");
        assert 2 == findIndexOfFirstOccurenceStringMatching("hello", "ll");
    }
}

