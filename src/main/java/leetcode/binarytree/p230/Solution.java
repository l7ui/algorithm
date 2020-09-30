package leetcode.binarytree.p230;

import leetcode.entity.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        this.k = k;
        inorder(root);

        return num;
    }

    private int k = 0, num = 0;

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        k--;
        if (k == 0) {
            num = root.val;
            return;
        }
        inorder(root.right);
    }
}
