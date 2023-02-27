package com.ssamz.web.user;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

public class InsertUserTest2 {
    public static void main(String[] args) {
        OracleDataSource ods = null;
        Connection conn = null;
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@192.168.0.7:15121:orcl");
            ods.setUser("c##demo_user1");
            ods.setPassword("1234");

            conn = ods.getConnection();

            if(conn != null){
                System.out.println("jdbc 연결 성공 : " + conn.toString());
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
