package scaler.trees;

public class LeastCommonAncestor {

    /**
     * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
     *
     * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node
     * that has both v and w as descendants.
     *
     * Input 1:
     *       1
     *      /  \
     *     2    3
     * B = 2
     * C = 3
     *
     *  Input 2:
     *       1
     *      /  \
     *     2    3
     *    / \
     *   4   5
     * B = 4
     * C = 5
     *
     * Output 1:
     *  1
     * Output 2:
     *  2
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

    public int lca(TreeNode A, int B, int C) {
        if (!search(A, B) || !search(A, C)) return -1;
        return preorder(A, B, C).val;
    }

    public boolean search(TreeNode A, int B) {
        if (A == null) return false;

        if (A.val == B) return true;

        return search(A.left, B) || search(A.right, B);
    }

    public TreeNode preorder(TreeNode A, int B, int C) {
        if(A == null) return A;

        if (A.val == B || A.val == C) return A;

        TreeNode l = preorder(A.left, B, C);
        TreeNode r = preorder(A.right, B, C);

        if (l == null) return r;
        else if (r == null) return l;
        if (r != null && l != null) return A;

        else return null;
    }

}
