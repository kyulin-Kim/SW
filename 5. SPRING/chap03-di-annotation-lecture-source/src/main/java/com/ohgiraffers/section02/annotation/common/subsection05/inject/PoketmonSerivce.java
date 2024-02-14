package com.ohgiraffers.section02.annotation.common.subsection05.inject;

import com.ohgiraffers.section02.annotation.common.Poketmon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jdk.jfr.Name;
import org.springframework.stereotype.Service;

@Service("poketmonServiceInject")
public class PoketmonSerivce {

    /* 설명. Inject 라이브러리를 활용한 필드 주입 */
//    @Inject
//    @Named("squirtle")
    private Poketmon poketmon;

//    /* 설명. 2. 생성자 주입 */
//    @Inject
//    public PoketmonSerivce(@Named("charmander") Poketmon poketmon) {
//        this.poketmon = poketmon;
//    }

    /* 설명. 3. setter 주입 */
    @Inject
    public void setPoketmon(@Named("squirtle")Poketmon poketmon) {
        this.poketmon = poketmon;
    }

    public void poketmonAttack() {
        poketmon.attack();
    }
}
