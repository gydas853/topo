<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-26
  Time: 09:15
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
        <form action="login" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td>
                        <input type="text" name="name" required="" placeholder="username">
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input type="password" name="pass" required="" placeholder="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="确认登录">
                    </td>
                    <td>
                        <a><input type="button" value="忘记密码？"></a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
