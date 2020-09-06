package leetcode.p31;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int l = nums.length;
        int i = l - 2;
        // 1. 找到第一个升序对
        while (i >=0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = l - 1;
            // 2.1 找到第一个稍大于 nums[i] 的数 nums[j]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            if (j >= 0) {
                // 2.2 交换 nums[i] 和 nums[j]
                swap(nums, i, j);
            }
        }
        // 3. 反转 nums[i+1] 及其之后的数，保证其最小
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
