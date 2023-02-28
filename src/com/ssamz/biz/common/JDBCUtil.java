package com.ssamz.biz.common;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JDBCUtil {
    public static Connection getConnection() {
        OracleDataSource ods = null;
        Connection conn = null;
        try{
            // JDBC 1. Loading Driver Object
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@192.168.0.7:15121:orcl");
            ods.setUser("c##demo_user1");
            ods.setPassword("1234");

            // JDBC 2. Connect
            conn = ods.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(PreparedStatement pstmt, Connection conn){
        try{
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try{
            rs.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        try{
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
