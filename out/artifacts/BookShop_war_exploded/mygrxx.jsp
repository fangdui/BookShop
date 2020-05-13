<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/5/11 0011 18:07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="/indexselect"><img style="width: 150px" src="img/logo.png"/></a></h1>
        </div>
    </div>
</div>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="/indexselect" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人信息</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%@ include file="grdaohang.jsp"%>
        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="tx"><a href="#"><img src="img/tx.png"/>
                    <p id="avatar">修改头像</p></a></div>
                <div class="xx"><h3 class="clearfix"><strong class="fl">基础资料</strong><a href="/togrxx?id=${grxx.user_id}" class="fr" id="edit1">编辑</a>
                </h3>
                    <div>用户名：${grxx.user_id}</div>
                    <div>姓名：${grxx.user_name}</div>
                    <div>密码：${grxx.user_password}</div>
                    <div>性别：${grxx.user_sex=='T'?'男':'女'}</div>
                    <div>生日：${grxx.user_birthday}</div>
                    <div>邮箱：${grxx.user_email}</div>
                    <div>手机：${grxx.user_mobile}</div>
                    <div>地址：${grxx.user_address}</div>
                </div>
            </div>
        </div>
    </div>
</div><!--遮罩-->
<div class="mask"></div>
<!--修改头像-->
<div class="avatar">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>修改头像</h3>
    <form action="#" method="get"><h4>请上传图片</h4><input type="button" value="上传头像"/>
        <p>jpg或png，大小不超过2M</p><input type="submit" value="提交"/></form>
</div><!--返回顶部-->
<%@include file="tail.jsp"%>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
