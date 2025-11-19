package scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    /**
     * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
     * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
     *
     * Input 1:
     *             1
     *           /   \
     *          2    3
     *         / \  / \
     *        4   5 6  7
     *       /
     *      8
     *
     *  Input 2:
     *             1
     *            /  \
     *           2    3
     *            \
     *             4
     *              \
     *               5
     * Output 1:
     *  [1, 3, 7, 8]
     *
     *  Output 2:
     *  [1, 3, 4, 5]
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

    public static ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        ArrayList<Integer> resArr = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode currNode = queue.remove();
                if (i == 1) resArr.add(currNode.val);
                if (currNode.right != null) queue.add(currNode.right);
                if (currNode.left != null) queue.add(currNode.left);
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        TreeNode leftChildNode = new TreeNode(2);
        TreeNode rightChildNode1 = new TreeNode(4);
        rightChildNode1.right = new TreeNode(5);
        leftChildNode.right = rightChildNode1;

        TreeNode rightChildNode = new TreeNode(3);
        treeNode.left = leftChildNode;
        treeNode.right = rightChildNode;

        System.out.println(solve(treeNode));

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode childNode1 = new TreeNode(3);
        childNode1.left = new TreeNode(3);

        treeNode1.left = new TreeNode(6);
        treeNode1.right = leftChildNode;

//        System.out.println(solve(treeNode1));
    }
}
