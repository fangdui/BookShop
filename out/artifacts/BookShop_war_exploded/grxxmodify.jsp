<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/5/11 0011 18:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/manage/css/main.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="/indexselect"><img style="width: 150px" src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="搜索"/><input type="button"/>
                </form>
                <div class="btn fl clearfix"><a href="mygxin.html"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="/indexselect">首页</a></li>
            <li><a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav1.jpg"/></dt>
                            <dd>浓情欧式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav2.jpg"/></dt>
                            <dd>浪漫美式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav3.jpg"/></dt>
                            <dd>雅致中式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav6.jpg"/></dt>
                            <dd>简约现代</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav7.jpg"/></dt>
                            <dd>创意装饰</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="flowerDer.html">装饰摆件</a>
                <div class="sList2">
                    <div class="clearfix"><a href="proList.html">干花花艺</a><a href="vase_proList.html">花瓶花器</a></div>
                </div>
            </li>
            <li><a href="decoration.html">布艺软饰</a>
                <div class="sList2">
                    <div class="clearfix"><a href="zbproList.html">桌布罩件</a><a href="bzproList.html">抱枕靠垫</a></div>
                </div>
            </li>
            <li><a href="paint.html">墙式壁挂</a></li>
            <li><a href="perfume.html">蜡艺香薰</a></li>
            <li><a href="idea.html">创意家居</a></li>
        </ul>
    </div>
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="/indexselect" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人信息</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%@ include file="grdaohang.jsp"%>
        <div class="you fl"><h2>个人信息</h2>
            <form action="/dogrxxupdate" method="post" id="myform" name="myform">
            <div class="gxin">
                <div class="tx"><a href="#"><img src="img/tx.png"/>
                    <input type="hidden" name="userStatus" value="${togrxx.user_status}">
                    <input type="hidden" name="userId" value="${togrxx.user_id}">
                    <p id="avatar">修改头像</p></a></div>
                <div class="xx"><h3 class="clearfix"><strong class="fl">基础资料</strong></h3>
                    <div><tr>
                        <th>姓名：</th>
                        <td>
                            <input class="common-text required" id="title" name="userName" size="50" value="${togrxx.user_name}" type="text">
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>密码：</th>
                        <td>
                            <input class="common-text required" id="title" name="userPassword" size="50" value="${togrxx.user_password}" type="text">
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>性别：</th>
                        <td>
                            <input type="radio" name="userSex" value="T" ${togrxx.user_sex=='T'?'checked':''}>男
                            <input type="radio" name="userSex" value="F" ${togrxx.user_sex=='F'?'checked':''}>女
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>生日：</th>
                        <td>
                            <input class="common-text required" id="title" name="userBirthday" size="50" value="${togrxx.user_birthday}" type="text">
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>邮箱：</th>
                        <td>
                            <input class="common-text required" id="title" name="userEmail" size="50" value="${togrxx.user_email}" type="text">
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>手机：</th>
                        <td>
                            <input class="common-text required" id="title" name="userMobile" size="50" value="${togrxx.user_mobile}" type="text">
                        </td>
                    </tr></div>
                    <div><tr>
                        <th>地址：</th>
                        <td>
                            <input class="common-text required" id="title" name="userAddress" size="50" value="${togrxx.user_address}" type="text">
                        </td>
                    </tr></div>
                    <tr>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                </div>
            </div>
            </form>
        </div>
    </div>
</div><!--遮罩-->
<div class="mask"></div><!--编辑弹框-->
<div class="bj">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>编辑基础资料</h3>
    <form action="#" method="get"><p><label>姓名：</label><input type="text" value="六六六"/></p>
        <p><label>生日：</label><input type="text"/></p>
        <p><label>性别：</label><span><input type="radio"/>男</span><span><input type="radio"/>女</span></p>
        <div class="bc"><input type="button" value="保存"/><input type="button" value="取消"/></div>
    </form>
</div><!--高级设置修改-->
<div class="xg">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>切换账号地区</h3>
    <form action="#" method="get"><p><label>姓名：</label><input type="text" value="六六六"/></p>
        <div class="bc"><input type="button" value="保存"/><input type="button" value="取消"/></div>
    </form>
</div><!--修改头像-->
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

