package leetcode.p257;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 */
public class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode node, String path) {
        if (node != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                res.add(sb.toString());
            } else {
                sb.append("->");
                dfs(node.left, sb.toString());
                dfs(node.right, sb.toString());
            }
        }
    }
}
