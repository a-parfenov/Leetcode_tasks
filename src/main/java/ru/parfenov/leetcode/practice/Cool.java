package ru.parfenov.leetcode.practice;

public @interface Cool {

    int MIN_POST_READING = 1;
    int MAX_POST_READING = 20;
    int avgTime() default  MIN_POST_READING;
    int readLimit() default MAX_POST_READING;
    int level();
    String[] tags() default {};
    MyDescriptionEnum description() default MyDescriptionEnum.DESC_TYPE1;
}

enum MyDescriptionEnum {
    DESC_TYPE1(), DESC_TYPE2
}
