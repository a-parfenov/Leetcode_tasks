package ru.parfenov.leetcode.easy;

import java.util.HashMap;

// 242
public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false
        System.out.println(isAnagram("aacc", "ccac")); // false
    }

    public static boolean isAnagram(String s, String t) {
        char[] sArrChar = s.toCharArray();
        char[] tArrChar = t.toCharArray();
        if (sArrChar.length != tArrChar.length) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char value : sArrChar) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        for (char value : tArrChar) {
            if (map.containsKey(value)) {
                map.put(value, map.getOrDefault(value, 0) - 1);
            } else {
                return false;
            }
        }
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
