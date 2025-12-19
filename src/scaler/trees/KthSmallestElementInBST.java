package scaler.trees;

import java.util.ArrayList;

public class KthSmallestElementInBST {

    /**
     * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
     *
     * Input 1:
     *             2
     *           /   \
     *          1    3
     * B = 2
     *
     *  Input 2:
     *             3
     *            /
     *           2
     *          /
     *         1
     * B = 1
     *
     * Output 1:
     *  2
     * Output 2:
     *  1
     */

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
    static int counter = 0, ans = 0;

    public static int kthsmallest(TreeNode A, int B) {
        counter = 0;
        ans = Integer.MAX_VALUE;
        inOrderTraversal(A, B);

        return ans;
    }

    private static void inOrderTraversal(TreeNode A, int B) {
        if (A == null) return;

        if (ans == Integer.MAX_VALUE) inOrderTraversal(A.left, B);

        counter++;
        if (counter == B) {
            ans = A.val;
        }

        if (ans == Integer.MAX_VALUE) inOrderTraversal(A.right, B);
    }

    public static void main(String[] args) {
        TreeNode input = new TreeNode(1);
        kthsmallest(input, 1);
    }
}
