package scaler.contest.dsa2.attempt2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    /**
     * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
     * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
     *
     * NOTE:
     * In the array, the NULL/None child is denoted by -1.
     * For more clarification check the Example Input.
     *
     * Input 1:
     *            1
     *          /   \
     *         2     3
     *        / \
     *       4   5
     *
     *  Input 2:
     *             1
     *           /   \
     *          2     3
     *         / \     \
     *        4   5     6
     *
     *  Output 1:
     *  [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
     *
     *  Output 2:
     *  [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
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

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode root = queue.remove();
                result.add(root.val);

                if (root.val != -1) {
                    if (root.left == null) queue.add(new TreeNode(-1));
                    else queue.add(root.left);

                    if (root.right == null) queue.add(new TreeNode(-1));
                    else queue.add(root.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        TreeNode leftChildNode = new TreeNode(2);
        leftChildNode.left = new TreeNode(4);
        leftChildNode.right = new TreeNode(5);

        TreeNode rightChildNode = new TreeNode(3);
        rightChildNode.right = new TreeNode(6);

        treeNode.left = leftChildNode;
        treeNode.right = rightChildNode;

        System.out.println(solve(treeNode));
    }
}
