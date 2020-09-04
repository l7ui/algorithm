package leetcode.o34;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 解析路径和
     * @param root 根节点
     * @param sum 路径和
     * @return 路径和为sum的路径
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        recur(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right,sum);
        return res;
    }

    /**
     * 递归解析路径和
     * @param root 根节点
     * @param sum 路径和
     */
    public static void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, sum);
        recur(root.right, sum);
        path.removeLast();
    }

    /**
     * 获取二叉树
     * @param str 数组“[...]”
     * @return 树的根节点
     */
    public static TreeNode getTree(String str) {
        String[] parts = str.substring(1, str.length() - 1).split(",");
        String nodeVal = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (index == parts.length) {
                break;
            }

            nodeVal = parts[index++];
            nodeVal = nodeVal.trim();
            if (!nodeVal.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodeVal));
                queue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            nodeVal = parts[index++];
            nodeVal = nodeVal.trim();
            if (!nodeVal.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodeVal));
                queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 打印二叉树
     * @param root 树的根节点
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        String str = "[5,4,8,11,null,13,4,7,2, null,null,5,1,8,null,7,10,6,null,null,null]";
        int K = 35;

        TreeNode root = getTree(str);
        System.out.println("Pre-order recurve tree: ");
        printTree(root);

        List<List<Integer>> lists = pathSum(root, K);
        System.out.println("\nAvailable paths: ");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
