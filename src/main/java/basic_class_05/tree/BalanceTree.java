package basic_class_05.tree;

import leetcode.entity.TreeNode;

/**
 * 验证平衡二叉树
 */
public class BalanceTree {

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(heigth(root.left) - heigth(root.right)) > 1) {
            return false;
        }

        return isBalance(root.left) && isBalance(root.right);
    }

    public int heigth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heigth(root.left), heigth(root.right)) + 1;
    }

}
