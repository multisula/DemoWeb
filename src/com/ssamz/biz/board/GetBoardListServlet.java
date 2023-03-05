package com.ssamz.biz.board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetBoardList", value = "/GetBoardList.do")
public class GetBoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
    Cookie[] cookieList = req.getCookies();
    String userId = null;
    if(cookieList == null) {
      resp.sendRedirect("/login.html");
    } else {
      for (Cookie cookie: cookieList){
        if (cookie.getName().equals("userId")) {
          userId = cookie.getValue();
        }
      }

      if(userId == null){
        resp.sendRedirect("/login.html");
      }
    }
    */

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");
    if(userId == null){
      resp.sendRedirect("/");
    }

    BoardVO vo = new BoardVO();

    BoardDAO boardDAO = new BoardDAO();
    List<BoardVO> boardList = boardDAO.getBoardList();

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>글 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<center>");
    out.println("<h1>게시글 목록</h1>");
    out.println("<h3>" + userId + "님 로그인 환영합니다......");
    out.println("<a href='logout.do'>Log-out</a></h3>");

    out.println("<table border='1' cellpadding='0' width='700'>");
    out.println("<tr>");
    out.println("<th bgcolor='orange' width='100'>번호</th>");
    out.println("<th bgcolor='orange' width='200'>제목</th>");
    out.println("<th bgcolor='orange' width='150'>작성자</th>");
    out.println("<th bgcolor='orange' width='150'>등록일</th>");
    out.println("<th bgcolor='orange' width='100'>조회수</th>");
    out.println("</tr>");

    for (BoardVO board : boardList) {
      out.println("<tr>");
      out.println("<td>" + board.getSeq() + "</td>");
      out.println("<td align='left'><a href='/GetBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
      out.println("<td>" + board.getWriter() + "</td>");
      out.println("<td>" + board.getRegDate() + "</td>");
      out.println("<td>" + board.getCnt() + "</td>");
      out.println("</tr>");
    }

    out.println("</table>");
    out.println("<br>");
    out.println("<a href='insertBoard.html'>새글 등록</a>");
    out.println("</center>");
    out.println("</body>");
    out.println("</html>");

    out.close();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
