package leetcode.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res, new StringBuilder(), 0, digits, map);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, int index, String digits, Map<Character, String> map) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            char c = digits.charAt(index);
            String letters = map.get(c);
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(res, sb, index + 1, digits, map);
                sb.deleteCharAt(index);
            }
        }
    }
}
