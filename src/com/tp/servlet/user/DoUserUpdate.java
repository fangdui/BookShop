package com.tp.servlet.user;

import com.tp.entity.TP_USER;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userName");
        String name = request.getParameter("name");
        String pwd = request.getParameter("passWord");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String userStatus = request.getParameter("userStatus");
        int status = 1;
        if(userStatus!=null){
            status = Integer.parseInt(userStatus);
        }

        //创建用户实体
        TP_USER user = new TP_USER(username,name,pwd,sex,birthday,null,email,mobile,address,status);
        //加入到数据库用户表中
        int count = TP_USERDao.update(user);

        //成功或失败重定向到哪里

        if(count>0){
            response.sendRedirect("/manage/admin_douserselect?cp="+request.getParameter("cpage"));
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户修改失败')");
            out.write("location.href='/manage/admin_touserupdate?id="+username+"'");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
