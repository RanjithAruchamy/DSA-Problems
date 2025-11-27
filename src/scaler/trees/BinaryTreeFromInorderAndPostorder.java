package scaler.trees;

public class BinaryTreeFromInorderAndPostorder {

    /**
     * Given the inorder and postorder traversal of a tree, construct the binary tree.
     * NOTE: You may assume that duplicates do not exist in the tree.
     * <p>
     * Input 1:
     * A = [2, 1, 3]
     * B = [2, 3, 1]
     * <p>
     * Input 2:
     * A = [6, 1, 3, 2]
     * B = [6, 3, 2, 1]
     * <p>
     * Output 1:
     * 1
     * / \
     * 2   3
     * <p>
     * Output 2:
     * 1
     * / \
     * 6   2
     * /
     * 3
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

    public static TreeNode buildTree(int[] A, int[] B) {
        return construct(A, B, 0, A.length - 1, 0, B.length - 1);
    }

    public static TreeNode construct(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int idx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                idx = i;
                break;
            }
        }
        int count = idx - inStart;

        node.left = construct(inorder, postorder, inStart, idx - 1, postStart, postStart + count - 1);
        node.right = construct(inorder, postorder, idx + 1, inEnd, postStart + count, postEnd - 1);

        return node;
    }

    public static void main(String[] args) {
        int[] inOrder = {2,1,3};
        int[] postOrder = {2,3,1};
        buildTree(inOrder, postOrder);
    }
}
