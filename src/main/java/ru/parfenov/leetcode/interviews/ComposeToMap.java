package ru.parfenov.leetcode.interviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class ComposeToMap {

    public static void main(String... args) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        arrayList.add(new Pair("1", 1));
        arrayList.add(new Pair("2", 2));
        arrayList.add(new Pair("3", 3));

        Map<String, Pair> result = composeToMap(arrayList);
        System.out.println(result.toString());
    }

    public static Map<String, Pair> composeToMap(Collection<Pair> input) {
        return input.stream()
                .collect(Collectors.toMap(Pair::getKey, pair -> pair));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class Pair {
        String key;
        int value;
    }

}
