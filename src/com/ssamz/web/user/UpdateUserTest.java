package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        dao.updateUser("수정", "USER", "ssamz3");

        dao.getUserList();
    }
}
