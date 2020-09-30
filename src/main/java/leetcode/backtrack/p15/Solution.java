package leetcode.backtrack.p15;

import java.util.*;

/**
 * 数组中三数之和为零的组合
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, path, 0, used, res);

        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, int begin, boolean[] used, List<List<Integer>> res) {
        if (path.size() == 3) {
            int sum = 0;
            for (int num : path) {
                sum += num;
            }
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, path, i + 1, used, res);
            used[i] = false;
            path.removeLast();
        }
    }
}
