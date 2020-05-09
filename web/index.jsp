<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/4/24 0024 15:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img height="450" src="img/JAVA.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img height="450" src="img/Mysql.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img height="450" src="img/Spring.jpg"/></div>
            </li>
        </ul>
    </div>
</div>
<!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper"><h2><img style="width: 150px" src="img/zssj.jpg"/></h2>
        <div class="pList clearfix tran">
            <c:forEach var="lfl" items="${lastFourList}">
                <a href="/selectproductdetail?id=${lfl.product_id}">
                    <dl>
                        <dt><span class="abl"></span><img style="width: 300px;height: 300px" src="images/product/${lfl.product_filename}"/><span class="abr"></span></dt>
                        <dd>【方队】${lfl.product_name}</dd>
                        <dd><span>￥${lfl.product_price}.00</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div><!--返回顶部-->
<%@include file="tail.jsp"%>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>
