package ru.parfenov.leetcode.easy;

import java.lang.reflect.Field;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BestTimeToBuy {

    // Наивный алгоритм
    public static int maxProfit(int[] prices) {
        int answer = 0; // ответ
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j]- prices[i] > answer) {
                    answer = max(answer, prices[j] - prices[i]);
                }
            }
        }
        return answer;
    }

    public static int maxProfit2(int[] prices) {
        int ans = 0;
        int prevMin = Integer.MAX_VALUE;
        for (int v : prices) {
            ans = max(ans, v - prevMin);
            prevMin = min(prevMin, v);
        }
        return ans;
    }
}
