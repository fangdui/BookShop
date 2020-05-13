<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/5/11 0011 18:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="zuo fl">
    <h3><a href="#"><img src="img/tx.png"/></a>
        <p class="clearfix"><span class="fl"><a href="/grxxselect?id=${user.user_id}">[${user.user_name}]</a></span>
            <span class="fr"><a href="/logout">[退出登录]</a></span></p></h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="/showcart">我的购物车</a></li>
            <li><a href="myorderq.html">我的订单</a></li>
            <li><a href="myprod.html">评价晒单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li class="on"><a href="mygxin.jsp">个人信息</a></li>
            <li><a href="address.html">地址管理</a></li>
        </ul>
    </div>
</div>
