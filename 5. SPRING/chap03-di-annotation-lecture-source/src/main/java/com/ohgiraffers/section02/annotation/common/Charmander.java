package com.ohgiraffers.section02.annotation.common;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Poketmon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격");
    }
}
