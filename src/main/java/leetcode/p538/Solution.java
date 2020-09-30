package leetcode.p538;

import leetcode.entity.TreeNode;

/**
 * 二叉搜索树转换成累加树
 */
public class Solution {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrderRecur(root);
        return root;
    }

    public void inOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.right);
        node.val += sum;
        sum = node.val;
        inOrderRecur(node.left);
    }
}