package com.ssamz.biz.common;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String encoding = context.getInitParameter("boardEncoding");
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}
