package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp > 0)
        this.hp = hp;                       // this는 메소드 호출 당시의 monster 객체를 뜻하고
                                            // this.hp는 해당 객체의 hp공간을 뜻한다.
                                            // this는 매번 발라지고 현재 this는 monster3를 가리키고 있다.
        else if (hp <= 0)  this.hp = 0;     // this를 사용하면 전처리, 후처리가 가능해진다.
    }
}
