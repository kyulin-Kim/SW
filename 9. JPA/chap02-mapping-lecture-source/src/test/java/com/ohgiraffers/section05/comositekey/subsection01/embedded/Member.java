package com.ohgiraffers.section05.comositekey.subsection01.embedded;

import jakarta.persistence.*;

@Entity(name = "member_section05_subsection01")
@Table(name = "tbl_member_section05_subsection01")
public class Member {

    @EmbeddedId
    private MemberPK memberPK;

    @Column(name = "phone")
    private String phone;

    @Column(name = "adress")
    private String address;

    public Member() {
    }

    public Member(MemberPK memberPK, String phone, String address) {
        this.memberPK = memberPK;
        this.phone = phone;
        this.address = address;
    }

    public MemberPK getMemberPK() {
        return memberPK;
    }

    public void setMemberPK(MemberPK memberPK) {
        this.memberPK = memberPK;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberPK=" + memberPK +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
