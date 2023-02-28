package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();

            // JDBC 3. Create Statement
            String sql = "UPDATE demo_users SET name=?, role=? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, "수정");
            pstmt.setString(2, "USER");
            pstmt.setString(3, "ssamz3");

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
