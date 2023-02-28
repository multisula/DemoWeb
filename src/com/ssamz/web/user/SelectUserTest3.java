package com.ssamz.web.user;

import java.util.ArrayList;
import java.util.List;

public class SelectUserTest3 {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        List<UserVO> userList = dao.getUserList();
        System.out.println("전체 회원의 수: " + userList.size());

        System.out.println("[ 회원의 권한 ]");
        for (UserVO vo : userList){
            System.out.println(vo.getName() + "의 권한: " + vo.getRole());
        }
    }
}
