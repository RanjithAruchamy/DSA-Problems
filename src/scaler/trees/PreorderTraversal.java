package scaler.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes values.
     *
     * Input 1:
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
     * Output 1:
     *  [1, 2, 3]
     *
     *  Output 2:
     *  [1, 6, 2, 3]
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

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        TreeNode childNode = new TreeNode(2);
        childNode.left = new TreeNode(3);

        treeNode.right = childNode;

        System.out.println(preorderTraversal(treeNode));

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode childNode1 = new TreeNode(2);
        childNode1.left = new TreeNode(3);

        treeNode1.left = new TreeNode(6);
        treeNode1.right = childNode;

        System.out.println(preorderTraversal(treeNode1));
    }
}
