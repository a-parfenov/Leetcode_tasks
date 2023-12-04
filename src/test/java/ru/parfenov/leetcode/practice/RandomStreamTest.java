package ru.parfenov.leetcode.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.parfenov.leetcode.practice.RandomStream;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class RandomStreamTest {

    @Autowired
    private RandomStream randomStream;

    @Test
    void pseudoRandomStream() {
        int[] actual = new int[] {13, 16, 25, 62, 384, 745, 502, 200, 0};
        int[] expected = randomStream.pseudoRandomStream(13).toArray();
        assertArrayEquals(expected, actual, "Массивы не идентичны");

        Arrays.stream(actual).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(expected).forEach(n -> System.out.print(n + " "));
    }

    @Test
    void t() {
        System.out.println(false==false);

    }
}