package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectUserTest1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();

            String sql = "SELECT * FROM demo_users";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            System.out.println("[ USER 목록 ]");
            while(rs.next()){
                System.out.print(rs.getString("id") + " : ");
                System.out.print(rs.getString("password") + " : ");
                System.out.print(rs.getString("name") + " : ");
                System.out.println(rs.getString("role"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }
}
