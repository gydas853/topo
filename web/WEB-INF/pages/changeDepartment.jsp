<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-02-03
  Time: 16:56
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
    <form action="changeDepartment" method="post">
        部门名称：<input type="text" name="d_name" value="${sessionScope.department.d_name}"><br>
        <input type="hidden" name="d_id" value="${sessionScope.department.d_id}">
        <input id="input1" type="button" value="提交修改">
    </form>
    <%--返回管理员界面--%>
    <a href="forManagerMain"><input type="button" value="返回"></a>

    <script>
        $(document).ready(function () {
            $("#input1").click(function () {
                var v = confirm("确认修改");
                if(v == true){
                    $("#input1").attr("type","submit");
                }
            })
        })
    </script>
</body>
</html>
