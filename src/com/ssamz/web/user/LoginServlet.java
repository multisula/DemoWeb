package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        // 1. 사용자 입력 정보 추출
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);

        UserDAO dao = new UserDAO();
        UserVO user = dao.getUser(vo);

        // 3. 응답 화면 구성
        // 응답 메시지에 대한 인코딩 설정
        resp.setContentType("text/html;charset=UTF-8");
        // HTTP 응답 프로토콜 message-body와 연결된 출력 스트림 획득
        PrintWriter out = resp.getWriter();

        if(user != null) {
            if (user.getPassword().equals(password)) {
                out.println(user.getName() + "님 로그인 환영!<br>");
                out.println("<a href='/getBoardList.do'>글 목록 이동</a>");
            } else {
                out.println("비밀번호 오류입니다.<br>");
                out.println("<a href='/'>다시 로그인</a>");
            }
        } else {
            out.println("아이디 오류입니다.<br>");
            out.println("<a href='/'>다시 로그인</a>");
        }

        /*
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
        */
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
