package leetcode.dynamicprocess.p300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];

        int len = 0;
        for (int num : nums) {
            int i = 0, j = len;
            while (i < j) {
                int m = i + (j - i) / 2;
                if (temp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            temp[i] = num;
            if (len == j) j++;
        }

        return len;
    }
}
