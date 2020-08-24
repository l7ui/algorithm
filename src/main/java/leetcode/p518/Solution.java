package leetcode.p518;

// https://leetcode-cn.com/problems/coin-change-2/
public class Solution {
    public int change(int amount, int[] coins) {
        int k = coins.length + 1;
        int[][] dp = new int[k][amount + 1];

        for (int i = 0; i < k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[k - 1][amount];
    }
}
