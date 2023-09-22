package ru.parfenov.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Module_1_2 {
//      array = [3, 8, 15, 17], Number = 23
//      result = [1,2]

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(indexArray2(new int[]{3, 8, 15, 17}, 23)));

//        System.out.println(containsDuplicate(new int[] {4,5,6,6,8}));
//        System.out.println(containsDuplicate(new int[] {4,5,6,8}));

        List<String> list = new ArrayList<>();
        list.add("asdsda1 daw");
        list.add("hbh nd2");
        list.add("danjh3");
        list.add("oijh4");
        list.add("wds5");

        String n  = "asdsda1 daw ";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            if (!map.containsKey(n.charAt(i))) {
                map.put(n.charAt(i), 1);
            } else {
                int x = map.get(n.charAt(i)) + 1;
                map.put(n.charAt(i), x);
            }
        }
        System.out.println(map);

    }

    public static int[] indexArray(int[] array, int number) {
        int i = 0;
        while(i != array.length-1) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    return new int[] {i, j};
                }
            }
            i++;
        }

        return new int[]{};
    }

//    public static int[] indexArray2(int[] array, int number) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(number - array[i])) {
//                return new int[] {map.get(number - array[i]), i};
//            }
//            map.put(array[i], i);
//        }
//
//        return new int[] {};
//    }


    //Array: [c]
    //Result: true
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
