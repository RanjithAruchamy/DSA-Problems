package scaler.trees;

public class DeleteANodeInBST {

    /**
     * Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
     * Note - If there are multiple options, always replace a node by its in-order predecessor
     * <p>
     * Input 1:
     * 15
     * /    \
     * 12      20
     * / \    /  \
     * 10  14  16  27
     * /
     * 8
     * <p>
     * B = 10
     * <p>
     * Input 2:
     * 8
     * / \
     * 6  21
     * / \
     * 1   7
     * <p>
     * B = 6
     * <p>
     * Output 1:
     * 15
     * /    \
     * 12      20
     * / \    /  \
     * 8  14  16  27
     * <p>
     * Output 2:
     * 8
     * / \
     * 1  21
     * \
     * 7
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

    public TreeNode solve(TreeNode A, int B) {
        if (A == null) return null;

        if (A.val == B) {
            if (A.left == null && A.right == null) {
                return null;
            } else if (A.left == null && A.right != null) {
                return A.right;
            } else if (A.left != null && A.right == null) {
                return A.left;
            } else if (A.left != null && A.right != null) {
                int max = max(A.left);
                A.val = max;
                A.left = solve(A.left, max);
            }
        } else if (A.val < B) {
            A.right = solve(A.right, B);
        } else {
            A.left = solve(A.left, B);
        }
        return A;
    }

    private static int max(TreeNode A) {
        if (A == null) return A.val;
        return max(A.right);
    }

    public static void main(String[] args) {

    }
}
