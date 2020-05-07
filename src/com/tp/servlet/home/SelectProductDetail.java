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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectproductdetail")
public class SelectProductDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TP_CATEGORY> flist = TP_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",flist);

        ArrayList<TP_CATEGORY> clist = TP_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",clist);

        String id = request.getParameter("id");
        //获取最近访问（猜你喜欢）
        HttpSession session = request.getSession();
        //从session里面获取ids
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if(ids == null){
            ids = new ArrayList<Integer>();
        }
        //最多放5个，如果多出5个，就将第一个删除
        if(ids.size()>=5){
            ids.remove(0);
        }

        //添加列表里，但只存一份
        if(id != null && (!ids.contains(Integer.parseInt(id)))){
            ids.add(Integer.parseInt(id));
        }
        session.setAttribute("ids",ids);
        ids = (ArrayList<Integer>)session.getAttribute("ids");

        if(ids!=null){
            ArrayList<TP_PRODUCT> lastList = TP_PRODUCTDao.selectAllById(ids);
            request.setAttribute("lastList",lastList);
        }

        TP_PRODUCT p = null;
        if(id != null){
            p = TP_PRODUCTDao.selectById(Integer.parseInt(id));
            request.setAttribute("p",p);
        }
        if (p!=null){
            int cid = p.getProduct_cid();
            ArrayList<TP_PRODUCT> classlist = TP_PRODUCTDao.selectByAllCid(cid);
            request.setAttribute("classlist",classlist);

            TP_CATEGORY cate = TP_CATEGORYDao.selectById(cid);
            request.setAttribute("cate",cate);
        }

        request.getRequestDispatcher("proDetail.jsp").forward(request,response);
    }
}
