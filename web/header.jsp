<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/4/24 0024 16:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="/indexselect"><img style="width: 150px" src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
                <c:if test="${isLogin != 1}">
                    <a href="login.jsp" id="login">登录</a>
                    <a href="reg.jsp" id="reg">注册</a>
                </c:if>
                <c:if test="${isLogin == 1}">
                    <b>您好:<a href="/logout">${user.user_name}</a></b>
                </c:if>

            </p>
                <form action="/doproductselect" method="get" class="fl">
                    <input name="namePro" value="${param.namePro}" type="text" placeholder="热门搜索：Java图书"/>
                    <input type="submit" value=""/></form>
                <div class="btn fl clearfix">
                <c:if test="${isLogin == 1}">
                    <a href="mygxin.jsp"><img src="img/grzx.png"/></a>

                    <a href="/showcart"><img src="img/gwc.png"/></a>
                </c:if>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="/indexselect">首页</a></li>

            <c:forEach var="f" items="${flist}">
                <li><a href="selectproductlist?fid=${f.cate_id}">${f.cate_name}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="c" items="${clist}">
                                <c:if test="${f.cate_id==c.cate_parent_id}">
                                <a href="selectproductlist?cid=${c.cate_id}">${c.cate_name}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

