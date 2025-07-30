package leetcode.easy;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] in = new int[] {2, 0};
        int[] out = new int[] {1, 2};
        merge(in, 1, new int[] {1}, 1);

        for (int i = 0; i < in.length; i++) {
            assert  out[i] == in[i];
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

}
