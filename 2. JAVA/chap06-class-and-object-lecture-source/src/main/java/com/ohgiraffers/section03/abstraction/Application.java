package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 객체지향 프로그래밍에 대해 이해하고 객체와 클래스를 설계하여 프로그래밍 할 수 있다. */
        /* 필기.
         *  추상화란?
         *   공통된 부분을 추출하고 공통되지 않고 불필요한 부분을 제거한다는 의미를 가지며, 추상화의 목적은 유연성을 확보하기 위함이다.
         *   유연성 확보는 여러 곳에서 적용될 수 있는 유연한 객체를 의미하며, 재사용성이 높아질 수 있게 한다는 의미이다.
        * */

        /* 필기.
         *  프로그램 개요
         *    카레이서가 자동차를 운전하는 프로그램
         *
         * 필기.
         *  시스템 요구사항
         *   1. 카레이서는 시동걸기, 엑셀레이터 밟기, 브레이크 밟기, 시동 끄기를 할 수 있다.
         *   2. 자동차는 시동걸기, 앞으로 가기, 멈추기, 시동끄기를 할 수 있다.
         *   3. 자동차는 처음에 멈춘 상태로 대기하고 있는다.
         *   4. 카레이서는 먼저 자동차에 시동을 건다. 이미 걸려있는 경우 다시 시동을 걸 수 없다.
         *   5. 카레이서가 엑셀레이터를 밟으면 시동이 걸린 상태일 경우 자동차는 시속이 10km/h 증가하며 앞으로 나간다.
         *   6. 자동차가 달리는 중인 경우 브레이크를 밟으면 자동차의 시속은 바로 0km/h로 떨어지며 멈춘다.
         *   7. 브레이크를 밟을 때 자동차가 달리는 중이 아니면 이미 멈춰있는 상태라고 안내한다.
         *   8. 카레이서가 시동을 끄면 더 이상 자동차는 움직이지 않는다.
         *   9. 자동차가 달리는 중이라면 시동을 끌 수 없다.
        * */

        /* 설명. 카레이서 한 명이 등장 */
        CarRacer racer = new CarRacer();

        Scanner sc = new Scanner(System.in);

        /* 설명. 카레이서에게 명령을 하기 위한 메뉴 출력 */
        while (true) {
            System.out.println("=========== 카레이싱 프로그램 ===========");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 전진");
            System.out.println("3. 정지");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴 선택: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: racer.startUp();
                    break;
                case 2: racer.stepAccelator();
                    break;
                case 3: racer.stepBreak();
                    break;
                case 4: racer.turnOff();
                    break;
                case 9: System.out.println("프로그램을 이용해 주셔서 감사합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }

            if(input == 9) break;
        }
    }
}
