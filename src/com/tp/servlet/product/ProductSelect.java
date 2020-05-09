package com.tp.servlet.product;

import com.tp.entity.TP_PRODUCT;
import com.tp.service.TP_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<TP_PRODUCT> plist = TP_PRODUCTDao.selectAll();
        request.setAttribute("plist",plist);

        request.getRequestDispatcher("/manage/admin_product.jsp").forward(request,response);
    }
}
