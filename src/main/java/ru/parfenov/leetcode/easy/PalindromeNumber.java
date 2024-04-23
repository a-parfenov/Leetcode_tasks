package ru.parfenov.leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(12321)); // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10)); // false

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int temp = x;
        while (temp > 0) {
            int digit = temp % 10;
            result = result * 10 + digit;
            temp = temp / 10;
        }

        return result == x;
    }
}
