package leetcode.dynamicprocess.p122;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash, preHold = hold;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preHold = hold;
            preCash = cash;
        }

        return cash;
    }
}
