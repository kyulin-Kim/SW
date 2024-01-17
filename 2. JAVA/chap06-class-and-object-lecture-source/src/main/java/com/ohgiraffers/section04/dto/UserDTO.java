package com.ohgiraffers.section04.dto;

import java.util.Date;

/* 필기.
 *  자바빈(Java Bean)이란?
 *  JSP에서 배우게 될 표준 액션 태그로 접근할 수 있게 만든 자바 클래스이다.
 *  자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을 의미하는데,
 *  그 때 사용할 수 있도록 규칙을 지정해 놓은 java 클래스를 자바빈(java bean)이라고 부른다.
 *  지금은 특정 목적에 따라 클래스를 작성하는 규칙ㅇ이라고 보면 된다.
* */

/* 필기.
 *  자바빈 작성 규칙
 *  1. 자바빈은 특정 패키지에 속해 있어야 함(default 패키지 사용 금지)
 *  2. 필드의 접근제어자는 private로 선언해야 함
 *  3. 기본생성자가 명시적으로 존재해야 한다.(매개변수 있는 생성자는 선택사항)
 *  4. 모든 필드에 접근 가능한 설정자(setter)와 접근자(getter)가 public으로 작성되어 있어야 함.
 *  5. 직렬화(Serializable 구현)를 고려해야 한다.(선택사항)
* */
public class UserDTO {          // DTO > Data Transfar Object

    /* 필기. 1. 필드(멤버변수) */
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 필기. 2. 생성자(기본생성자 필수로 명시적 작성) */
    public UserDTO() {      // constructor에서 select none을 하면 기본 생성자가 생성된다.
    }

    public UserDTO(String id, String pwd, String name, Date enrolldate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrolldate;
    }

    /* 필기. 3. 설정자(Setter)와 접근자(Getter) */
    public void setId(String id) {
        this.id =id;
    }

    /* 필기. 이후 나머지 setter, getter는 단축키로 만들기(generate - getter and setter) */

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getId() {
        return id;
    }

//    public String forInformation() {
//        return id + ", " + pwd + ", " + name + ", " + enrollDate;
//    }

    /* 필기. 4. 모든 멤버 변수를 String으로 반환하는 toString() */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +            // id 앞에 this. 생략
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
