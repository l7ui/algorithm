package leetcode.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的最长的无重复字符子串
 * <滑动窗口>
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0; // left 记录滑动窗口的左边界
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}
