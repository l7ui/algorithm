package leetcode.p47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, used, 0, path, res);
        return res;
    }

    /**
     *
     * param nums 原数组
     * @param len 原数组的长度
     * @param used 状态量：是否已经使用
     * @param depth 状态量：深度
     * @param path 状态量：路径
     * @param res 结果
     */
    private void dfs(int[] nums, int len, boolean[] used, int depth, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝：遇到重复的数字且处于同一层（used[i-1]为false）时剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, len, used, depth + 1, path, res);
            used[i] = false;
            path.removeLast();
        }
    }
}
