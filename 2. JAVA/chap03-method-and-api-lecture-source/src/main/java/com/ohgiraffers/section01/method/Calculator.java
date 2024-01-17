package com.ohgiraffers.section01.method;

public class Calculator {
    public int plusTwoNumber(int first, int second) {
        return first + second;
    }

    public int subTwoNumber(int first, int second) {
        return first - second;
    }

    public int multiTwoNumber(int first, int second) {
        return first * second;
    }

    public int divideTwoNumber(int first, int second) {
        return first / second;
    }
    private int minNumberOf(int first, int second) {
        return (first > second) ? second : first;
    }
    public static int maxNumberOf(int first, int second) {
        return (first > second) ? first : second;
    }

}
