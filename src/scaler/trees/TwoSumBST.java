package scaler.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {

    /**
     * Given a binary search tree A, where each node contains a positive integer, and an integer B,
     * you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
     * Return 1 to denote that two such nodes exist. Return 0, otherwise
     *
     * Input 1:
     *          10
     *          / \
     *         9   20
     * B = 19
     * Input 2:
     *           10
     *          / \
     *         9   20
     * B = 40
     *
     * Output 1:
     *  1
     * Output 2:
     *  0
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

    Set<Integer> set = new HashSet<>();

    public int t2SumMap(TreeNode A, int B) {
            return inOrderMap(A, B);
    }

    private int inOrderMap(TreeNode A, int B) {
        if (A == null) return 0;

        if (set.contains(B - A.val)) {
            return 1;
        }
        set.add(A.val);
        return inOrderMap(A.left, B) == 1 || inOrderMap(A.right, B) == 1 ? 1 : 0;
    }

    public int t2Sum(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(A, arr);

        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == B) {
                return 1;
            } else if (sum > B) {
                right--;
            } else {
                left++;
            }
        }
        return 0;
    }

    private void inOrder(TreeNode A, ArrayList<Integer> arr) {
        if (A == null) return;

        inOrder(A.left, arr);
        arr.add(A.val);
        inOrder(A.right, arr);
    }
}
