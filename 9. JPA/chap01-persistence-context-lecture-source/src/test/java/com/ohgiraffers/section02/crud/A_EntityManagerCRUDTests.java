package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class A_EntityManagerCRUDTests {

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

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 메뉴코드로_메뉴_조회_테스트() {

        // given
        int menuCode = 2;

        // when
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // then
        Assertions.assertNotNull(foundMenu);
        assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);
    }

    @Test
    public void 새로운_메뉴_추가_테스트() {

        // given
        Menu menu = new Menu();
        menu.setMenuName("꿀발린 추어탕");
        menu.setMenuPrice(7000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.persist(menu);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();

        }
        // then
        Assertions.assertTrue(entityManager.contains(menu));        // menu 객체가 현재 영속 상태로 관리되는지 확인
    }

    @Test
    public void 메뉴_이름_수정_테스트() {

        // given
        Menu menu = entityManager.find(Menu.class, 2);
        System.out.println("menu = " + menu);

        String menuNameToChange = "갈치스무디";

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            menu.setMenuName(menuNameToChange);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        // then
        assertEquals(menuNameToChange, entityManager.find(Menu.class, 2).getMenuName());
    }

    @Test
    public void 메뉴_삭제하기_테스트() {

        // given
        Menu menuToRemove = entityManager.find(Menu.class, 1);

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.remove(menuToRemove);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        // then
        Menu removeMenu = entityManager.find(Menu.class, 1);
        assertEquals(null, removeMenu);
    }

    @Test
    public void 준영속성_detach_테스트() {

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 11);

        /* 설명.
         *  영속성 컨텍스트가 관리하던 엔티티 객체를 관리하지 않는 상태가 되게 한 것을 준영속 상태라고 하낟.
         *  detach가 준영속 상태를 만들기 위한 메소드이다.
        * */
        entityManager.detach(foundMenu2);

        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        assertEquals(5000, entityManager.find(Menu.class, 11).getMenuPrice());
        assertEquals(5000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 준영속성_clear_close_테스트() {
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        /* 설명. 영속성 컨텍스트로 관리되던 엔티티 객체들을 모두 비영속 상태로 바꿈 */
//        entityManager.clear();

        /* 설명. 영속성 컨텍스트 및 엔티티 매니저까지 종료해 버린다.(사용 불가) */
        entityManager.close();

        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        /* 설명. DB에서 새로 조회 해온 객체를 영속 상태로 두기 때문에 전혀 다른 결과가 나온다. */
        assertEquals(5000, entityManager.find(Menu.class, 11).getMenuPrice());
        assertEquals(5000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 병합_merge_수정_테스트() {
        Menu menuToDetach = entityManager.find(Menu.class, 2);
        entityManager.detach(menuToDetach);

        menuToDetach.setMenuName("수박죽");
        Menu refoundMenu = entityManager.find(Menu.class, 2);       // refoundMenu에는 기존의 메뉴 이름이 있다.

        System.out.println(menuToDetach.hashCode());
        System.out.println(refoundMenu.hashCode());

        entityManager.merge(menuToDetach);

        Menu mergeMenu = entityManager.find(Menu.class, 2);
        assertEquals("수박죽", mergeMenu.getMenuName());
    }

    @Test
    public void 병합_merge_삽입_테스트() {
        Menu menuToDetach = entityManager.find(Menu.class, 2);
        entityManager.detach(menuToDetach);

        menuToDetach.setMenuCode(999);
        menuToDetach.setMenuName("수박죽");

        entityManager.merge(menuToDetach);

        Menu newMenu = entityManager.find(Menu.class, 2);
        Menu mergeMenu = entityManager.find(Menu.class, 999);
        assertNotEquals(menuToDetach.getMenuCode(), newMenu.getMenuCode());
    }
}
