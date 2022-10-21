package com.etc.ticket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/myjump.do")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("调用了过滤器的方法1");  // 在过滤的请求执行之前执行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("调用了过滤器的方法2");  //  在过滤的请求执行之后执行
    }

    @Override
    public void destroy() {

    }
}
