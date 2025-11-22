package scaler.trees;

public class SearchInBST {

    /**
     *  Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
     *
     *  Input 1:
     *             15
     *           /    \
     *         12      20
     *         / \    /  \
     *        10  14  16  27
     *       /
     *      8
     *
     *      B = 16
     *
     *  Input 2:
     *             8
     *            / \
     *           6  21
     *          / \
     *         1   7
     *
     *      B = 9
     *
     *  Output 1:
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
    
    public static int solve(TreeNode A, int B) {
        if (A == null) return 0;

        if (A.val == B) return 1;
        else if (A.val < B) {
            return solve(A.right, B);
        } else {
            return solve(A.left, B);
        }
    }
    
    public static void main(String[] args) {

    }
}
