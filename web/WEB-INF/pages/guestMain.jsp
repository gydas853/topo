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
    <p>欢迎${guest.g_name}</p>
    <div>
        <table>
            <tr>
                <td><input id="in1" type="button" value="查看招聘信息"></td>
                <td><input id="in2" type="button" value="创建简历"></td>
                <td><input id="in3" type="button" value="我的所有简历"></td>
            </tr>
        </table>
    </div>
    <div style="display: none;" id="div1">
        <c:forEach var="recruit" items="${recruits}">
            ${recruit}
        </c:forEach>
    </div>
    <div style="display: none;" id="div2">
        <form action="addVitae" method="post">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="v_name"></td>
                    <td>性别：</td>
                    <td><input type="text" name="v_sex"></td>
                </tr>
                <tr>
                    <td>生日：</td>
                    <td><input type="text" name="v_birth"></td>
                    <td>民族：</td>
                    <td><input type="text" name="v_ethnicity"></td>
                </tr>
                <tr>
                    <td>籍贯：</td>
                    <td><input type="text" name="v_nativePlace"></td>
                    <td>学历：</td>
                    <td><input type="text" name="v_qualification"></td>
                </tr>
                <tr>
                    <td>联系电话：</td>
                    <td><input type="text" name="v_tel"></td>
                </tr>
                <tr>
                    <td>邮箱地址：</td>
                    <td><input type="text" name="v_email"></td>
                </tr>
                <tr>
                    <td>专业：</td>
                    <td><input type="text" name="v_specialty"></td>
                    <td>工作经验：</td>
                    <td><input type="text" name="v_serviceYear"></td>
                </tr>
                <tr>
                    <td>意向工作地点：</td>
                    <td><input type="text" name="v_willSpot"></td>
                    <td>到岗时间：</td>
                    <td><input type="text" name="v_adsumDate"></td>
                </tr>
                <tr>
                    <td>希望从事的行业：</td>
                    <td><input type="text" name="v_promisingIndustry"></td>
                    <td>
                        <input type="hidden" value="${guest.g_id}" name="v_g_id">
                        <input type="submit" value="确认创建简历">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div style="display: none" id="div3">
        ${vitaes}
    </div>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#in1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div3").hide()
            });
            $("#div2").hide();
            $("#in2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div3").hide()
            })
            $("#div3").hide();
            $("#in3").click(function () {
                $("#div3").show();
                $("#div1").hide();
                $("#div2").hide()
            })
        })
    </script>
</body>
</html>
