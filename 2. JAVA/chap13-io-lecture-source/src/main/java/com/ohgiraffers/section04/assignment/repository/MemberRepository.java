package com.ohgiraffers.section04.assignment.repository;


import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.Member;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터와 입출력을 위해 만들어지며 성공 실패 결과를 반환하는 클래스 */
public class MemberRepository {

    private  ArrayList<Member> memberList = new ArrayList<>();

    /* 설명. 프로그램이 켜지자마자(MemberRepository()가 실행되자마자) 파일에 dummy 데이터 추가 및 입력 받기 */
    public MemberRepository() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member(1, "user01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A));
        members.add(new Member(2, "user02", "pass02", 10, new String[]{"게임", "영화시청"}, BloodType.B));
        members.add(new Member(3, "user03", "pass03", 15, new String[]{"음악감상", "독서", "명상"}, BloodType.O));

        saveMembers(members);
        loadMembers();

//        System.out.println("==== repository에서 회원정보 다 읽어왔는지 확인 ====");
//        for (Member m: memberList) {
//            System.out.println();
//        }
    }

    /* 설명. 회원이 담긴 ArrayList를 던지면 파일에 출력하는 기능 */
    private void saveMembers(ArrayList<Member> members) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));

            /* 설명. 넘어온 회원 수만큼 객체 출력하기 */
            for (Member m : members) {
                oos.writeObject(m);
            }

            oos.flush();                    // 출력 시에는 flush 해 줄것
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명. 파일로부터 회원 객체들을 입력받아 memberList에 쌓기 */
    private void loadMembers() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));

            /* 설명. 파일로부터 모든 회원 정보를 읽어 memberList에 추가(add) */
            // 에러 찾기
//            while (true) {
//                memberList.add((Member)(ois.readObject()));
//            }
            while(true) {
                memberList.add((Member)(ois.readObject()));
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 모두 로딩됨...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMember(int memNo) {

        for (Member m: memberList) {
            if (m.getMemNo() == memNo) return m;
        }
        return null;
    }
}
