package leetcode.p39;

import java.util.*;

/**
 * 数组中和为 target 的组合总数，数组中元素可以重复调用：回溯算法
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, 0,  target, path, res);
        return res;
    }

    /**
     *
     * @param candidates 原数组
     * @param len 原数组的长度
     * @param begin 状态量：索引的范围 [begin, len)
     * @param target 状态量：目标值
     * @param path 状态量：路径
     * @param res 结果
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 何时使用 begin， 何时使用 used？
        // 排列时使用 used, 组合时使用 begin
        for (int i = begin; i < len; i++) {
            if (target < candidates[i]) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
