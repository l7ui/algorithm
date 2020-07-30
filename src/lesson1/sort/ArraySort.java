package lesson1.sort;

import java.util.*;

class ArraySort {
    public static void main(String[] args) {
        int testTime = 100000;
        int size = 100;
        int value = 100;
        boolean flag = true;
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            rightMethod(arr2);
//            selection(arr3);
//             bubble(arr3);
//             insert(arr3);
//             shell(arr3);
             mergeSort(arr3);
//            quickSort(arr3, 0, arr3.length-1);
//             System.out.println("-------begin-------");
//             System.out.println(Arrays.toString(arr1));
//             System.out.println(Arrays.toString(arr2));
//             System.out.println(Arrays.toString(arr3));
            if (!isEqual(arr2, arr3)) {
                flag = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(flag ? "success!" : "error---");
        System.out.println("Runtime: " + (end - start));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return false;
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    private static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value+1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    // select the minmum and swap it with the first one
    public static void selection(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    // bubble the larger number to the tail
    public static void bubble(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        boolean hasSorted = true;
        for (int i = arr.length-1; i > 0 && hasSorted; i--) {
            hasSorted = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    hasSorted = true;
                }
            }
        }
    }

    // insert the number behind into the sorted array
    public static void insert(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr,j, j-1);
            }
        }
    }

    // set the gap equals h where h equals thirds of the array
    public static void shell(int[] arr) {

    }

    // split to two parts and merge them sortly
    public static void merge(int[] arr, int l, int m, int h) {
        int[] help = new int[h - l + 1];
        int p1 = l, p2 = m + 1;
        int i = 0;

        while (p1 <= m && p2 <= h) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
    public static void mergeProcess(int[] arr, int l, int h) {
        if (l == h) {
            return;
        }
        int m = l + ((h - l) >> 1);
        mergeProcess(arr, l, m);
        mergeProcess(arr, m+1, h);
        merge(arr, l, m, h);
    }
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeProcess(arr,0, arr.length-1);
    }

    // dig a hole and find a number to fill it
    public static int partition(int[] arr, int l, int h) {
        return 0;
    }
    public static void quickSort(int[] arr, int l, int h) {

    }
}
