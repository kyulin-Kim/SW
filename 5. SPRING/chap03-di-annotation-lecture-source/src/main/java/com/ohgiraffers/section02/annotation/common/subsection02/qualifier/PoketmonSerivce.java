package com.ohgiraffers.section02.annotation.common.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("poketmonServiceQulifier")
public class PoketmonSerivce {

    /* 설명.
     *  @Qualifier를  통해 원하는 bean 이름(id)으로 하나의 빈을 주입 받을 수 있다.
     *  (@Primary보다 우선순위가 높다.)
    * */
//    @Autowired
//    @Qualifier("squirtle")
    private Poketmon poketmon;

    @Autowired
    public PoketmonSerivce(@Qualifier("squirtle") Poketmon poketmon) {
        this.poketmon = poketmon;
    }

    public void poketmonAttack() {
        poketmon.attack();
    }
}
