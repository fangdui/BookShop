package com.tp.servlet.user;

import com.tp.entity.TP_USER;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        //通过id到数据库查找信息
        TP_USER upUser = TP_USERDao.selectById(id);
        request.setAttribute("upUser",upUser);
        request.setAttribute("cpage",request.getParameter("cpage"));
        request.getRequestDispatcher("/manage/admin_usermodify.jsp").forward(request,response);
    }
}
