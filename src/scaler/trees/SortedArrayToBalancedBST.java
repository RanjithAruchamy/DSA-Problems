package scaler.trees;

public class SortedArrayToBalancedBST {

    /**
     *
     */

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        return constructBBST(A, 0, A.length - 1);
    }

    private static TreeNode constructBBST(int[] A, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = constructBBST(A, start, mid - 1);
        root.right = constructBBST(A, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 5, 10};
        System.out.println(sortedArrayToBST(input));
    }
}
