package ru.parfenov.leetcode.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingLetters {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("коля", "петя", "маша");
        items.stream()
                .flatMap(i -> Arrays.stream(i.split("")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((x, y) -> System.out.println(x + " " + y));
    }
}
