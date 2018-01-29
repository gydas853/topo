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
        </tr>
    </table>
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
            <input type="submit" value="确认发布">
        </form>
    </div>
    <a href="forSystem"><input type="button" value="返回主界面"></a>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#i1").click(function () {
                $("#div1").show()
            })
        })
    </script>
</body>
</html>
