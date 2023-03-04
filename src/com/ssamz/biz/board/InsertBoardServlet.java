package com.ssamz.biz.board;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertBoard", value = "/InsertBoard.do")
public class InsertBoardServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String encoding;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext context = getServletContext();
    this.encoding = context.getInitParameter("boardEncoding");
    request.setCharacterEncoding(encoding);

    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setWriter(writer);
    vo.setContent(content);

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.insertBoard(vo);

    response.sendRedirect("GetBoardList.do");
  }
}
