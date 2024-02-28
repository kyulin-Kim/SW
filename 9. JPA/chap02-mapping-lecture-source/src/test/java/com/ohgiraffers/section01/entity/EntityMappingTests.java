package com.ohgiraffers.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityMappingTests {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인1() {
        System.out.println("entityManagerFactory.hashCode: " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode: " + entityManager.hashCode());
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인2() {
        System.out.println("entityManagerFactory.hashCode: " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode: " + entityManager.hashCode());
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 테이블_만들기_테스트() {

        // given
        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1234-4567");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(member);

        entityTransaction.commit();

        // then
        Member foundMember = entityManager.find(Member.class, 1);
        foundMember.setNickname("동해번쩍");

        entityTransaction.commit();
        assertEquals(member, foundMember);
    }

}
