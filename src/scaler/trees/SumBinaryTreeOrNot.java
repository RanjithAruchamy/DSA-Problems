package scaler.trees;

import java.util.Stack;

public class SumBinaryTreeOrNot {

    /**
     *Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
     * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
     * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
     * Return 1 if it sum-binary tree else return 0.
     *
     * Input 1:
     *        26
     *      /    \
     *     10     3
     *    /  \     \
     *   4   6      3
     *
     *  Input 2:
     *        26
     *      /    \
     *     10     3
     *    /  \     \
     *   4   6      4
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
    
    public static int solve(TreeNode A) {
        return sum(A, 0) == -1 ? 0 : 1;
    }

    private static long sum(TreeNode A, int sum) {
        if (A == null) return 0;

        long leftSum = sum(A.left, sum);
        long rightSum = sum(A.right, sum);

        if (A.left == null & A.right == null) {
            return A.val;
        }

        if (leftSum == -1 || rightSum == -1 || (leftSum + rightSum) != A.val) {
            return -1;
        }
        return leftSum + rightSum + A.val;
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
    }
}
