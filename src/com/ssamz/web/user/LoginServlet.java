package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginProcess", value="/LoginProcess")
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


        System.out.println("-----------------Start Line-----------------");
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();
        System.out.println(method + " " + uri + " " + protocol);

        System.out.println("-----------------Message Header-----------------");
        System.out.println("Host : " + req.getHeader("host"));
        System.out.println("Connection : " + req.getHeader("connection"));
        System.out.println("User-Agent : " + req.getHeader("user-agent"));
        System.out.println("Accept : " + req.getHeader("accept"));
        System.out.println("Accept-Encoding : " + req.getHeader("accept-encoding"));
        System.out.println("Accept-Language : " + req.getHeader("accept-language"));

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
