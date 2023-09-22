package ru.parfenov.leetcode.practice;

enum DayEnam {
    MONDAY("Понедельник"), TUESDAY("Вторник");

    private final String russianName;

    DayEnam(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
