package com.ohgiraffers.section02.userexception;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의의 예외클래스 정의 후 발생한 사용자 정의의 예외를 처리할 수 있다. */
        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(-30000, 50000);
//            et.checkEnoughMoney(30000, -50000);
            et.checkEnoughMoney(50000, 30000);
//        } catch (Exception e) {       // 부모 예외 타입이 위로 올라오면 아래에 있는 예외처리를 처리할 수 없음

//        } catch (PriceNegativeException e) {
//            System.out.println(e.getMessage());
//        } catch (NotEnoughMoneyException e) {
//            System.out.println(e.getMessage());
//        } catch (MoneyNegativeException e) {
//            System.out.println(e.getMessage());
//        }

        } catch (Exception e) {             // 다형성을 활용한 catch 처리 방식
            System.out.println("예외 메시지: " + e.getMessage());
        }
    }
}