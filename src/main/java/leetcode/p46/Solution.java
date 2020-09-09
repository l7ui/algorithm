package leetcode.p46;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int level) {
        if (level == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backtrack(nums, level + 1);
            swap(nums, i, level);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
