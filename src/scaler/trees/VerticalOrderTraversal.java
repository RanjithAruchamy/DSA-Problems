package scaler.trees;

import java.util.*;

public class VerticalOrderTraversal {

    /**
     * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example for more details.
     * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
     *
     * Input 1:
     *       6
     *     /   \
     *    3     7
     *   / \     \
     *  2   5     9
     *
     *  Input 2:
     *       1
     *     /   \
     *    3     7
     *   /       \
     *  2         9
     *
     * Output 1:
     *  [
     *     [2],
     *     [3],
     *     [6, 5],
     *     [7],
     *     [9]
     *  ]
     * Output 2:
     *  [
     *     [2],
     *     [3],
     *     [1],
     *     [7],
     *     [9]
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

    class Pair {
        int index;
        TreeNode node;
        Pair (int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = 0, max = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, A));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int index = pair.index;
                TreeNode root = pair.node;

                map.putIfAbsent(index, new ArrayList<>());
                map.get(index).add(root.val);

                min = Math.min(min, index);
                max = Math.max(max, index);

                if (root.left != null) queue.add(new Pair(index - 1, root.left));
                if (root.right != null) queue.add(new Pair(index + 1, root.right));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
