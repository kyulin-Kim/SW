package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. try-with-resource 구문의 문법을 이해하고 활용할 수 있다.*/
       try (BufferedReader br = new BufferedReader(new FileReader("test.dat"))) {       // 다중사용자가 같은 파일을 사용하기 위해 동시에 사용할 때 리소스 낭비를 하기 때문에 내부적으로 닫아주는 역할을 함
           String s;

           while ((s=br.readLine()) != null) {
               System.out.println(s);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
