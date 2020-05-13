<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/5/5 0005 13:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!--------------------------------------cart--------------------->
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="/indexselect"><img style="width: 150px" src="img/logo.png"/></a></h1>
        </div>
    </div>
</div>
<div class="cart mt"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix">
        <span class="fl">购物车</span>
        <img class="top" src="img/temp/cartTop01.png">
        <a href="/indexselect" class="fr">继续购物&gt;</a>
    </p>
    </div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>数量</div>
            <div>小计</div>
            <div>操作</div>
        </div>

        <c:forEach var="rs" items="${requestScope.shoplist}">
            <div class="th">
                <div class="pro clearfix"><label class="fl">
                    <input name="ck" type="checkbox" value="${rs.cart_id}"/>
                    <span></span></label>
                    <a class="fl" href="/selectproductdetail?id=${rs.cart_p_id}">
                    <dl class="clearfix">
                        <dt class="fl"><img width="120" height="120" src="images/product/${rs.cart_p_filename}"></dt>
                        <dd class="fl"><p>${rs.cart_p_name}</p>
                            <p>图书分类:</p>
                            <p>好看的书</p></dd>
                    </dl>
                </a></div>
                <div class="price">￥${rs.cart_p_price}.00</div>
                <div class="number"><p class="num clearfix">
                    <img class="fl sub" src="img/temp/sub.jpg">
                    <span datasrc="${rs.cart_id}" class="fl">${rs.cart_quantity}</span>
                    <img class="fl add" src="img/temp/add.jpg"></p>
                </div>
                <div class="price sAll">￥${rs.cart_p_price*rs.cart_quantity}.00</div>
                <div class="price"><a class="del" datasrc="${rs.cart_id}" href="#2">删除</a></div>
            </div>
        </c:forEach>


        <div class="goOn">空空如也~<a href="/indexselect">去逛逛</a></div>
        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="#">全选</a><a href="#" class="del">删除</a></p>

            <p class="fr"><span>共<small id="sl">0</small>件商品</span><span>合计:&nbsp;<small id="all">￥0.00</small></span><a
                    href="javascript:toorder()" class="count">结算</a></p></div>
    </div>
</div>
<script>
    function toorder() {
        var str = "";
        $("input[name='ck']:checked").each(function (index,item) {
            if($("input[name='ck']:checked").length-1==index){
                str += $(this).val();
            }else {
                str += $(this).val()+",";
            }
        });
        location.href="orderselect?eids="+str;
    }
</script>
<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p></div>
<!--返回顶部-->
<%@ include file="tail.jsp"%>
<!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="img/temp/off.jpg"/>
    <div class="proCon clearfix">
        <div class="proImg fr"><img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img
                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"
                                                                                          data-src="img/temp/proDet03_big.jpg"><img
                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fl">
            <div class="proIntro change"><p>颜色分类</p>
                <div class="smallImg clearfix"><p class="fl on"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                     data-src="img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>
                </div>
            </div>
            <div class="changeBtn clearfix"><a href="#2" class="fl"><p class="buy">确认</p></a><a href="#2" class="fr"><p
                    class="cart">取消</p></a></div>
        </div>
    </div>
</div>
<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
