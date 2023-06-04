package lessions.tree;

import leetcode.entity.TreeNode;

public class LastNodeOfInOrder {
    public TreeNode solution(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
