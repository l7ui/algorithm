package leetcode.p518;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        String[] a = new String[] { "1"};
        List list = Arrays.asList(a);
        list.clear();
        list.add(3);
        System.out.println(list);
    }
}
