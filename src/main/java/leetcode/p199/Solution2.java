package leetcode.p199;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            TreeNode cur = null;
            while (size > 0) {
                cur = list.poll();
                if (cur.left != null) {
                    list.add(cur.left);
                }
                if (cur.right != null) {
                    list.add(cur.right);
                }
                size--;
            }
            res.add(cur.val);
        }

        return res;
    }
}
