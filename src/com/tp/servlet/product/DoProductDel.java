package com.tp.servlet.product;

import com.tp.service.TP_PRODUCTDao;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");

        //加入到数据库用户表中
        int count = TP_PRODUCTDao.del(id);

        //成功或失败重定向到哪里
        if(count>0){
            response.sendRedirect("/manage/admin_productselect");
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='/manage/admin_productselect'");
            out.write("</script>");
        }
    }
}
