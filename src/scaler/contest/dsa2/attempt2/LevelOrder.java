package scaler.contest.dsa2.attempt2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     *
     * Input 1:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *  Input 2:
     *    1
     *   / \
     *  6   2
     *     /
     *    3
     *
     * Output 1:
     *  [
     *    [3],
     *    [9, 20],
     *    [15, 7]
     *  ]
     *
     *  Output 2:
     *  [
     *    [1]
     *    [6, 2]
     *    [3]
     *  ]
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

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode root = queue.remove();
                level.add(root.val);

                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            result.add(level);
        }
        return result;
    }
}
