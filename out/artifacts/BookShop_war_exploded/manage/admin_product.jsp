<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/4/19 0019 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-wrap">
                <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/manage/admin_toproductadd"><i class="icon-font"></i>新增图书</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="p" items="${plist}">
                            <tr>
                                <td>${p.product_id}</td>
                                <td><img src="../images/product/${p.product_filename}" width="100" height="100">
                                    ${p.product_name}
                                </td>
                                <td>
                                    <a href="">修改</a>
                                    <a href="">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function catedel(id) {
                                if(confirm("你确定要删除这个分类吗")){
                                    location.href="/manage/admin_docatedel?id="+id;
                                }
                            }
                        </script>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
