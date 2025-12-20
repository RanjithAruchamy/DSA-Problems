package scaler.trees;

public class DiameterOfBinaryTree {

    /**
     * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
     * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
     *
     * Input 1:
     *            1
     *          /   \
     *         2     3
     *        / \
     *       4   5
     *
     * Input 2:
     *             1
     *           /   \
     *          2     3
     *         / \     \
     *        4   5     6
     *
     * Output 1:
     *  3
     *
     * Output 2:
     *  4
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

    class Pair {
        int height;
        int diameter;
        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int solve(TreeNode A) {
        Pair pair = height(A);
        return pair.diameter;
    }

    private Pair height(TreeNode root) {
        if (root == null) {
            return new Pair(-1, 0);
        }

        Pair left = height(root.left);
        Pair right = height(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int maxOfLeftRight = Math.max(left.diameter, right.diameter);
        int currentDia = left.height + right.height + 2;
        int diameter = Math.max(maxOfLeftRight, currentDia);

        return new Pair(height, diameter);
    }
}
