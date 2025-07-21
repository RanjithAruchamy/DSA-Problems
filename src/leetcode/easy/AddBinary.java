package leetcode.easy;

public class AddBinary {

    public static void main(String[] args) {
        assert "100".equals(addBinary("11", "1"));
        assert "10101".equals(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >=0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum = a.charAt(i) - '0' + sum;
                i--;
            }
            if (j >= 0) {
                sum = b.charAt(j) - '0' + sum;
                j--;
            }
            carry = sum / 2;
            result.append(sum % 2);
        }
        return result.reverse().toString();
    }
}
