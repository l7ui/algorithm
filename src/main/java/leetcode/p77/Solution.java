package leetcode.p77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1-n 中的所有 k 个数的组合
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || n < k) {
            return res;
        }

        dfs(n, k, 1);
        return res;
    }

    public void dfs(int n, int k, int cur) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (cur > n + 1 - k) {
            return;
        }

        // 不选当前数，直接前往下一层递归
        dfs(n, k, cur + 1);

        // 选择当前数，剩余可选数 k - 1
        list.add(cur);
        dfs(n, k - 1, cur + 1);
        // 存在回溯，移除最后一个
        list.removeLast();
    }

}
