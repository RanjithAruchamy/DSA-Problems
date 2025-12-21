package scaler.contest.dsa2.attempt4;

public class IdenticalBinaryTrees {

    /**
     * Given two binary trees, check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     *
     * Input 1:
     *    1       1
     *   / \     / \
     *  2   3   2   3
     *
     * Input 2:
     *    1       1
     *   / \     / \
     *  2   3   3   3
     *
     *  Output 1:
     *  1
     * Output 2:
     *  0
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    int ans = 0;
    public int isSameTree(TreeNode A, TreeNode B) {
        ans = 1;
        preOrder(A, B);
        return ans;
    }

    private void preOrder(TreeNode A, TreeNode B) {
        if (A == null && B == null) return;

        if ( A == null || B == null || A.val != B.val) {
            ans = 0;
            return;
        }

        if (ans != 0)   preOrder(A.left, B.left);
        if (ans != 0)   preOrder(A.right, B.right);
    }

}
