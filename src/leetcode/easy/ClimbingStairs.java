package leetcode.easy;

public class ClimbingStairs {
    public static void main(String[] args) {
        assert 2 == climbStairs(2);
        assert 8 == climbStairs(5);
        assert 34 == climbStairs(8);
    }

    public static int climbStairs(int n) {
        int current = 1;
        int previous = 1;
        int output = 0;

        if (n == 0 || n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            output = current + previous;
            previous = current;
            current = output;
        }
        return output;
    }
}
