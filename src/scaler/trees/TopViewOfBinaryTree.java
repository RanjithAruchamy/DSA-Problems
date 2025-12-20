package scaler.trees;

import java.util.*;

public class TopViewOfBinaryTree {

    /**
     * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
     * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
     * Return the nodes in any order.
     *
     * Input 1:
     *             1
     *           /   \
     *          2    3
     *         / \  / \
     *        4   5 6  7
     *       /
     *      8
     * Input 2:
     *             1
     *            /  \
     *           2    3
     *            \
     *             4
     *              \
     *               5
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

    class Pair {
        int index;
        TreeNode node;
        Pair (int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0, max = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, A));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            int index = pair.index;
            TreeNode root = pair.node;

            if (!map.containsKey(index)) {
                map.put(index, root.val);
            }

            min = Math.min(min, index);
            max = Math.max(max, index);

            if (root.left != null) queue.add(new Pair(index - 1, root.left));
            if (root.right != null) queue.add(new Pair(index + 1, root.right));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
