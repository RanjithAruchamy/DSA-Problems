package scaler.heaps;

public class MinimumWindowSubstring {
    public static String minWindow(String A, String B) {
        int[] freqMap = new int[128];
        for (int i = 0; i < B.length(); i++) {
            freqMap[B.charAt(i)]++;
        }

        int minLength = Integer.MAX_VALUE;
        int l = 0, r = 0, start = 0;
        while (r <= A.length()) {
            if (isAllCharMatching(freqMap)) {
                int length = r - l;
                if (length < minLength) {
                    minLength = length;
                    start = l;
                }
                freqMap[A.charAt(l)]++;
                l++;
            } else {
                if (r < A.length())
                    freqMap[A.charAt(r)]--;
                r++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "-1";

        return A.substring(start, start + minLength);
    }

    private static boolean isAllCharMatching(int[] freqMap) {
        for(int i = 'A'; i < 128; i++) {
            if (freqMap[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assert "BANC".equals(minWindow("ADOBECODEBANC", "ABC"));
    }
}
