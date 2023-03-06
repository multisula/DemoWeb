package com.ssamz.biz.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateBoard", value = "/UpdateBoard.do")
public class UpdateBoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String encoding;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String seq = request.getParameter("seq");
        String content = request.getParameter("content");

        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setSeq(Integer.parseInt(seq));
        vo.setContent(content);
        BoardDAO bdao = new BoardDAO();
        bdao.updateBoard(vo);

        response.sendRedirect("/GetBoardList.do");
    }
}
