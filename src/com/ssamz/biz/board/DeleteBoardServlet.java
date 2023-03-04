package com.ssamz.biz.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBoard", value = "/DeleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
    private static final int serialVersionUID=1;
    private String encoding;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        encoding = context.getInitParameter("boardEncoding");
        request.setCharacterEncoding(encoding);

        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(request.getParameter("seq")));
        BoardDAO bdao = new BoardDAO();
        bdao.deleteBoard(vo);

        response.sendRedirect("/GetBoardList.do");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
