package leetcode.sort.p88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int p1 = 0, p2 = 0, i = 0;
        while (p1 < m && p2 < n) {
            if (temp[p1] < nums2[p2]) {
                nums1[i++] = temp[p1++];
            } else {
                nums1[i++] = nums2[p2++];
            }
        }

        while (p1 < m) {
            nums1[i++] = temp[p1++];
        }
        while (p2 < n) {
            nums1[i++] = nums2[p2++];
        }
    }
}
