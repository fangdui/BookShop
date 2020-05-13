<%--
  Created by IntelliJ IDEA.
  User: Peter
  DateTime: 2020/4/19 0019 1:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用『方队』后台管理系统。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="admin_useradd.jsp"><i class="icon-font">&#xe001;</i>新增用户</a>
                    <a href="/manage/admin_tocateadd"><i class="icon-font">&#xe005;</i>新增分类</a>
                    <a href="/manage/admin_toproductadd"><i class="icon-font">&#xe048;</i>新增图书</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">Windows 10 专业版</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">Tomcat 9</span>
                    </li>
                    <li>
                        <label class="res-lab">运行工具</label><span class="res-info">IntelliJ IDEA</span>
                    </li>
                    <li>
                        <label class="res-lab">处理器</label><span class="res-info">Intel(R) Core(TM)i7-6700HQ CPU @ 2.60 GHz 2.59 GHZ</span>
                    </li>
                    <li>
                        <label class="res-lab">系统类型</label><span class="res-info">64位操作系统，基于x64的处理器</span>
                    </li>
                    <%
                        Date date = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String now = dateFormat.format(date);
                    %>
                    <li>
                        <label class="res-lab">现在北京时间</label><span class="res-info"><%=now%></span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">GitHub地址：</label><span class="res-info"><a href="https://github.com/fangdui" target="_blank">fangdui</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
