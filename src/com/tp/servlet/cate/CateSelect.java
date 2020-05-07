package com.tp.servlet.cate;

import com.tp.entity.TP_CATEGORY;
import com.tp.service.TP_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_cateselect")
public class CateSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TP_CATEGORY> catelist = TP_CATEGORYDao.selectAll();
        request.setAttribute("catelist",catelist);
        request.getRequestDispatcher("/manage/admin_cate.jsp").forward(request,response);
    }
}
