package com.tp.servlet.user;

import com.tp.entity.TP_USER;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/grxxselect")
public class GrxxSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        TP_USER grxx = TP_USERDao.selectById(id);
        request.setAttribute("grxx",grxx);

        request.getRequestDispatcher("/mygrxx.jsp").forward(request,response);
    }
}
