package scaler.trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * NOTE: Using recursion and stack are not allowed.
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
     *  [1, 3, 2]
     *
     *  Output 2:
     *  [6, 1, 3, 2]
     */


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null) return new ArrayList<>();

        ArrayList<Integer> arr = new ArrayList<>();

        while (A != null) {
            if (A.left == null) {
                arr.add(A.val);
                A = A.right;
            } else {
                TreeNode temp = A.left;
                while (temp.right != null && temp.right != A) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = A;
                    A = A.left;
                }

                if (temp.right == A) {
                    temp.right = null;
                    arr.add(A.val);
                    A = A.right;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
