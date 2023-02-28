package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private String USER_LIST = "SELECT * FROM demo_users";
    private String USER_INSERT = "INSERT INTO demo_users VALUES(?, ?, ?, ?)";
    private String USER_UPDATE = "UPDATE demo_users SET name=?, role=? WHERE id = ?";
    private String USER_DELETE = "DELETE DEMO_USERS WHERE id = ?";

    public void getUserList(){
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_LIST);
            rs = pstmt.executeQuery();
            System.out.println("[ USER 목록 ]");
            while(rs.next()){
                System.out.print(rs.getString("id") + " : ");
                System.out.print(rs.getString("password") + " : ");
                System.out.print(rs.getString("name") + " : ");
                System.out.println(rs.getString("role"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }

    public void insertUser(String id, String password, String name, String role){
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();

            pstmt = conn.prepareStatement(USER_INSERT);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, "ssamz3");
            pstmt.setString(2, "ssamz123");
            pstmt.setString(3, "쌤즈");
            pstmt.setString(4, "ADMIN");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
    public void updateUser(String name, String role, String id){
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_UPDATE);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, name);
            pstmt.setString(2, role);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public void deleteUser(String id){
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();
            // JDBC 3. Create Statement
            pstmt = conn.prepareStatement(USER_DELETE);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, id);

            // Send SQL
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
}
