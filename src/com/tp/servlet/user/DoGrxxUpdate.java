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

@WebServlet("/dogrxxupdate")
public class DoGrxxUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userId");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPassword");
        String sex = request.getParameter("userSex");
        String birthday = request.getParameter("userBirthday");
        String email = request.getParameter("userEmail");
        String mobile = request.getParameter("userMobile");
        String address = request.getParameter("userAddress");
        int userStatus = Integer.parseInt(request.getParameter("userStatus"));

        //创建用户实体
        TP_USER user = new TP_USER(username,name,pwd,sex,birthday,null,email,mobile,address,userStatus);
        //加入到数据库用户表中
        int count = TP_USERDao.update(user);

        //成功或失败重定向到哪里
        if(count>0){
            response.sendRedirect("/grxxselect?id="+request.getParameter("userId"));
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户修改失败');");
            out.write("location.href='/grxxmodify.jsp';");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
