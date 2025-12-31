package scaler.trees;

public class BSTNodesInARange {

    /**
     * Given a binary search tree of integers. You are given a range B and C.
     * Return the count of the number of nodes that lie in the given range.
     *
     * Input 1:
     *             15
     *           /    \
     *         12      20
     *         / \    /  \
     *        10  14  16  27
     *       /
     *      8
     *
     *      B = 12
     *      C = 20
     * Input 2:
     *             8
     *            / \
     *           6  21
     *          / \
     *         1   7
     *
     *      B = 2
     *      C = 20
     *
     * Output 1:
     *  5
     * Output 2:
     *  3
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

    int count = 0;
    public int solve(TreeNode A, int B, int C) {
        count = 0;
        count(A, B, C);
        return count;
    }

    private void count(TreeNode A, int B, int C) {
        if (A == null) return;

        if (A.val >= B && A.val <= C) {
            count++;
        }
        count(A.left, B, C);
        count(A.right, B, C);
    }
}
