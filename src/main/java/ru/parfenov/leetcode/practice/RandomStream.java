package ru.parfenov.leetcode.practice;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class RandomStream {

    // 13 -->
    // 13, 16, 25, 62, 384, 745, 502, 200, 0
    public IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) / 10 % 1000).limit(9);
    }
}
