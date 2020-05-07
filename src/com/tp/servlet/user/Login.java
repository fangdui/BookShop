package com.tp.servlet.user;

import com.tp.entity.TP_USER;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        int count = TP_USERDao.selectByNM(userName,passWord);

        //成功或失败重定向到哪里
        if(count>0){
            HttpSession session = request.getSession();
            TP_USER user = TP_USERDao.selectAdmin(userName,passWord);
            session.setAttribute("user",user);
            session.setAttribute("isLogin","1");
            response.sendRedirect("/indexselect");
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户名或密码错误');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
