package com.tp.servlet.cart;

import com.tp.entity.TP_CART;
import com.tp.entity.TP_PRODUCT;
import com.tp.entity.TP_USER;
import com.tp.service.TP_CARTDao;
import com.tp.service.TP_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        TP_PRODUCT p = null;
        String pid = request.getParameter("id");
        String count = request.getParameter("count");
        String url = request.getParameter("url");
        HttpSession session = request.getSession();
        String isLogin = (String)session.getAttribute("isLogin");
        TP_USER user = (TP_USER)session.getAttribute("user");

        if(user!=null && isLogin.equals("1")){
            String uid = user.getUser_id();

            //通过用户id和购物车中的商品id去查看是否存在相同商品
            TP_CART srcsp = TP_CARTDao.getCartShop(uid,pid);
            if(srcsp!=null){
                int srccount = srcsp.getCart_quantity();
                int newcount = srccount+Integer.parseInt(count);
                if(newcount>=5){
                    newcount = 5;
                }
                TP_CARTDao.updatenum(srcsp.getCart_id(),newcount);
            }else {
                if(pid!=null){
                    p = TP_PRODUCTDao.selectById(Integer.parseInt(pid));
                }
                TP_CART cart = new TP_CART(
                        0,
                        p.getProduct_filename(),
                        p.getProduct_name(),
                        p.getProduct_price(),
                        Integer.parseInt(count),
                        p.getProduct_stock(),
                        p.getProduct_id(),
                        uid,
                        1
                );
                TP_CARTDao.insert(cart);
            }
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('请先登录，才可以购买商品');");
            out.write("location.href='/login.jsp';");
            out.write("</script>");
            out.close();
            return;
        }
        if(url.equals("z")){
            response.sendRedirect("/showcart");
        }else {
            response.sendRedirect("/selectproductdetail?id="+pid);
        }

    }
}
