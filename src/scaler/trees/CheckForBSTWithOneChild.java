package scaler.trees;

public class CheckForBSTWithOneChild {

    /**
     * Given preorder traversal of a binary tree,
     * check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
     * where each internal node (non-leaf nodes) have exactly one child.
     *
     * Input 1:
     *  A : [4, 10, 5, 8]
     * Input 2:
     *  A : [1, 5, 6, 4]
     *
     *  Output 1:
     *  "YES"
     * Output 2:
     *  "NO"
     */

    public static String solve(int[] A) {
        int n = A.length;

        if (n <= 2) return "YES";

        int min = Math.min(A[n-1], A[n-2]);
        int max = Math.max(A[n-1], A[n-2]);

        for (int i = n - 3; i >= 0; i--) {
            if (A[i] > min && A[i] < max) {
                return "NO";
            }
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        return "YES";
    }
}
