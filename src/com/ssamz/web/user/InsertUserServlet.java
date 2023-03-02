package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "insertUser", value = "/insertUser.do")
public class InsertUserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String encoding;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext context = getServletContext();
    encoding = context.getInitParameter("boardEncoding");
    request.setCharacterEncoding(encoding);

    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String role = request.getParameter("role");
    String selfInfo = request.getParameter("selfInfo");
    String[] languages = request.getParameterValues("languages");
    String age = request.getParameter("age");

    UserDAO dao = new UserDAO();
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);
    vo.setName(name);
    vo.setRole(role);

    dao.insertUser(vo);

    response.sendRedirect("login.html");
  }
}
