package leetcode.easy;

public class LongestCommonPrefix {

    /**
     * BruteForce Approach
     */
    public static String firstApproach(String[] strs) {

        String referenceString = strs[0];
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 1; i <= strs.length - 1; i++) {
            String[] splitString = strs[i].split("");
            StringBuilder prefix = new StringBuilder();
            for (String character : splitString) {
                prefix.append(character);
                if (referenceString.startsWith(prefix.toString())) {
                    commonPrefix.append(character);
                }
            }
            referenceString = commonPrefix.toString();
            commonPrefix.delete(0, commonPrefix.length());
        }
        return referenceString;
    }

    public static String secondApproach(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String p = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(p) != 0) {
                p = p.substring(0, p.length() - 1);
                if (p.isEmpty()) return "";
            }
        }
        return p;
    }

    public static void main(String[] args) {
        String[] inputA = {"flower", "flow", "flight"};
        String outputA = "fl";
        assert outputA.equals(firstApproach(inputA));

        String[] inputB = {"dog", "racecar", "car"};
        String outputB = "";
        assert outputB.equals(firstApproach(inputB));
    }
}
