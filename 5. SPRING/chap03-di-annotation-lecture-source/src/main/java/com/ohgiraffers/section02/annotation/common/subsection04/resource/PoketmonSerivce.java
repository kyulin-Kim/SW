package com.ohgiraffers.section02.annotation.common.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Poketmon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("poketmonServiceResource")
public class PoketmonSerivce {

    /* 설명.
     *  @Qualifier와 마찬가지로 @Primary보다 우선순위 높게 우리가 원하는 빈 이름(id)으로 하나의 빈을 주입 받을 수 있다.
    * */

//    @Resource(name = "charmander")
//    private Poketmon poketmon;
//
//    public void poketmonAttack() {
//        poketmon.attack();
//    }

    @Resource
    private List<Poketmon> poketmonList;

    public void poketmonAttack() {
        poketmonList.forEach(Poketmon::attack);
    }
}
