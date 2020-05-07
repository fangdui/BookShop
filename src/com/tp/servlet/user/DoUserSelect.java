package com.tp.servlet.user;

import com.tp.entity.TP_USER;
import com.tp.service.TP_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpage = 1;//当前页
        int count = 5;//每页可以显示的条数
        //获取用户指定的页面
        String cp = request.getParameter("cp");

        //接收用户搜索的关键字
        String keyword = request.getParameter("keywords");

        if(cp!=null&&!cp.equals("null")){
            cpage = Integer.parseInt(cp);
        }

        int arr[] = TP_USERDao.totalPage(count,keyword);

        //获取所有的用户记录
        ArrayList<TP_USER> list = TP_USERDao.selectAll(cpage,count,keyword);
        //放到请求对象域里面
        request.setAttribute("userlist",list);
        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage",arr[1]);
        request.setAttribute("cpage",cpage);

        if(keyword!=null){
            request.setAttribute("searchParams","&keywords="+keyword);
        }

        request.getRequestDispatcher("admin_user.jsp").forward(request,response);
    }
}
