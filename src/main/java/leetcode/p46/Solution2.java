package leetcode.p46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    /**
     * @param nums  原数组
     * @param len   原数组长度
     * @param depth 状态变量：深度
     * @param used  状态变量：元素是否已使用
     * @param path  状态变量：路径
     * @param res   结果
     */
    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子节点处选择一条分支：通过遍历数组实现
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            // 回溯：状态变量逆操作
            used[i] = false;
            path.removeLast();
        }
    }
}
