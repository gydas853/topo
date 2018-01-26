<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-26
  Time: 15:36
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
</head>
<body>
    <div>
        <a href="forMain"><input type="button" value="游客登录"></a>
        <a href="forLogin"><input type="button" value="员工登录"></a>
    </div>
</body>
</html>
