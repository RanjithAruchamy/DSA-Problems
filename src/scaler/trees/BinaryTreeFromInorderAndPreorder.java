package scaler.trees;

public class BinaryTreeFromInorderAndPreorder {

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * NOTE: You may assume that duplicates do not exist in the tree.
     *
     * Input 1:
     *  A = [1, 2, 3]
     *  B = [2, 1, 3]
     *
     *  Input 2:
     *  A = [1, 6, 2, 3]
     *  B = [6, 1, 3, 2]
     *
     *  Output 1:
     *    1
     *   / \
     *  2   3
     *
     *  Output 2:
     *    1
     *   / \
     *  6   2
     *     /
     *    3
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(int[] A, int[] B) {
        return construct(A, B, 0, A.length - 1, 0, B.length - 1);
    }

    public static TreeNode construct(int[] inorder, int[] preOrder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        int count = idx - inStart;

        node.left = construct(inorder, preOrder, inStart, idx - 1, preStart, preStart + count - 1);
        node.right = construct(inorder, preOrder, idx + 1, inEnd, preStart + count, preEnd - 1);

        return node;
    }
}
