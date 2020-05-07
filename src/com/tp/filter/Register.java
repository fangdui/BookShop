package com.tp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/register")
public class Register implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        PrintWriter out = response.getWriter();
        if(userName.equals("")){
            out.write("<script>");
            out.write("alert('用户名称不能为空');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;
        }

        HttpSession session = request.getSession();

        String veryCode = request.getParameter("veryCode");
        String sysCode = (String)session.getAttribute("code");

        if(!sysCode.equals(veryCode)){
            out.write("<script>");
            out.write("alert('验证码输入有误');");
            out.write("location.href='reg.jsp';");
            out.write("</script>");
            out.close();
            return;
        }

        //不通过则直接return
        chain.doFilter(request, response);//通过就执行这个语句
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
