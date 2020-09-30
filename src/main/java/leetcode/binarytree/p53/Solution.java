package leetcode.binarytree.p53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE, thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (thisSum < 0) {
                thisSum = 0;
            }
            thisSum += nums[i];
            max = Math.max(max, thisSum);
        }

        return max;
    }
}
