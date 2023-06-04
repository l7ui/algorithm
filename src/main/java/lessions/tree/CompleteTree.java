package lessions.tree;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTree {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        TreeNode left = null, right = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            left = node.left;
            right = node.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            } else {
                leaf = true;
            }
        }

        return true;
    }
}
