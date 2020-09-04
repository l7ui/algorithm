package leetcode.p105;

import leetcode.entity.TreeNode;

import java.util.HashMap;

public class Solution2 {
    private int[] preorder;
    private HashMap<Integer, Integer> inNodeIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        int length = preorder.length;

        for (int i = 0; i < length; i++) {
            inNodeIndexMap.put(inorder[i], i);
        }

        return build(0, length - 1, 0, length - 1);
    }

    public TreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preL]);
        int inRootIndex = inNodeIndexMap.get(root.val);
        int inNodeCount = inRootIndex - inL;

        root.left = build(preL + 1, preL + inNodeCount, inL, inRootIndex - 1);
        root.right = build(preL + 1 + inNodeCount, preR, inRootIndex + 1, inR);

        return root;
    }
}
