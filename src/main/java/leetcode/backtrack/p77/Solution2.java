package leetcode.backtrack.p77;

import java.util.*;

/**
 * 从 1 - n 中选择 k 个数的所有组合
 */
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    /**
     *
     * @param n n 个数
     * @param k 选择 k 个数
     * @param begin 状态变量：可选范围 [begin, n - k + 1]
     * @param path 状态变量：路径
     * @param res 结果
     */
    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 注意：还需要选择 k 个数，因此 i 最多到 n - k + 1
        for (int i = begin; i <= n - k + 1; i++) {
            path.addLast(i);
            dfs(n, k - 1, i + 1, path, res);
            path.removeLast();
        }
    }
}
