<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-29
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>标题</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
    <p>欢迎${manager.m_name}登录</p>
    <table>
        <tr>
            <td><input id="i1" type="button" value="发布招聘信息"></td>
            <td><input id="i2" type="button" value="所有招聘信息"></td>
            <td><a href="forSystem"><input type="button" value="返回主界面"></a></td>
        </tr>
    </table>
    <%--发布招聘信息--%>
    <div style="display: none;" id="div1">
        <form action="addRecruit" method="post">
            职位：<input type="text" name="r_name"><br>
            公司：<select name="r_c_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="company" items="${companies}" >
                <option value="${company.c_id}">${company.c_name}</option>
            </c:forEach>
        </select><br>
            部门：<select name="r_d_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="department" items="${departments}">
                <option value="${department.d_id}">${department.d_name}</option>
            </c:forEach>
        </select><br>
            职位：<select name="r_p_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="position" items="${positions}">
                <option value="${position.p_id}">${position.p_name}</option>
            </c:forEach>
        </select><br>
            月薪：<input type="text" name="r_money"><br>
            <input type="submit" value="确认发布">
        </form>
    </div>
    <%--查看所有招聘信息--%>
    <div style="display: none" id="div2">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>招聘岗位</td>
                <td>招聘公司</td>
                <td>招聘部门</td>
                <td>招聘职位</td>
                <td>月薪</td>
                <td>操作</td>

            </tr>
            <c:forEach var="recruit" items="${recruits}">
                <tr  id="tr${recruit.r_id}">
                    <td>${recruit.r_name}</td>
                    <td>${recruit.company.c_name}</td>
                    <td>${recruit.department.d_name}</td>
                    <td>${recruit.position.p_name}</td>
                    <td>${recruit.r_money}</td>
                    <td>
                        <a href="forChangeRecruit?r_id=${recruit.r_id}"><input type="button" value="修改招聘信息"></a>
                        <a href="deleteRecruit?r_id=${recruit.r_id}"><input type="button" value="删除招聘信息"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#i1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div3").hide()
            });
            $("#div2").hide();
            $("#i2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div3").hide()
            });
        })
    </script>
</body>
</html>
