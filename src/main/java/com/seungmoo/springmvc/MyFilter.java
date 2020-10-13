package com.seungmoo.springmvc;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter");
        // 그냥 filter에서 끝나면 안됨
        // Filter는 Chain 형태의 구조(셋팅된 순서대로) 이며
        // FilterChain의 doFilter로 다음 filter 또는 servlet으로 연결해줘야 한다.
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed");
    }
}
