package ru.parfenov.leetcode.interviews;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqueElement {
    // Найти первый неповторяющийся элемент в массиве целых чисел
    public static void main(String[] args) {
        int[] arr1 = {9, 4, 9, 5, 4, 5};
        int[] arr2 = {9, 4, 9, 6, 7, 4, 5};

        System.out.println("Первый неповторяющийся элемент, 1 вар: " + findFirstUniqueElement1(arr1));
        System.out.println("Первый неповторяющийся элемент, 1 вар: " + findFirstUniqueElement1(arr2));
        System.out.println("Первый неповторяющийся элемент, 3 вар: " + findFirstUniqueElement3(arr1));
        System.out.println("Первый неповторяющийся элемент, 3 вар: " + findFirstUniqueElement3(arr2));
        System.out.println("Первый неповторяющийся элемент, 4 вар: " + findFirstUniqueElement4(arr1));
        System.out.println("Первый неповторяющийся элемент, 4 вар: " + findFirstUniqueElement4(arr2));
    }

    public static int findFirstUniqueElement4(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> Arrays.stream(arr)
                        .filter(innerNum -> innerNum == num)
                        .count() == 1)
                .findFirst()
                .orElse(-1);
    }

    public static int findFirstUniqueElement3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return arr[i];
            }
        }
        return -1; // Если неповторяющийся элемент не найден
    }

    public static int findFirstUniqueElement1(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(el ->
                map.put(el, map.get(el) != null ? map.get(el) + 1 : 1) );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}