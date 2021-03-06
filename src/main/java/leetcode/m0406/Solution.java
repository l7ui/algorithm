package leetcode.m0406;

import leetcode.entity.TreeNode;

/**
 * 中序遍历的后继节点
 */
public class Solution {
    private TreeNode successor;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
