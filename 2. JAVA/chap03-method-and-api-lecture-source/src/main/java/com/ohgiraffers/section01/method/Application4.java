package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 여러 개의 전달 인자를 이용한 메소드 호출을 할 수 있다. */

        /* 목차. 1. 여러 개의 매개변수를 가진 메소드 호출 */
        Application4 app4 = new Application4();
        app4.testMethod("홍길동", 20, '남');

        /* 목차. 2. 변수에 저장된 값을 전달하여 호출할 수 있다. */
        String name = "유관순";
        int age = 20;
        char gender = '여';
        app4.testMethod(name, age, gender);
    }

    private void testMethod(String name, int age, char gender) {
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세 이며, 성별은 " + gender + "입니다.");
    }
}
