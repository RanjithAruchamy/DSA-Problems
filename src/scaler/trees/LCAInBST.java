package scaler.trees;

public class LCAInBST {

    /**
     * Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
     *
     * Note 1 :- It is guaranteed that the nodes B and C exist.
     * Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
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
     *      B = 8
     *      C = 20
     * Input 2:
     *             8
     *            / \
     *           6  21
     *          / \
     *         1   7
     *
     *      B = 7
     *      C = 1
     *
     * Output 1:
     *  15
     * Output 2:
     *  6
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


    public int solve(TreeNode A, int B, int C) {
        return preOrder(A, B, C).val;
    }

    private TreeNode preOrder(TreeNode A, int B, int C) {
        if (A == null) return A;
        if (A.val == B || A.val == C) return A;

        TreeNode left = preOrder(A.left, B, C);
        TreeNode right = preOrder(A.right, B, C);

        if (left == null) return right;
        else if (right == null) return left;
        else if (left != null && right != null) {
            return A;
        }
        return A;
    }

}
