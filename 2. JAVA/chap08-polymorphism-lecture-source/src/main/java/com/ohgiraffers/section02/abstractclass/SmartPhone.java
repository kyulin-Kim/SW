package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{       // 추상 클래스는 추상메소드를 0개 이상 가진다.

    public SmartPhone() {
        super();
    }

    /* 설명. 추상메소드를 물려받은 자식 클래스(온전한)는 반드시 오버라이딩 해야 한다.(강제성 부여) */
    @Override
    public void abstractMethod() {
        System.out.println("Product 클래스로부터 물려받은 abstractMethod를 오버라이딩한 메소드 호출함...");
    }
    /* 설명. 추가적인 메소드도 작성할 수 있다. */
    public void printSmartPhone() {
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드 호출함...");
    }
}
