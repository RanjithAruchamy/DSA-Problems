package leetcode.easy;

public class Sqrt {
    public static void main(String[] args) {
        assert 2 == mySqrt(4);
        assert 2 == mySqrt(8);
        assert 46339 == mySqrt(2147395599);
        assert 0 == mySqrt(0);
        assert 1 == mySqrt(1);
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while (left <= right) {
            float halfLeft = (float) left / 2;
            float halfRight = (float) right / 2;
            int mid = (int) (halfLeft + halfRight);
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
