package com.tp.servlet.cart;

import com.tp.entity.TP_CART;
import com.tp.entity.TP_USER;
import com.tp.service.TP_CARTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String isLogin = (String)session.getAttribute("isLogin");
        TP_USER user = (TP_USER) session.getAttribute("user");
        if(user!=null && isLogin.equals("1")){
            String uid = user.getUser_id();
            ArrayList<TP_CART> list = TP_CARTDao.getCart(uid);

            request.setAttribute("shoplist",list);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('请先登录，才可以购买商品');");
            out.write("location.href='/login.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
