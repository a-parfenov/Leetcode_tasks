package ru.parfenov.leetcode.easy;

public class SubStr {
    public static void main(String[] args) {
        // поиск индекса начала подстроки
        System.out.println(subStr("asadbutsad", "sad")); // 1
        System.out.println(subStr("leetcode", "leeto")); // -1
        System.out.println(subStr("mississippi", "issip")); // 4
    }

    public static int subStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needleLen = needle.length();


        if (hayLen - needleLen < 0) {
            return -1;
        }

        for (int i = 0; i <= hayLen - needleLen; i++) {
            int j = 0;
            while (j < needleLen && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == needleLen) {
                return i;
            }
        }

        return -1;
    }

}
