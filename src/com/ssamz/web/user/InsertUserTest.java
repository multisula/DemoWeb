package com.ssamz.web.user;

import java.sql.*;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        UserVO vo = new UserVO();
        vo.setId("ssamz4");
        vo.setPassword("ssamz123");
        vo.setName("쌤즈");
        vo.setRole("USER");

        dao.insertUser(vo);

        dao.getUserList();
    }
}
