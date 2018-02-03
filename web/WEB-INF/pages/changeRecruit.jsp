<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-30
  Time: 13:57
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
    <title>更新招聘信息</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
    <%--修改招聘信息--%>
    <form action="changeRecruit" method="post">
        职位：<input type="text" name="r_name" value="${sessionScope.recruit.r_name}"><br>
        公司：<select name="r_c_id">
        <option value="${sessionScope.recruit.company.c_id}" selected>${sessionScope.recruit.company.c_name}</option>
        <c:forEach var="company" items="${sessionScope.companies}" >
            <option value="${company.c_id}">${company.c_name}</option>
        </c:forEach>
    </select><br>
        部门：<select name="r_d_id">
        <option value="${sessionScope.recruit.department.d_id}" selected>${sessionScope.recruit.department.d_name}</option>
        <c:forEach var="department" items="${sessionScope.departments}">
            <option value="${department.d_id}">${department.d_name}</option>
        </c:forEach>
    </select><br>
        职位：<select name="r_p_id">
        <option value="${sessionScope.recruit.position.p_id}" selected>${sessionScope.recruit.position.p_name}</option>
        <c:forEach var="position" items="${sessionScope.positions}">
            <option value="${position.p_id}">${position.p_name}</option>
        </c:forEach>
    </select><br>
        月薪：<input type="text" name="r_money" value="${sessionScope.recruit.r_money}"><br>
        <input type="hidden" name="r_id" value="${sessionScope.recruit.r_id}">
        <input id="input1" type="button" value="确认修改">
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
