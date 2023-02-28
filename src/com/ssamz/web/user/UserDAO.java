package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private String USER_LIST = "SELECT * FROM demo_users";
    private String USER_INSERT = "INSERT INTO demo_users VALUES(?, ?, ?, ?)";
    private String USER_UPDATE = "UPDATE demo_users SET name=?, role=? WHERE id = ?";
    private String USER_DELETE = "DELETE DEMO_USERS WHERE id = ?";

    public List<UserVO> getUserList(){
        List<UserVO> userList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_LIST);
            rs = pstmt.executeQuery();
            System.out.println("[ USER 목록 ]");
            while(rs.next()){
                UserVO vo = new UserVO();
                vo.setId(rs.getString("id"));
                vo.setPassword(rs.getString("password"));
                vo.setName(rs.getString("name"));
                vo.setRole(rs.getString("role"));
                userList.add(vo);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return userList;
    }

    public void insertUser(UserVO vo){
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();

            pstmt = conn.prepareStatement(USER_INSERT);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
    public void updateUser(UserVO vo){
        try {
            // JDBC 2. Connect
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_UPDATE);

            // JDBC 4. Send SQL
            // Set ? value
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getRole());
            pstmt.setString(3, vo.getId());
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
