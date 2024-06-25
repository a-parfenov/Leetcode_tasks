package ru.parfenov.leetcode.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Расчет скользящего среднего
 * Пример:
 * MovingAverage ma = new MovingAverage(3);
 * ma.next(1); // -> 1
 * ma.next(2); // -> 1,5
 * ma.next(3); // -> 2
 * ma.next(4); // -> 3

 * Метод next ->
 * 1. Когда метод next вызывается с новым значением val, он проверяет, достиг ли размер окна максимального значения.
 * Если размер окна уже равен максимальному, то самое старое значение извлекается из окна.
 * 2. Затем новое значение val добавляется в окно, и сумма значений в окне обновляется путем добавления val.
 * 3. Наконец, метод возвращает среднее значение для текущего окна, которое рассчитывается как общая сумма
 * всех значений в окне, деленная на количество значений в окне.
 * Таким образом, метод next обеспечивает обновление окна и вычисление скользящего среднего при добавлении новых значений.
 */

public class MovingAverage {

    public final int size;
    private final List<Integer> window; // Можно использовать Queue<Integer> -> ArrayDeque<>()
    private int sumWindow; // Сумма значений в массиве

    public MovingAverage(int size) {
        this.window = new ArrayList<>();
        this.size = size;
        this.sumWindow = 0;
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1)); // -> 1.0
        System.out.println(ma.next(2)); // -> 1.5
        System.out.println(ma.next(3)); // -> 2.0
        System.out.println(ma.next(4)); // -> 3.0
        System.out.println(ma.next(5)); // -> 4.0
        System.out.println(ma.next(6)); // -> 5.0
    }

    public double next(int val) {
        if (window.size() == size) {
            sumWindow -= window.remove(0); // Удаляем самое старое значение из окна и вычитаем его из суммы
        }
        window.add(val); // Добавляем новое значение в окно
        sumWindow += val; // Обновляем сумму значений в окне

        return (double) sumWindow / window.size(); // Возвращаем среднее значение для текущего окна
    }

    public double next2(int newValue) {
        if (window.size() == size) {
            window.remove(0);
        }
        window.add(newValue);

        return window.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0, Double::sum) / window.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingAverage that = (MovingAverage) o;
        return size == that.size && sumWindow == that.sumWindow && Objects.equals(window, that.window);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, window, sumWindow);
    }
}
