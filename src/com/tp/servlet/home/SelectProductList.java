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

@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);

        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        int id = 0 ;
        ArrayList<TP_PRODUCT> list = null;
        if(fid!=null){
            id=Integer.parseInt(fid);
            list = TP_PRODUCTDao.selectByAllFid(id);
        }
        if(cid!=null){
            id=Integer.parseInt(cid);
            list = TP_PRODUCTDao.selectByAllCid(id);
        }

        request.setAttribute("title",TP_CATEGORYDao.selectById(id).getCate_name());
        request.setAttribute("list",list);

        request.getRequestDispatcher("proList.jsp").forward(request,response);
    }
}
