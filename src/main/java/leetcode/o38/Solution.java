package leetcode.o38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串的全排列（去重）
 */
public class Solution {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        backtrack(chars, 0);
        return res.toArray(new String[res.size()]);
    }

    private List<String> res = new ArrayList<>();
    public void backtrack(char[] chars, int level) {
        if (level == chars.length - 1) {
            res.add(String.valueOf(chars));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = level; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, level);
            backtrack(chars, level + 1);
            swap(chars, i, level);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
