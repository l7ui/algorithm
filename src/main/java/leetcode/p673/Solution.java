package leetcode.p673;


/**
 * 最长上升子序列的个数
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            count[i] = 1;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }

        return res;
    }
}
