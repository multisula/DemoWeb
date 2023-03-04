package com.ssamz.biz.board;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetBoard", value = "/GetBoard.do")
public class GetBoardServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String encoding = null;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = getServletContext();
    this.encoding = context.getInitParameter("boardEncoding");
    req.setCharacterEncoding(encoding);

    String seq = req.getParameter("seq");

    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));
    BoardDAO bdao= new BoardDAO();
    vo = bdao.getBoard(vo);

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>글 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<center>");
    out.println("<h1>글 상세</h1>");
    out.println("<h3><a href='logout.do'>Log-out</a></h3>");
    out.println("<hr>");
    out.println("<form action='updateBoard.do' method='post'>");
    out.println("<table border='1' cellpadding='0' cellspacing='0'>");
    out.println("<tr>");
    out.println("<td bgcolor='orange' width='70'>제목</td>");
    out.println("<td align='left'><input name='title' type='text' value='" + vo.getTitle() + "'/></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td bgcolor='orange'>작성자</td>");
    out.println("<td align='left'>" + vo.getWriter() + "</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td bgcolor='orange'>내용</td>");
    out.println("<td align='left'><textarea name='content' cols='40' rows='10'>" + vo.getContent() + "</textarea></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td bgcolor='orange'>등록일</td>");
    out.println("<td align='left'>" + vo.getRegDate() + "</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td bgcolor='orange'>조회수</td>");
    out.println("<td align='left'>" + vo.getCnt() + "</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td colspan='2' align='center'>");
    out.println("<input type='submit' value='글 수정'/>");
    out.println("</td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("</form>");
    out.println("<hr>");
    out.println("<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;");
    out.println("<a href='getBoardList.do'>글목록</a>");
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
