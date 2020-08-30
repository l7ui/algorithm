package leetcode.p214;

class Solution {
    public static void main(String[] args) {
        String s = "aacecaaa";
        shortestPalindrome(s);
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = countPalindrome(s, i);
            if (count > max) {
                max = count;
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (index + max != s.length()) {
            sb.append(s.substring(index + 1));
            sb.reverse();
            sb.append(s.substring(index));
        } else {
            sb.append(s.substring(0, index));
            sb.reverse();
            sb.append(s.substring(index, index + max));
        }
        return sb.toString();
    }

    public static int countPalindrome(String s, int index) {
        int i = index - 1, j = index + 1;
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return count;
            }
            count++;
            i--;
            j++;
        }
        return count;
    }
}
