package com.ssamz.web.user;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        UserVO vo = new UserVO();

        vo.setName("수정");
        vo.setRole("USER");
        vo.setId("ssamz4");

        dao.updateUser(vo);

        dao.getUserList();
    }
}
