package com.ohgiraffers.section02.set.run;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. LinkedHashSet에 대해 이해하고 활용할 수 있다. */
        /* 필기.
         *  LinkedHashSet은 저장 당시의 순서를 유지하는 특징을 가지고 있다.
        * */

        Set<String> lSet = new LinkedHashSet<>();
        lSet.add("ramen");
        lSet.add("pork");
        lSet.add("kimchi");
        lSet.add("friedEgg");
        lSet.add("soup");
        System.out.println("lSet = " + lSet);
    }
}
