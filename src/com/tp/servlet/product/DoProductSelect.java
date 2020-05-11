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

@WebServlet("/doproductselect")
public class DoProductSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);
        //接收用户搜索的关键字
        String namePro = request.getParameter("namePro");

        //获取所有的用户记录
        ArrayList<TP_PRODUCT> splist = TP_PRODUCTDao.selectByName(namePro);
        //放到请求对象域里面
        request.setAttribute("splist",splist);

        if(splist==null){
            request.getRequestDispatcher("/indexselect").forward(request,response);
        }

        request.getRequestDispatcher("selectProList.jsp").forward(request,response);
    }
}
