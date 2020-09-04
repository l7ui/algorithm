package leetcode.m0406;

import leetcode.entity.TreeNode;

public class Solution2 {
    private TreeNode successor;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        inorderSuccessor(root, p);
        return successor;
    }
    public void inorderRecur(TreeNode root, TreeNode p) {
        if (root == p || root == null) {
            return;
        }
        inorderSuccessor(root.right, p);
        successor = root;
        inorderSuccessor(root.left, p);
    }
}
