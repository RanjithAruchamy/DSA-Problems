package scaler.trees;

public class BalancedBinaryTree {

    /**
     * Given a root of binary tree A, determine if it is height-balanced.
     * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Input 1:
     *     1
     *    / \
     *   2   3
     *
     *  Input 2:
     *        1
     *       /
     *      2
     *     /
     *    3
     *
     * Output 1:
     * 1
     *
     * Output 2:
     * 0
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

    static int ans = 1;
    public int isBalanced(TreeNode A) {
        isBal(A);
        return ans;
    }

    private static int isBal(TreeNode A) {
        if (A == null) return -1;

        int leftHeight = isBal(A.left);
        int rightHeight = isBal(A.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans = 0;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

    }
}
