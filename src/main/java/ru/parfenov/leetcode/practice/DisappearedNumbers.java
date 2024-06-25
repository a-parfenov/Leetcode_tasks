package ru.parfenov.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    /**
     * дан неотсортированный массив из N чисел от 1 до N,
     * при этом несколько чисел из диапазона [1, N] пропущено,
     * а некоторые присутствуют дважды.
     * Найти все пропущенные числа без использования дополнительной памяти.
     * assert findDisappearedNumbers([5, 2, 3, 7, 2, 1, 5]) == [4, 6]
     * @return [4, 6]
     */

    // решение кривое
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 7, 2, 1, 9};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);

        System.out.println(disappearedNumbers); // Вывод: [4, 6]
    }
}
