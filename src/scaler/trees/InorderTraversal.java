package scaler.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     *
     *  Input 1:
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     *  Input 2:
     *    1
     *   / \
     *  6   2
     *     /
     *    3
     *
     *  Output 1:
     *  [1, 3, 2]
     *
     *  Output 2:
     *  [6, 1, 3, 2]
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

    public static ArrayList<Integer> inorderTraversalIterative(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(A, res);
        return res;
    }

    private static void traverse(TreeNode A, ArrayList<Integer> res) {
        if (A == null) return;
        traverse(A.left, res);
        res.add(A.val);
        traverse(A.right, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        TreeNode childNode = new TreeNode(2);
        childNode.left = new TreeNode(3);

        treeNode.right = childNode;

        System.out.println(inorderTraversal(treeNode));
        System.out.println(inorderTraversalIterative(treeNode));

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode childNode1 = new TreeNode(2);
        childNode1.left = new TreeNode(3);

        treeNode1.left = new TreeNode(6);
        treeNode1.right = childNode;

        System.out.println(inorderTraversal(treeNode1));
        System.out.println(inorderTraversalIterative(treeNode1));
    }
}
