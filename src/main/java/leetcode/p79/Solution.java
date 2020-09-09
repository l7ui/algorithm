package leetcode.p79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        this.word = word;
        this.board = board;
        r = board.length;
        c = board[0].length;
        hasVis = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(i, j, 0);
                }
                if (exist) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist;
    private String word;
    private char[][] board;
    private int r, c;
    private boolean[][] hasVis;
    public void dfs(int i, int j, int index) {
        int r = board.length, c = board[0].length;
        boolean flag = exist || i < 0 || i >= r || j < 0 || j >= c || hasVis[i][j] || board[i][j] != word.charAt(index);
        if (flag) {
            return;
        }
        if (index == word.length() - 1) {
            exist = true;
            return;
        }
        hasVis[i][j] = true;
        dfs(i + 1, j, index + 1);
        dfs(i - 1, j, index + 1);
        dfs(i, j + 1, index + 1);
        dfs(i, j - 1, index + 1);
        hasVis[i][j] = false;
    }
}
