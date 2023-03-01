package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "insertUser.do", value = "/insertUser.do")
public class InsertUserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String role = request.getParameter("role");
    String selfInfo = request.getParameter("selfInfo");
    String[] languages = request.getParameterValues("languages");
    String age = request.getParameter("age");

    System.out.println("아이디: " + id);
    System.out.println("비밀번호: " + password);
    System.out.println("이름: " + name);
    System.out.println("권한: " + role);
    System.out.println("자기 소개: " + selfInfo);
    System.out.print("언어 경험: ");
    for(String language: languages){
      System.out.print(language + " ");
    }
    System.out.println();
    System.out.println("나이: " + age);
  }
}
