package leetcode.o0107;

/**
 * 90度顺时针旋转矩阵
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;

        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (up < down) {
            int r1 = up, c1 = left, r2 = up, c2 = right;
            int r3 = down, c3 = right, r4 = down, c4 = left;
            while (c1 < right && r4 > up && r2 < down && c3 > up) {
                swap(matrix, r1, c1, r2, c2);
                swap(matrix, r1, c1, r3, c3);
                swap(matrix, r1, c1, r4, c4);
                c1++;
                r4--;
                r2++;
                c3--;
            }
            up++;
            down--;
            left++;
            right--;
        }
    }

    public void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
