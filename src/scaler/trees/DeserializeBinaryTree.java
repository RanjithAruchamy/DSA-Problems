package scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

    /**
     *  You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
     * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
     *
     * NOTE:
     * In the array, the NULL/None child is denoted by -1.
     * For more clarification check the Example Input.
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
     *
     *  Input 2:
     *  A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
     *
     *  Output 1:
     *            1
     *          /   \
     *         2     3
     *        / \
     *       4   5
     *
     *  Output 2:
     *             1
     *           /   \
     *          2     3
     *         / \     \
     *        4   5     6
     */

    public static SerializeBinaryTree.TreeNode solve(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) return null;

        SerializeBinaryTree.TreeNode root = new SerializeBinaryTree.TreeNode(A.getFirst());
        Queue<SerializeBinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < A.size(); i++) {
            SerializeBinaryTree.TreeNode node = queue.poll();

            if (A.get(i) != -1) {
                SerializeBinaryTree.TreeNode leftNode = new SerializeBinaryTree.TreeNode(A.get(i));
                node.left = leftNode;
                queue.add(leftNode);
            }

            i++;

            if (A.get(i) != -1) {
                SerializeBinaryTree.TreeNode rightNode = new SerializeBinaryTree.TreeNode(A.get(i));
                node.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
        ArrayList<Integer> input = new ArrayList<>();
        for (Integer num : array) {
            input.add(num);
        }
        SerializeBinaryTree.TreeNode resultNode = solve(input);
        assert input.equals(SerializeBinaryTree.solve(resultNode));
    }
}
