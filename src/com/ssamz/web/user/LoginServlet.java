package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        System.out.println("===> LoginServlet 생성");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("---> init() 호출");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---> service() 호출");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> GET 방식의 요청 처리");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> POST 방식의 요청 처리");
    }

    @Override
    public void destroy() {
        System.out.println("---> destroy() 호출");
    }
}
