package com.tp.servlet.user;

import com.tp.entity.TP_CATEGORY;
import com.tp.entity.TP_USER;
import com.tp.service.TP_CATEGORYDao;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/togrxx")
public class ToGrxx extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        //通过id到数据库查找信息
        TP_USER togrxx = TP_USERDao.selectById(id);
        request.setAttribute("togrxx",togrxx);

        request.getRequestDispatcher("/grxxmodify.jsp").forward(request,response);
    }
}
