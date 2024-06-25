package ru.parfenov.leetcode.easy;

import java.util.Arrays;

public class PlusOne_66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                        plusOne(new int[] {1, 2, 3}))); // return -> [1, 2, 4]

        System.out.println(Arrays.toString(plusOne(new int[] {4, 3, 2, 1}))); // -> 4 3 2 2
        System.out.println(Arrays.toString(plusOne(new int[] {9}))); // -> 1 0
        System.out.println(Arrays.toString(plusOne(new int[] {9, 9, 9, 9, 9}))); // -> 1 0 0 0 0 0
        System.out.println(Arrays.toString(plusOne(new int[] {8, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[] {9, 9, 7, 9})));
        System.out.println(Arrays.toString(plusOne(new int[] {})));
    }

    public static int[] plusOne(int[] digits) {
        int lenArr = digits.length;
        for (int i = lenArr - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArray = new int[lenArr + 1];
        newArray[0] = 1;

        return newArray;
    }
}
