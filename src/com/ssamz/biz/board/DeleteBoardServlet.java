package com.ssamz.biz.board;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteBoard", value = "/DeleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
    private static final int serialVersionUID=1;
    private String encoding;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cookie> cookieList = new ArrayList<>();
        String userId = null;
        if(cookieList.size() == 0){
            response.sendRedirect("/login.html");
        } else {
            for(Cookie cookie: cookieList){
                userId = cookie.getName();
            }
            if(userId == null){
                response.sendRedirect("/login.html");
            }
        }
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
