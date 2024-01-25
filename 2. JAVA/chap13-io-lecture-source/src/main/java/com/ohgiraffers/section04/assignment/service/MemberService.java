package com.ohgiraffers.section04.assignment.service;

import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 성공실패 여부 확인 및 회원 관련 비즈니스 로직 처리하는 클래스 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();

    public MemberService() {

    }

    public void selectAllMembers() {
        ArrayList<Member> selectedMembers = mr.selectAllMembers();
        System.out.println("====== service까지 잘 반환되어 오나 확인 ======");
        for (Member m : selectedMembers) {
            System.out.println(m);
        }
    }

    /* 설명. 전달된 회원 번호를 활용해 repository에 있는 memberList로부터 해당 회원 찾아 반환 찾기 */
    public void selectMember(int memNo) {
        Member selectedMember = mr.selectMember(memNo);

        if(selectedMember == null) {
            System.out.println("그런 회원이 있습니다");
        } else {
            System.out.println("조회된 회원은: " + selectedMember);
        }

    }
}
