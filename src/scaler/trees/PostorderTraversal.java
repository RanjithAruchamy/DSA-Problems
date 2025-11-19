package scaler.trees;

import java.util.*;

public class PostorderTraversal {

    /**
     *  Given a binary tree, return the Postorder traversal of its nodes values.
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
     * Output 1:
     *  [3, 2, 1]
     *
     *  Output 2:
     *  [6, 3, 2, 1]
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
    public static ArrayList<Integer> postorderTraversalRecursive(TreeNode A) {
        ArrayList<Integer> resArr = new ArrayList<>();
        recursiveTraversal(A, resArr);
        return resArr;
    }

    private static void recursiveTraversal(TreeNode A, ArrayList<Integer> resArr) {
        if (A == null) return;
        recursiveTraversal(A.left, resArr);
        recursiveTraversal(A.right, resArr);
        resArr.add(A.val);
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> resArr = new ArrayList<>();
        if (A == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                resArr.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();
            curr = curr.left;
        }
        Collections.reverse(resArr);
        return resArr;
    }
    
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        TreeNode childNode = new TreeNode(2);
        childNode.left = new TreeNode(3);

        treeNode.right = childNode;

        System.out.println(postorderTraversalRecursive(treeNode));
        System.out.println(postorderTraversal(treeNode));

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode childNode1 = new TreeNode(2);
        childNode1.left = new TreeNode(3);

        treeNode1.left = new TreeNode(6);
        treeNode1.right = childNode;

//        System.out.println(postorderTraversal(treeNode1));
    }
}
