package com.ohgiraffers.section02.encapsulation.problem2;

public class Monster {
//    String name;
//    int hp;

    /* 설명. 필드의 변수명이 바꼈다면 */
    String kinds;
    int mp;

    // 단일 책임의 원칙 - 유지보수 원활하게 하기 위해 메소드를 통해 접근한다.
    void setInfo1(String info1) {
//        this.name = info1;
        this.kinds = info1;
    }

    void setInfo2(int info2) {
//        this.hp = info2;
        this.mp = info2;
    }
}
