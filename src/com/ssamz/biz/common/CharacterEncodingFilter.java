package com.ssamz.biz.common;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter",
        initParams = @WebInitParam(name = "boardEncoding", value="UTF-8"))
public class CharacterEncodingFilter implements Filter {
    private static final long serialVersionUID = 1L;
    private String encoding;
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("boardEncoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}
