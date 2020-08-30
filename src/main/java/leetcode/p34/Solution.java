package leetcode.p34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = binaryFind(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        int right = binaryFind(nums, target, false) - 1;
        res[0] = left;
        res[1] = right;
        return res;
    }

    public int binaryFind(int[] nums, int target, boolean left) {
        int l = 0, h = nums.length - 1;
        // <= : [l, h] < : [l, h)
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] > target || (left && nums[m] == target)) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
