package ru.parfenov.leetcode.easy;

public class FibonacciValue_509 {
    public static void main(String[] args) {
        // 1 1 2 3 5 8 13
        // 6 -> 8, 7 -> 13

        System.out.println(getFibonacciValue2(6)); // 8
        System.out.println(getFibonacciValue2(7)); // 13
        System.out.println(getFibonacciValue2(10)); // 55
        System.out.println(getFibonacciValue2(3));
        System.out.println(getFibonacciValue2(0));
        System.out.println(getFibonacciValue2(2));

    }

    public static int getFibonacciValue1(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return getFibonacciValue1(num - 1) + getFibonacciValue1(num - 2);
        }
    }

    public static int getFibonacciValue2(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < num; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[num-1];
    }

}