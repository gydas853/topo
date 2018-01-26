<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-26
  Time: 14:58
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
            <td></td>
        </tr>
        <tr>
            <td>

            </td>
        </tr>
    </table>
    <script>

    </script>
</body>
</html>
