package leetcode.backtrack.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int p = 0; p < nums.length - 2; p++) {
            if (nums[p] > 0) {
                break;
            }
            if (p > 0 && nums[p - 1] == nums[p]) {
                continue;
            }

            int i = p + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[p] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum == 0){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[p], nums[i], nums[j]));
                    res.add(list);

                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }

        return res;
    }
}
