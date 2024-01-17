package com.ohgiraffers.section01.literal;
//패키지는 클래스의 몸!

/* 수업목표. 여러 가지 값의 형태를 출력할 수 있다.*/
/*목차. 1. 숫자 형태의 값*/
public class Application1 {
    public static void main(String[] args) {
        /*목차. 1-1. 정수 형태의 값 출력*/
        System.out.println(123); //한 줄 내려주기

        /* 목차. 1-2. 실수 형태의 값 출력*/
        System.out.println(1.234);

        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a');            // 설명. 문자는 single quatation(')을 사용
        System.out.println('1');            // 설명. 숫자도 single quatation을 붙이면 문자임
//        System.out.println('ab');            컴파일 에러!!(문법 오류로, 실행 되기도 전에 오류나는 것)
        System.out.println('\u0000');       // 문자는 아무것도 안 넣으면 에러가 발생하지만 안 넣고 싶으면 '\u0000' 넣기


        /* 목차. 3. 문자열 형태의 값 출력*/
        System.out.println("안녕하세요!");   // 설명. 문자열은 double quatation(")을 사용
        System.out.println("a");
        System.out.println("");

        /* 목차. 4. 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println("true");         //double quatation이 붙으면 문자열
        System.out.println(false);          // 설명. true 또는 false 두 값만 논리 값이다.
    }
}
