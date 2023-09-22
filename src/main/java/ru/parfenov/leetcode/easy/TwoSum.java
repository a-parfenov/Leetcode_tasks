package ru.parfenov.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9))); // 0 1
        System.out.println(Arrays.toString(twoSum2(new int[]{3,2,4}, 6))); // 1 2
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6))); // 0 1
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 7)));  // []
    }

    public static int[] twoSum(int[] nums, int target) {
//        if (nums.length == 0 || target < 0) {
//            return -1;
//        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSum2(int[] array, int number) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(number - array[i])) {
                return new int[] {map.get(number - array[i]), i};
            }
            map.put(array[i], i);
        }

        return new int[] {};
    }
}
