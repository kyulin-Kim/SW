package com.ohgiraffers.section02.annotation.common.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("poketmonServicePrimary")
public class PoketmonSerivce {

    /* 설명.
     *  @Autowired는 생략하면 매개변수 있는 생성자에 자동으로 작성된다.(자동으로 생성자 주입이 됨)
     *  현재와 같이 Poketmon 타입의 빈이 2개 이상일 경우 @Primary 어노테이션을 통해 하나의 빈만 주입되게 할 수 있다.
    * */
    private Poketmon poketmon;

    @Autowired
    public PoketmonSerivce(Poketmon poketmon) {
        this.poketmon = poketmon;
    }

    public void poketmonAttack() {
        poketmon.attack();
    }
}
