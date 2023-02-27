package com.ssamz.web.user;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertUserTest {
    public static void main(String[] args) {
        Connection conn = null;


        try {
            DriverManager.registerDriver(new OracleDriver());

            String jdbcUrl = "jdbc:oracle:thin:@192.168.0.7:15121:orcl";
            conn = DriverManager.getConnection(jdbcUrl, "c##demo_user1", "1234");

            if(conn != null){
                System.out.println("oracle 연결 성공 : " + conn.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
