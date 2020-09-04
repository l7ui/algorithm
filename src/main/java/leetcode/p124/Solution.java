package leetcode.p124;

import leetcode.entity.TreeNode;

public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左子树最大的贡献
        int left = Math.max(maxGain(node.left), 0);
        // 右子树最大的贡献
        int right = Math.max(maxGain(node.right), 0);

        // 更新路径和的最大值
        max = Math.max(left + right + node.val, max);

        return Math.max(left, right) + node.val;
    }
}
