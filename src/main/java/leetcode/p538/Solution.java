package leetcode.p538;

import leetcode.entity.TreeNode;

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