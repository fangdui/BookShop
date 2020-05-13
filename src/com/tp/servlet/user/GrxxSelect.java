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

@WebServlet("/grxxselect")
public class GrxxSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);
        String id = request.getParameter("id");
        TP_USER grxx = TP_USERDao.selectById(id);
        request.setAttribute("grxx",grxx);

        request.getRequestDispatcher("/mygrxx.jsp").forward(request,response);
    }
}
