package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */

        /* 목차. 1. non-static 메소드 호출 */
        com.ohgiraffers.section01.method.Calculator cal     //다른 클래스를 호출할 때 써야 함
                = new com.ohgiraffers.section01.method.Calculator();

        int plusresult = cal.plusTwoNumber(100, 20);
        System.out.println("100과 20의 합: " + plusresult);

        /* 목차. 2. static 메소드 호출 */
        int maxResult
                = com.ohgiraffers.section01.method.Calculator.maxNumberOf(100, 20);
        System.out.println("두 수 중 큰 값: " + maxResult);
    }
}
