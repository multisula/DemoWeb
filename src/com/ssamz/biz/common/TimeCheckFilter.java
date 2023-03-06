package com.ssamz.biz.common;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "TimeCheckFilter", urlPatterns = "*.do")
public class TimeCheckFilter implements Filter {
    private static final long serialVersionUID = 1L;
    public TimeCheckFilter() {
        System.out.println("===> TimeCheckFilter 생성");
    }
    public void init(FilterConfig config) throws ServletException {
        //System.out.println("---> init() 호출");
    }

    public void destroy() {
        //System.out.println("---> destroy() 호출");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        System.out.println(path + " 요청에 소요된 시간 : " + (endTime - startTime) + "(ms)초");
    }
}
