<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-26
  Time: 16:52
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
<p>欢迎来到招聘信息网</p>
    <div>
        <table>
            <tr>
                <td><input id="i1" type="button" value="登录账号"></td>
                <td><input id="i2" type="button" value="成为会员"></td>
                <td><input id="in1" type="button" value="查看招聘信息"></td>
            </tr>
        </table>
    </div>
    <div style="display: none;" id="div1">
        <form action="guestLogin" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="登录">
                        <input id="i3" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div style="display: none;" id="div2">
        <form action="register" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input type="password" name="pass1"></td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <input type="submit" value="注册">
                        <input id="i4" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div style="display: none;" id="div3">
        <c:forEach var="recruit" items="${recruits}">
            ${recruit}<br>
        </c:forEach>
    </div>
<script>
    $(document).ready(function () {
        $("#div1").hide();
        $("#i1").click(function () {
            $("#div1").show();
            $("#div2").hide();
            $("#div3").hide()
        });
        $("#i3").click(function () {
            $("#div1").hide();
        });

        $("#div2").hide();
        $("#i2").click(function () {
            $("#div2").show();
            $("#div1").hide();
            $("#div3").hide()
        });
        $("#i4").click(function () {
            $("#div2").hide();
        });
        $("#div3").hide();
        $("#in1").click(function () {
            $("#div3").show();
            $("#div1").hide();
            $("#div2").hide()
        })
    })
</script>
</body>
</html>