package ru.parfenov.leetcode.interviews;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class LongestUniqueSubarray {

    // Найти длину самой длинной подпоследовательности, без повторяющихся элементов
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 3, 4, 3, 5, 6, 3, 2, 1, 7, 8, 9, 7};
        int result = lengthOfLongestSubstring(nums);
        System.out.println(result);
        Stream.of("d2", "ga2", "b1", "ab3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }

    @Data
    public class Person {
        private String name;
        private int age;
    }

    @Data
    public class Room {
        private int number;
        private List<Person> persons;
    }

    // Найти любую комнату, в которой есть человек с возрастом меньше чем minAge, и вывести её номер.
    public int findRoom(List<Room> rooms, int minAge) {
        return rooms.stream()
                .filter(room -> room.persons.stream()
                        .anyMatch(person -> person.age < minAge))
                .findFirst()
                .map(Room::getNumber)
                .orElse(-1);
    }


    public static int lengthOfLongestSubstring(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length) {
            // Пытаемся добавить текущий элемент в набор
            if (!set.contains(nums[j])) {
                set.add(nums[j++]);
                maxLength = Math.max(maxLength, j - i);
            } else {
                // Если элемент уже есть в наборе, удаляем первый элемент из набора и сдвигаем левую границу окна
                set.remove(nums[i++]);
            }
        }
        return maxLength;
    }
}
