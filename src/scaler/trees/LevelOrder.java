package scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
     *    Output 1:
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

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        ArrayList<ArrayList<Integer>> resArr = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode currNode = queue.remove();
                values.add(currNode.val);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            resArr.add(values);
        }
        return resArr;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        TreeNode childNode = new TreeNode(20);
        childNode.left = new TreeNode(15);
        childNode.right = new TreeNode(7);
        treeNode.right = childNode;
        System.out.println(solve(treeNode));
    }
}
