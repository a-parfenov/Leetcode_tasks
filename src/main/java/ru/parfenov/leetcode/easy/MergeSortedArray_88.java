package ru.parfenov.leetcode.easy;

import java.util.Arrays;

// 88
public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        merge2(arr1, 3, new int[]{2,5,6}, 3);
        System.out.println("arr1=" + Arrays.toString(arr1)); // [1,2,2,3,5,6]

        int[] arr2 = new int[]{1};
        merge2(arr2, 1, new int[]{}, 0);
        System.out.println("arr2=" + Arrays.toString(arr2)); // [1]
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i++] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
