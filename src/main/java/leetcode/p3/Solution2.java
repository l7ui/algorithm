package leetcode.p3;

import java.util.HashSet;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!set.isEmpty()) {
                set.remove(s.charAt(i - 1));
            }

            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }

            maxLength = Math.max(maxLength, right - i + 1);
        }

        return maxLength;
    }
}
