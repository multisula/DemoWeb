package com.ssamz.biz.board;

import com.ssamz.web.user.UserVO;

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
  private String encoding = null;

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
    UserVO user = (UserVO) session.getAttribute("user");

    BoardVO vo = new BoardVO();

    String condition = req.getParameter("searchCondition");
    String keyword = req.getParameter("searchKeyword");
    vo.setSearchCondition(condition);
    vo.setSearchKeyword(keyword);

    BoardDAO boardDAO = new BoardDAO();
    List<BoardVO> boardList = null;
    if(keyword == null) {
      condition="TITLE";
      keyword="";
      boardList = boardDAO.getBoardList();
    } else {
      boardList = boardDAO.getBoardList(vo);
      session.setAttribute("condition", vo.getSearchCondition());
      session.setAttribute("keyword", vo.getSearchKeyword());
    }

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>글 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<center>");
    out.println("<h1>게시글 목록</h1>");
    out.println("<h3>" + user.getName() + "님 로그인 환영합니다......");
    out.println("<a href='/Logout.do'>Log-out</a></h3>");

    /*out.println("<!-- 검색 시작 -->");
    out.println("<form action='GetBoardList.do' method='post'");*/
    out.println("<!-- 검색 시작 -->\n" +
            "  <form action='GetBoardList.do' method='post'>\n" +
            "    <table border='1' cellpadding='0' width='700'>\n" +
            "      <tr>\n" +
            "        <td align='right'>\n" +
            "          <select name='searchCondition'>\n");
    if(condition.equals("TITLE")) {
      out.println("            <option value='TITLE' selected>제목</option>\n");
    } else {
      out.println("            <option value='TITLE'>제목</option>\n");
    }

    if (condition.equals("CONTENT")){
      out.println("            <option value='CONTENT' selected>내용</option>\n" );
    } else {
      out.println("            <option value='CONTENT'>내용</option>\n" );
    }

    out.println(
            "          </select>\n" +
            "          <input name='searchKeyword' type='text' value='" + keyword + "'/>\n" +
            "          <input type='submit' value='검색' />\n" +
            "        </td>\n" +
            "      </tr>\n" +
            "    </table>\n" +
            "  </form>\n" +
            "  <!-- 검색 종료 -->");
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
