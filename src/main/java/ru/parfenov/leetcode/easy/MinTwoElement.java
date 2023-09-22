package ru.parfenov.leetcode.easy;

public class MinTwoElement {
    public static void main(String[] args) {
        int [] array = new int[] {64, 42, 73, 41, 32, 53, 16, 7, 24, 57, 42, 74, 55, 36};
        int [] array2 = new int[] {1, 1,1,1,1};

        minTwoElement(array);
        minTwoElement(array2);
    }
    public static void minTwoElement(int[] array) {
        // Найти второй по минимальности элемент

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int j : array) {
            if (j < min) {
                min2 = min;
                min = j;
            }
            if (j < min2 && j != min) {
                min2 = j;
            }
        }
        if (min2 != Integer.MAX_VALUE) {
            System.out.println("Минимальный: " + min);
            System.out.println("Второй минимальный: " + min2);
        } else {
            System.out.println("Минимальный: " + min);
            System.out.println("Второй минимальный: Не найден");
        }

    }

}
