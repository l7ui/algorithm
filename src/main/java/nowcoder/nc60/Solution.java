package nowcoder.nc60;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = isSort(root);
        res[1] = isComplete(root);
        return res;
    }

    private int pre = Integer.MIN_VALUE;

    public boolean isSort(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isSort(root.left);
        boolean in = true;
        if (root.val <= pre) {
            in = false;
        }
        pre = root.val;

        boolean right = isSort(root.right);
        return in && left && right;
    }

    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        TreeNode left = null, right = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            left = node.left;
            right = node.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            } else {
                leaf = true;
            }
        }

        return true;
    }
}