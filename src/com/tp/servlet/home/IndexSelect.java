package com.tp.servlet.home;

import com.tp.entity.TP_CATEGORY;
import com.tp.entity.TP_PRODUCT;
import com.tp.service.TP_CATEGORYDao;
import com.tp.service.TP_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);

        ArrayList<TP_PRODUCT> plist = TP_PRODUCTDao.selectAll();
        request.setAttribute("plist",plist);

        ArrayList<TP_PRODUCT> lastFourList = TP_PRODUCTDao.selectLastFour();
        request.setAttribute("lastFourList",lastFourList);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
