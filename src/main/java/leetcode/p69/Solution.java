package leetcode.p69;

/**
 * 平方根
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int C = x;
        double x0 = x;
        while (true) {
            double xi = (x0 + C / x0) / 2;
            if (Math.abs(xi - x0) < 1e-7) {
                return (int) xi;
            }
            x0 = xi;
        }
    }
}
