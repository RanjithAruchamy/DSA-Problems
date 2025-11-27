package scaler.trees;

public class EqualTreePartition {

    /**
     * Given a binary tree A. Check whether it is possible to partition the tree to two trees
     * which have equal sum of values after removing exactly one edge on the original tree.
     *
     * Input 1:
     *                 5
     *                /  \
     *               3    7
     *              / \  / \
     *             4  6  5  6
     *
     *  Input 2:
     *                 1
     *                / \
     *               2   10
     *                   / \
     *                  20  2
     *
     * Output 1:
     *  1
     *
     *  Output 2:
     *  0
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

    static int ans;
    public static int solve(TreeNode A) {
        ans = 0;
        long treeSum = treeSum(A);
        if (treeSum % 2 == 1) return 0;
        else subSum(A, treeSum / 2);

        return ans;
    }

    public static long subSum(TreeNode root, long halfSum) {
        if (root == null) return 0;

        long leftSum = subSum(root.left, halfSum);
        long rightSum = subSum(root.right, halfSum);

        if (leftSum == halfSum || rightSum == halfSum) {
            ans = 1;
        }

        return leftSum + rightSum + root.val;
    }

    public static long treeSum(TreeNode root) {
        if (root == null) return 0;

        long leftSum = treeSum(root.left);
        long rightSum = treeSum(root.right);

        return leftSum + rightSum + root.val;
    }
}
