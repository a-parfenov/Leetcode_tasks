package ru.parfenov.leetcode.interviews;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    /**
     * Напишите функцию "findMedian" для нахождения медианы объединенного списка,
     * содержащего все элементы из 'listI' n 'list2
     * Медианой списка является центральный элемент списка
     */
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6, 8);
        List<Integer> list3 = List.of(1, 2);
        List<Integer> list4 = List.of(3, 4);

        double median = findMedian(list1, list2); // Медиана: 4.0 => ([1, 3, 5][2, 4, 6, 8])
        double median2 = findMedian(list3, list4); // Медиана: 2.5 => ([1, 2][3, 4])
        System.out.println("Медиана: " + median + " => (" + list1.toString() + list2.toString() + ")");
        System.out.println("Медиана: " + median2 + " => (" + list3.toString() + list4.toString() + ")");
    }

    public static double findMedian(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                resultList.add(list1.get(i++));
            } else {
                resultList.add(list2.get(j++));
            }
        }

        while (i < list1.size()) {
            resultList.add(list1.get(i++));
        }
        while (j < list2.size()) {
            resultList.add(list2.get(j++));
        }

        int totalElement = resultList.size();
        if (totalElement % 2 != 0) {
            return resultList.get(totalElement / 2);
        } else {
            int mid1 = totalElement / 2 - 1;
            int mid2 = totalElement / 2;
            return (resultList.get(mid1) + resultList.get(mid2)) / 2.0;
        }
    }
}
