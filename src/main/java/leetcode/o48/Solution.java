package leetcode.o48;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(c + "");
            if (index != -1) {
                if (index + 1 < sb.length()) {
                    sb = new StringBuilder(sb.substring(index + 1));
                } else {
                    sb = new StringBuilder();
                }
            }
            sb.append(c);
            maxLength = Math.max(maxLength, sb.length());
        }
        return maxLength;
    }
}
