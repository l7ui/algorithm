package leetcode.backtrack.p90;

import java.util.*;

/**
 * 含重复数字的子集
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len,0, path,res);
        return res;
    }

    public void dfs(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = begin; i < len; i++) {
            if (i > begin && nums[i - 1] == nums[i]) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums, len, i + 1, path, res);
            path.removeLast();
        }
    }
}
