package com.ssamz.web.user;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

public class InsertUserTest2 {
    public static void main(String[] args) {
        OracleDataSource ods = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // JDBC 1. Loading Driver Object
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@192.168.0.7:15121:orcl");
            ods.setUser("c##demo_user1");
            ods.setPassword("1234");

            // JDBC 2. Connect
            conn = ods.getConnection();

            // JDBC 3. Create Statement
            String sql = "INSERT INTO demo_users VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, "ssamz2");
            pstmt.setString(2, "ssamz123");
            pstmt.setString(3, "쌤즈");
            pstmt.setString(4, "ADMIN");

            // Send SQL
            int count = pstmt.executeUpdate();
            System.out.println(count + "건 데이터 처리 성공!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
