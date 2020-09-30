package leetcode.backtrack.p60;


import java.util.LinkedList;

/**
 * 获取第 K 个排列
 */
public class Solution {
    public String getPermutation(int n, int k) {
        k--;

        int[] factorial = new int[n + 1];
        factorial[0] = 1 ;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(list.remove(index));
            k -= index * factorial[i];
        }

        return sb.toString();
    }


}
