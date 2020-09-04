package leetcode.p437;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    private LinkedList<Integer> path = new LinkedList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res.size();
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        sum -= node.val;
        if (sum == 0) {
            res.add(new LinkedList<>(path));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        path.removeLast();
    }
}
