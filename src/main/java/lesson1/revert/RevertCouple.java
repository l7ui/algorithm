package lesson1.revert;

import lesson1.littlesum.Solution;

import java.util.ArrayList;

public class RevertCouple {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 2};
        solution(arr.clone());
        System.out.println(Solution.littleSum(arr));
    }

    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeProcess(arr, 0, arr.length-1);
        System.out.println(list);
    }

    public static void mergeProcess(int[] arr, int l, int h) {
        if (l == h) {
            return;
        }
        int m = l + ((h - l) >> 1);
        mergeProcess(arr, l, m);
        mergeProcess(arr, m+1, h);
        merge(arr, l, m, h);
    }

    public static void merge(int[] arr, int l, int m, int h) {
        int[] help = new int[h - l + 1];
        int p1 = l, p2 = m + 1;
        int i = 0;

        while (p1 <= m && p2 <= h) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                list.add(arr[p1] + ":" + arr[p2]);
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
    }


}
