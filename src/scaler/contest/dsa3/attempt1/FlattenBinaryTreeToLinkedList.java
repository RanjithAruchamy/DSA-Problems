package scaler.contest.dsa3.attempt1;

public class FlattenBinaryTreeToLinkedList {

    /**
     * Given a Binary tree A, flatten it to a linked list in-place using preorder traversal.
     * The left child of all nodes should be NULL.
     *
     * Input1:
     *      1
     *     / \
     *    2   3
     *
     * Input2:
     *      1
     *     / \
     *    2   5
     *   / \   \
     *  3   4   6
     *
     * Output1:
     * 1
     *  \
     *   2
     *    \
     *     3
     *
     * Output1:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode flatten(TreeNode a) {
        flat(a);
        return a;
    }
    private void flat(TreeNode a) {
        if (a.left == null) {
            return;
        }

        TreeNode temp = a.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = a.right;
        a.right = a.left;
        a.left = null;
        flat(a.right);
    }
}
