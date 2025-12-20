package scaler.trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {

    /**
     * Given a binary tree,
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     * Assume perfect binary tree.
     *
     * Input 1:
     *      1
     *     /  \
     *    2    3
     * Input 2:
     *         1
     *        /  \
     *       2    5
     *      / \  / \
     *     3  4  6  7
     *
     * Output 1:
     *         1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     * Output 2:
     *          1 -> NULL
     *        /  \
     *       2 -> 5 -> NULL
     *      / \  / \
     *     3->4->6->7 -> NULL
     */

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeLinkNode node = queue.poll();

                if (i != size)  node.next = queue.peek();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }
}
