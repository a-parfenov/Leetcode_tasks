package ru.parfenov.leetcode.interviews;

import java.util.List;
import java.util.Optional;

public class Empl {
    String tabNomer;
    String fio;

    //Есть класс
    //Написать реализацию метода поиска любого значения из списка (1 параметр) у которого табельный номер равен 2 параметру
    public static Optional<Empl> getEmployee(List<Empl> empls, String tabNomer) {
        return empls.stream()
                .filter(empl -> empl.tabNomer.equals(tabNomer))
                .findFirst();
    }

}
