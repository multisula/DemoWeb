package com.ssamz.web.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetBoardList", value = "/GetBoardList.do")
public class GetBoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    out.println("<h3>테스터님 로그인 환영합니다......");
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
      out.println("<td align='left'><a href='#'>" + board.getTitle() + "</a></td>");
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
