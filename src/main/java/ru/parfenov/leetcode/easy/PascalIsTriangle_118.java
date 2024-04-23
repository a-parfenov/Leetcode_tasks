package ru.parfenov.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalIsTriangle_118 {

    /*
    * Input: numRows = 5
    * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    * */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> newRow = new ArrayList<>();
        if (numRows == 1) {
            newRow.add(List.of(1));
            return newRow;
        }

        for (int i = 1; i < numRows; i++) {
            newRow.add(List.of());
        }
        System.out.println(newRow);

        for (int i = 1; i < numRows; i++) {

        }

        return null;
    }
}
