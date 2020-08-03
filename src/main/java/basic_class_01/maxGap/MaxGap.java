package basic_class_01.maxGap;

import java.util.Arrays;

// 求一个无序数组在排序后的最大的相邻数之差，复杂度要求O(n)
public class MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int len = nums.length;

        // 找到数组的最大值最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        if (max == min) {
            return 0;
        }

        // 创建len+1个桶，分别记录其是否为空、最大值、最小值
        boolean[] notEmpty = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int index;
        for (int i = 0; i < len; i++) {
            index = bucket(nums[i], len, max, min);
            maxs[index] = notEmpty[index] ? Math.max(maxs[index], nums[i]) : nums[i];
            mins[index] = notEmpty[index] ? Math.min(mins[index], nums[i]) : nums[i];
            notEmpty[index] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < len+1; i++) {
            if (notEmpty[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 计算num的桶下标
    private static int bucket(int num, int len, int max, int min) {
        return (num - min) * len / (max - min);
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
