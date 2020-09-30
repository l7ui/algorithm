package leetcode.backtrack.p60;

/**
 * 1 - n 组成的排列的字典序第 k 个排列
 */
public class Solution2 {
    private int[] factorial;

    public String getPermutation(int n, int k) {
        if (n < 1 || k < 1) {
            return "";
        }

        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[n + 1];

        factorial(n);
        dfs(n, k, 0, used, path, factorial);

        return path.toString();
    }

    /**
     *
     * @param n 1 - n
     * @param k 第 k 个排列
     * @param depth 状态量：dfs深度
     * @param used 状态量：是否使用过
     * @param path 状态量：路径
     * @param factorial 辅助数组：阶乘的结果数组
     */
    private void dfs(int n, int k, int depth, boolean[] used, StringBuilder path, int[] factorial) {
        if (depth == n) {
            return;
        }


        int cnt = factorial[n - depth - 1];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝：找到第 k 个排列所在的范围
            if (k - cnt > 0) {
                k -= cnt;
                continue;
            }

            used[i] = true;
            path.append(i);
            dfs(n, k, depth + 1, used, path, factorial);
            // 直接到叶子节点，不需要回溯
            return;
        }
    }

    public void factorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
