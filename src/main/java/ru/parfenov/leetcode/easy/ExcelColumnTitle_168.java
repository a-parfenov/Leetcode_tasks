package ru.parfenov.leetcode.easy;

public class ExcelColumnTitle_168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));  // Output: "A"
        System.out.println(convertToTitle(28));  // Output: "AB"
        System.out.println(convertToTitle(701));  // Output: "ZY"
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) ('A' + columnNumber % 26);
            sb.insert(0, ch);
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
