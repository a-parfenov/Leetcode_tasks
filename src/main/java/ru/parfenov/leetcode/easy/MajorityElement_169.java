package ru.parfenov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    // найти основной элемент (элемент большинства, мажоритарный)
    public static void main(String[] args) {
        System.out.println(majorityElement3(new int[]{3,2,3})); // 3
        System.out.println(majorityElement3(new int[]{2,2,1,1,1,2,2})); // 2
    }

    public static int majorityElement3(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            count += num == result ? 1 : -1;
        }
        return result;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int result = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > maxCount) {
                result = n;
                maxCount = map.get(n);
            }
        }
        return result;
    }
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (num != result) {
                if (count == 0) {
                    result = num;
                    count++;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        return result;
    }

}
