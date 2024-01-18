package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product{

    private String cpu;             // 연산장치
    private int hdd;                // 하드
    private int ram;                // 램
    private String operationSystem; // 운영체제

    public Computer() {
        super();
        System.out.println("Computer 클래스의 기본 생성자 호출함...");
    }

    public Computer(String cpu, int hdd, int ram, String operationSystem) {
        super();
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 모든 필드를 초기화 하는 생성자 호출함...");
    }

    public Computer(String code, String brand, String name, int price, Date manufacturingDate, String cpu, int hdd, int ram, String operationSystem) {
        super(code, brand, name, price, manufacturingDate);
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 부모 필드까지 모두 초기화하는 생성자 호출함...");
    }

//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operationSystem='" + operationSystem + '\'' +
//                "} " + super.toString();            // 부모 클래스에 있는 private는 상속 받은 자식클래스더라도 접근이 되지 않는다.
                                                    // 자동완성을 하지 않을 경우 super.getprice() 등으로 입력해야 한다.

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", hdd=" + hdd +
                    ", ram=" + ram +
                    ", operationSystem='" + operationSystem + '\'' +
                    "} " + "Product{" +
                    "code='" + super.getCode() + '\'' +
                    ", brand='" + super.getBrand() + '\'' +
                    ", name='" + super.getName() + '\'' +
                    ", price=" + super.getPrice() +
                    ", manufacturingDate=" + super.getManufacturingDate() +
                    '}';
        }
}
