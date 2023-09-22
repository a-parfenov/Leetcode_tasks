package ru.parfenov.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyTest {

    @Test
    void maxProfit_1() {
        assertEquals(BestTimeToBuy.maxProfit(new int[] {7,1,5,3,6,4}), 5);
    }

    @Test
    void maxProfit_2() {
        assertEquals(BestTimeToBuy.maxProfit(new int[] {7,6,4,3,1}), 0);
    }

    @Test
    void maxProfit2_1() {
        assertEquals(BestTimeToBuy.maxProfit2(new int[] {7,1,5,3,6,4}), 5);
    }

    @Test
    void maxProfit2_2() {
        assertEquals(BestTimeToBuy.maxProfit2(new int[] {7,6,4,3,1}), 0);
    }
}