package com.ssamz.web.user;

import java.sql.*;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();

            // JDBC 3. Create Statement
            String sql = "INSERT INTO demo_users VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, "ssamz3");
            pstmt.setString(2, "ssamz123");
            pstmt.setString(3, "쌤즈");
            pstmt.setString(4, "ADMIN");

            // Send SQL
            int count = pstmt.executeUpdate();
            System.out.println(count + "건 데이터 처리 성공!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
}
