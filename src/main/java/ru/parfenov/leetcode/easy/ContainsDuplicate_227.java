package ru.parfenov.leetcode.easy;

import java.util.HashSet;

// 217
public class ContainsDuplicate_227 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,2,3,1})); // true
        System.out.println(containsDuplicate(new int[] {1,2,3,4})); // false
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2})); // true
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
