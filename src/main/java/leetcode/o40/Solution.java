package leetcode.o40;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == arr.length) {
            return arr;
        }
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int i = partition(arr, l, h);
            if (i > k) {
                h = i - 1;
            } else if (i < k) {
                l = i + 1;
            } else if (i == k) {
                int[] res = new int[k];
                System.arraycopy(arr, 0, res, 0, k);
                return res;
            }
        }
        return new int[0];
    }

    public int partition(int[] arr, int l, int h) {
        int i = l, j = h;
        int x = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        arr[j] = x;
        return j;
    }

}
