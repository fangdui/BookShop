package com.tp.servlet.product;

import com.jspsmart.upload.*;
import com.tp.entity.TP_PRODUCT;
import com.tp.service.TP_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //创建SmartUpload对象
        SmartUpload su = new SmartUpload();
        //初始化
        su.initialize(this.getServletConfig(),request,response);

        //上传过程
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取上传的文件对象
        Files fs = su.getFiles();
        File f = fs.getFile(0);

        //获取上传的文件名称
        String fileName = f.getFileName();
        try {
            su.save("images/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        Request req1 = su.getRequest();

        String pname = req1.getParameter("productName");
        String id = req1.getParameter("parentId");
        String price = req1.getParameter("productPrice");
        String desc = req1.getParameter("productDesc");
        String stock = req1.getParameter("productStock");

        TP_PRODUCT p = new TP_PRODUCT(
                0,
                pname,
                desc,
                Integer.parseInt(price),
                Integer.parseInt(stock),
                Integer.parseInt(id.split("-")[0]),
                Integer.parseInt(id.split("-")[1]),
                fileName
        );

        int count = TP_PRODUCTDao.insert(p);

        //成功或失败重定向到哪里
        if(count>0){
            response.sendRedirect("/manage/admin_productselect");
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品添加失败');");
            out.write("location.href='/manage/admin_toproductadd';");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
