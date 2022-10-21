package com.etc.ticket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter({"/admin/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
               //获取登录session
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        if(request.getSession().getAttribute("loginuser")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletResponse.setContentType("text/html;charset=utf-8");
             PrintWriter out= servletResponse.getWriter();
             out.print("<script>alert('尚未登录，请先登录');location.href='../login.jsp';</script>");
             out.flush();
             out.close();
        }

    }

    @Override
    public void destroy() {

    }
}
