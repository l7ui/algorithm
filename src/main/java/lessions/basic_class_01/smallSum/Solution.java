package lessions.basic_class_01.smallSum;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 6};
        System.out.println(littleSum(arr));
    }

    public static int littleSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeProcess(arr, 0, arr.length-1);
    }

    public static int mergeProcess(int[] arr, int l, int h) {
        if (l == h) {
            return 0;
        }
        int m = l + ((h - l) >> 1);
        return mergeProcess(arr, l, m)
                + mergeProcess(arr, m+1, h)
                + merge(arr, l, m, h);
    }

    public static int merge(int[] arr, int l, int m, int h) {
        int[] help = new int[h - l + 1];
        int p1 = l, p2 = m + 1;
        int i = 0;
        int sum = 0;

        while (p1 <= m && p2 <= h) {
            if (arr[p1] < arr[p2]) {
                sum += (h - p2 + 1) * arr[p1];
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= h) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }

        return sum;
    }
}
