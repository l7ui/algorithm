package basic_class_01.sort;

import java.util.Arrays;

public class Comparator {
    public void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return false;
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value+1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }
}
