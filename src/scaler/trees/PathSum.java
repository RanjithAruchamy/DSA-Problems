package scaler.trees;

public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     *
     * Input 1:
     *  Tree:    5
     *          / \
     *         4   8
     *        /   / \
     *       11  13  4
     *      /  \      \
     *     7    2      1
     *  B = 22
     *
     *  Input 2:
     *  Tree:    5
     *          / \
     *         4   8
     *        /   / \
     *      -11 -13  4
     *  B = -1
     *
     * Output 1:
     *  1
     *
     *  Output 2:
     *  0
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

    public static int hasPathSum(TreeNode A, int B) {
        if (A == null) return 0;
        if (A.left == null && A.right == null) {
            return A.val == B ? 1 : 0;
        }

        int leftResult = hasPathSum(A.left, B - A.val);
        if (leftResult == 1) return 1;
        int rightResult = hasPathSum(A.right, B - A.val);
        if (rightResult == 1) return 1;

        return 0;
    }
    
    public static void main(String[] args) {

    }
}
