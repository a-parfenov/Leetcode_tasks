package ru.parfenov.leetcode.interviews;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 6, 6, 8, 8, 8, 8};
        int[] arr2 = {1, 1, 2}; // возвращает кол-во уникальных элементов -> 2 -> [1, 2]

        System.out.println(removeDuplicates(arr1));
        System.out.println(removeDuplicates(arr2));
        System.out.println(removeDuplicates(new int[] {1, 1, 1}));
        System.out.println(removeDuplicates(new int[] {}));

        System.out.println();
        System.out.println(removeDuplicates2(arr1));
        System.out.println(removeDuplicates2(arr2));
    }

    public static int removeDuplicates(int[] nums) {
        int[] newArray = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(newArray));
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }
        return k; // кол-во уникальных элементов
    }

    public static int removeDuplicates2(int[] arr) {
        return Arrays.stream(arr).distinct().toArray().length;
    }

}
