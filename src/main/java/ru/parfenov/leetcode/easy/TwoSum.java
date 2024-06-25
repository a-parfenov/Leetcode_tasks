package ru.parfenov.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // 0 1
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6))); // 1 2
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6))); // 0 1
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 7)));  // []
    }

    /**
     * Найти индексы двух чисел которые дадут в сумме заданное значение
     * Input: nums = [2, 7, 11, 15], target = 9
     * Output: [0, 1]
     */

    public static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[] {map.get(target - array[i]), i};
            }
            map.put(array[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
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
}
