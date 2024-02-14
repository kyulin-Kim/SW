package com.ohgiraffers.section02.annotation.common.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Poketmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("poketmonServiceCollection")
public class PoketmonSerivce {
    /* 설명. 같은 타입의 빈이 2개 이상일 경우 List 또는 Map 형태의 컬렉션 형태로 주입 받을 수 있다. */

    /* 필기. 1. 같은 타입의 빈들을 List 형태로 주입 받을 수 있다. */
//    private List<Poketmon> poketmonList;
//
//    @Autowired
//    public PoketmonSerivce(List<Poketmon> poketmonList) {
//        this.poketmonList = poketmonList;
//    }
//
//    public void poketmonAttack() {
//        poketmonList.forEach(Poketmon::attack);
//    }

    /* 필기. 2. 같은 타입의 빈들을 map 형태로도 주입 받을 수 있다. */
    private Map<String, Poketmon> poketmonMap;

    @Autowired
    public PoketmonSerivce(Map<String, Poketmon> poketmonMap) {
        this.poketmonMap = poketmonMap;
    }


    /* 설명. key값은 빈의 id가 넘어오고, value값은 빈 객체의 주소 값이 넘어온다. */
    public void poketmonAttack() {
        poketmonMap.forEach((k, v) -> {
            System.out.println("key: " + k);
            System.out.println("value: " + v);
            v.attack();
        });
    }
}
