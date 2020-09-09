package leetcode.p347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,  0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        int[] res = new int[k];
        int size = list.size();
        for (int i = size - 1; i > size - k - 1; i--) {
            res[size - 1 - i] = list.get(i).getKey();
        }

        return res;
    }
}
