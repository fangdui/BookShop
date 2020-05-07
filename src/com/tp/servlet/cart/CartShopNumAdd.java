package com.tp.servlet.cart;

import com.tp.service.TP_CARTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cartshopnumadd")
public class CartShopNumAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("count");
        String cartid = request.getParameter("cartid");
        TP_CARTDao.updatenum(Integer.parseInt(cartid),Integer.parseInt(count));
    }
}
