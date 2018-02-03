<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-02-03
  Time: 00:31
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
    <%--修改公司信息--%>
    <form action="changeCompany" method="post">
        公司名称：<input type="text" name="c_name" value="${sessionScope.company.c_name}"><br>
        公司规模：<input type="text" name="c_companyScale" value="${sessionScope.company.c_companyScale}"><br>
        公司简介：<input type="text" name="c_summary" value="${sessionScope.company.c_summary}"><br>
        公司地址：<input type="text" name="c_address" value="${sessionScope.company.c_address}"><br>
        联系电话：<input type="text" name="c_phone" value="${sessionScope.company.c_phone}"><br>
        <input type="hidden" name="c_id" value="${sessionScope.company.c_id}">
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
