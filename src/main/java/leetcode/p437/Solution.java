package leetcode.p437;

import leetcode.entity.TreeNode;

/**
 * 二叉树路径和为 K 的路径数
 */
public class Solution {
    private int ans;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        if (sum == 0) {
            ans++;
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
