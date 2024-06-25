package ru.parfenov.leetcode.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber_136 {

    /**
     * Учитывая непустой массив целых чисел nums, каждый элемент появляется дважды, кроме одного.
     * Найдите это единственное число.

     * Еще один вариант посчета элементов в массиве:
     * Map<Integer, Integer> map2 = new HashMap<>();
     * Arrays.stream(nums).forEach(num -> map2.merge(num, 1, Integer::sum));
     */
    public static void main(String[] args) {
        List<int[]> list = getInts();

        for (int i = 1; i < list.size(); i++) {
            System.out.println("Тест " + i + ", метод 1: " + findFirstUniqueElement1(list.get(i - 1)));
            System.out.println("Тест " + i + ", метод 2: " + findFirstUniqueElement2(list.get(i - 1)));
            System.out.println("Тест " + i + ", метод 3: " + findFirstUniqueElement3(list.get(i - 1)));
            System.out.println("Тест " + i + ", метод 4: " + singleNumber(list.get(i - 1)));
            System.out.println();
        }
    }

    private static List<int[]> getInts() {
        int[] arr1 = {9, 4, 9, 5, 4, 5}; // -1
        int[] arr2 = {9, 4, 0, 9, 6, 7, 4, 5, 0, 6, 6, 8}; // 7
        int[] arr3 = {0, 0, -7, -7, -8, 1, 2, 5, 3, 1, 2, -8}; // 5
        int[] arr4 = {2, 2, 1}; // 1
        int[] arr5 = {4, 1, 2, 1, 2}; // 4
        int[] arr6 = {9};
        int[] arr7 = new int[]{};

        List<int[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        list.add(arr6);
        list.add(arr7);
        return list;
    }

    public static int findFirstUniqueElement1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
//        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
//            if (entry.getValue() ==  1) {
//                return entry.getKey();
//            }
//        }
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static int findFirstUniqueElement2(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> Arrays.stream(arr)
                        .filter(innerNum -> innerNum == num)
                        .count() == 1)
                .findFirst()
                .orElse(-1);
    }

    private static int findFirstUniqueElement3(int[] arr) {
        LinkedHashMap<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return map.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    // кривое дерьмо, но проходит на литкоде и выдает топ время
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
