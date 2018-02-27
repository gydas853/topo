<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <table>
        <tr>
            <td><input id="in1" type="button" value="个人信息"></td>
            <td><input id="in2" type="button" value="公司内部浏览"></td>
            <td><input id="in3" type="button" value="我的培训"></td>
            <td><input id="in4" type="button" value="奖惩记录"></td>
            <td><input id="in5" type="button" value="我的出勤"></td>
            <td><a href="forSystem"><input type="button" value="返回主界面"></a></td>
        </tr>
    </table>
    <div id="div1" style="display: none;">
        个人信息
    </div>
    <div id="div2" style="display: none;">
        公司内部浏览
    </div>
    <div id="div4" style="display: none;">
        我的培训
    </div>
    <div id="div5" style="display: none;">
        奖惩记录
    </div>
    <div id="div6" style="display: none;">
        我的出勤
    </div>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#in1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div2").hide();
            $("#in2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div4").hide();
            $("#in3").click(function () {
                $("#div4").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div5").hide();
            $("#in4").click(function () {
                $("#div5").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide();
                $("#div6").hide()
            });
            $("#div6").hide();
            $("#in5").click(function () {
                $("#div6").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide();
                $("#div5").hide()
            });
        })
    </script>
</body>
</html>
