package scaler.contest.dsa2.attempt1;

public class BalancedBinaryTree {

    /**
     * Given a root of binary tree A, determine if it is height-balanced.
     * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Input 1:
     *     1
     *    / \
     *   2   3
     *
     *  Input 2:
     *        1
     *       /
     *      2
     *     /
     *    3
     *
     * Output 1:
     * 1
     *
     *  Output 2:
     * 0
     *
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
     */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    int ans = 0;
    public int isBalanced(TreeNode A) {
        ans = 1;
        isBal(A);
        return ans;
    }

    private int isBal(TreeNode A) {
      if (A == null) return 0;

      int leftHeight = isBal(A.left);
      int rightHeight = isBal(A.right);

      if (Math.abs(leftHeight - rightHeight) > 1) ans = 0;

      return Math.max(leftHeight, rightHeight) + 1;
    }
}
