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

@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TP_CATEGORY cate = TP_CATEGORYDao.selectById(id);
        ArrayList<TP_CATEGORY> catelist = TP_CATEGORYDao.selectAll();
        request.setAttribute("catelist",catelist);
        request.setAttribute("cate1",cate);
        request.getRequestDispatcher("/manage/admin_catemodify.jsp").forward(request,response);
    }
}
