<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-25
  Time: 23:07
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
    <link type="text/css" rel="stylesheet" href="css/index.css">
</head>
<body>
    <%--进入系统--%>
    <div>
        <a href="forSystem"><input type="button" value="进入系统"></a>
    </div>
</body>
</html>
