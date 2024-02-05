package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명. 사번을 입력받아 한 명의 사원을 조회하는 기능 작성 */
public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명. 사용자로부터 조회하고자 하는 사원의 사번을 입력받음 */
            Scanner sc = new Scanner(System.in);
            System.out.println("사번을 입력하세요: ");
            int empId = sc.nextInt();

            String entYn = "N";

            /* 설명. 입력받은 사번을 활용한 쿼리 작성 */
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '"
                    + empId + "'AND EMT_YN = '" + entYn + "'";
            System.out.println("query = " + query);

            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                        + ", " + rset.getString("EMP_NAME"));
            } else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
