package leetcode.binarytree.p226;

import leetcode.entity.TreeNode;

/**
 * 反转二叉树
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }
}
