package leetcode.p105;

import leetcode.entity.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        int length = preorder.length;
        return build(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderIndexMap.get(root.val);
        int leftNodeCount = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftNodeCount,
                inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftNodeCount + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
