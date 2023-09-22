package ru.parfenov.leetcode.easy;

import java.util.HashMap;
import java.util.stream.Stream;

public class FizzBuzzTest {

    public static final String FIZZBUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public byte[] fizzBuzz(int value) {

        StringBuilder sb = new StringBuilder();

        if (value % 3 == 0) sb.append(FIZZ);
        if (value % 5 == 0) sb.append(BUZZ);

        if (!sb.isEmpty()) return sb.toString().getBytes();

        throw new IllegalArgumentException("Error value");
    }

    public byte[] fizzBuzz2(int value) {
        if (value % 3 == 0) {
            if (value % 5 == 0) {
                return FIZZBUZZ.getBytes();
            }
            return FIZZ.getBytes();
        }
        if (value % 5 == 0) {
            return BUZZ.getBytes();
        }
        return null;
    }

    public boolean arraysAreTheSame(int[] array, int[] array2) {
        // Даны два массива int с одинаковым размером.
        // Написать алгоритм, который показывает, что массивы одинаковы

        if (array.length != array2.length) {
            System.out.println("Массивы не равны");
            return false;
        }

        HashMap<Integer, Integer> arr1 = new HashMap<>();
        for (int i : array) {
            if (arr1.containsKey(i)) {
                int j = arr1.get(i);
                arr1.put(i, ++j);
            } else {
                arr1.put(i, 1);
            }
        }

        boolean flag = true;
        for (int j : array2) {
            if (arr1.containsKey(j) && arr1.get(j) > 0) {
                int k = arr1.get(j);
                arr1.put(j, --k);
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Массивы равны");
            return true;
        } else {
            System.out.println("Массивы не равны");
            return false;
        }
    }

    public void p() {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }
}
