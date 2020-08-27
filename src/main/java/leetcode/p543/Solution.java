package leetcode.p543;

import leetcode.entity.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = depth(root.left) + depth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(cur, Math.max(left, right));
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
