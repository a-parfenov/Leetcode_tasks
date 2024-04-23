package ru.parfenov.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalIsTriangle_118Test {

    @Test
    void generateOne() {
        List<List<Integer>> newRow = new ArrayList<>();
        newRow.add(List.of(1));

        assertEquals(PascalIsTriangle_118.generate(1), newRow);
    }
}