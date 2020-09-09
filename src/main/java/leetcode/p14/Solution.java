package leetcode.p14;

/**
 * 最长公共前缀
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String s = strs[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                boolean flag = i > strs[j - 1].length() - 1
                        || i > strs[j].length() - 1
                        || strs[j - 1].charAt(i) != strs[j].charAt(i);
                if (flag) {
                    return sb.toString();
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
