<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/4/21 0021 16:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>

    <style>
        .reg p .error{
            display: inline-block;
            border: 1px solid #ff855a;
            background-color: #ffe8e0;
            padding: 0px 20px;
            margin-left: 10px ;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg" style="height: 900px">
    <form action="register" method="post"onsubmit="return checkForm(this)"><h1><a href="/indexselect"><img style="width: 150px" src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;magin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:60px;color:#FFFFFF">用户注册</h1>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>
        <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
            请选择性别：<input style="width: 15px;height: 15px" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="F">女
        </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="请输入出生日期：xxxx-xx-xx"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请确认邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请确认手机号码"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请确认送货地址"><span></span></p>
        <p class="txtL txt"><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
            <img src="getCode" alt="看不清，换一张" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的
            <a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
