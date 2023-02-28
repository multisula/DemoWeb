package com.ssamz.web.user;

import java.sql.*;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        dao.insertUser("ssamz3", "ssamz123", "쌤즈", "ADMIN");

        dao.getUserList();
    }
}
