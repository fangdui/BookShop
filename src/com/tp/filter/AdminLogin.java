package com.tp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/manage/*")
public class AdminLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();

        String flag = (String) session.getAttribute("isAdminLogin");

        String uri = request.getRequestURI();

        if(uri.contains("admin_")){
            if(flag!=null&&flag.equals("1")){
                chain.doFilter(request, response);//通过就执行这个语句
            }else {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('请先登录');");
                out.write("location.href='/manage/login.jsp';");
                out.write("</script>");
                return;
            }
        }else {
            chain.doFilter(request, response);//通过就执行这个语句
        }
        return;
        //不通过则直接return
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
