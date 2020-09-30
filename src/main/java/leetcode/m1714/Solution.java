package leetcode.m1714;

/**
 * top K
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int i = partition(arr, l, h);
            if (i < k) {
                l = i + 1;
            } else if (i > k) {
                h = i - 1;
            } else {
                int[] res = new int[k];
                System.arraycopy(arr, 0, res, 0, res.length);
                return res;
            }
        }
        return new int[0];
    }

    public int partition(int[] arr, int l, int h) {
        int i = l, j = h, x = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = x;
        return i;
    }
}
