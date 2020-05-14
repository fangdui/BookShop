package com.tp.servlet.product;

import com.tp.entity.TP_CATEGORY;
import com.tp.entity.TP_PRODUCT;
import com.tp.entity.TP_USER;
import com.tp.service.TP_CATEGORYDao;
import com.tp.service.TP_PRODUCTDao;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);

        String id = request.getParameter("id");
        //通过id到数据库查找信息
        TP_PRODUCT upPro = TP_PRODUCTDao.selectById(Integer.parseInt(id));
        request.setAttribute("upPro",upPro);
        request.getRequestDispatcher("/manage/admin_productmodify.jsp").forward(request,response);
    }
}
