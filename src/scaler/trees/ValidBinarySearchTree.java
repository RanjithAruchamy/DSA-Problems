package scaler.trees;

import java.util.ArrayList;

public class ValidBinarySearchTree {

    /**
     * You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
     * Assume a BST is defined as follows:
     * 1) The left subtree of a node contains only nodes with keys less than the node's key.
     * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
     * 3) Both the left and right subtrees must also be binary search trees.
     *
     * Input 1:
     *    1
     *   /  \
     *  2    3
     *
     *  Input 2:
     *   2
     *  / \
     * 1   3
     *
     * Output 1:
     *  0
     *
     *  Output 2:
     *  1
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

    public static int isValidBSTOptimal(TreeNode A) {
        return isBst(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private static boolean isBst(TreeNode root, int start, int end) {
        if (root == null) return true;

        if (start <= root.val && root.val <= end) {
            boolean left = isBst(root.left, start, root.val - 1);
            if (!left) return  false;
            boolean right = isBst(root.right, start, root.val + 1);
            if (!right) return  false;
            return true;
        } else {
            return false;
        }
    }

    public static int isValidBST(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrderTraversal(A, res);

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) < res.get(i - 1)) return 0;
        }
        return 1;
    }

    private static void inOrderTraversal(TreeNode A, ArrayList<Integer> res) {
        if (A == null) return;

        inOrderTraversal(A.left, res);
        res.add(A.val);
        inOrderTraversal(A.right, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        assert 1 == isValidBSTOptimal(treeNode);

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        assert 0 == isValidBSTOptimal(treeNode1);
    }
}
