<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-02-27
  Time: 10:19
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
    《${sessionScope.department.d_name}》部门职位信息表

    <%--当前部门职位信息--%>
    <div>
        <c:choose>
            <c:when test="${!empty sessionScope.positions}">
                <table border="1" cellpadding="10" cellspacing="0" style="text-align: center">
                    <tr>
                        <td>职位名称</td>
                        <td>在职人数</td>
                        <td>创建时间</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="position" items="${sessionScope.positions}">
                        <tr>
                            <td>${position.p_name}</td>
                            <td id="poNumber${position.p_id}">${position.p_number}</td>
                            <td>${position.p_createTime}</td>
                            <td>
                                <form action="forChangePosition" method="post" style="float: left">
                                    <input type="hidden" name="p_id" value="${position.p_id}">
                                    <input type="hidden" name="p_d_id" value="${sessionScope.department.d_id}">
                                    <input id="change${position.p_id}" type="button" value="修改职位信息">
                                </form>
                                <form action="deletePosition" method="post" style="float: left">
                                    <input type="hidden" name="p_id" value="${position.p_id}">
                                    <input type="hidden" name="p_d_id" value="${sessionScope.department.d_id}">
                                    <input id="del${position.p_id}" type="button" value="删除职位信息">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                SORRY，暂无职位信息
            </c:otherwise>
        </c:choose>
        <input id="i1" type="button" value="添加一个职位信息">
        <a href="forManagerMain"><input type="button" value="返回"></a>
    </div>

    <%--管理员增加一个职位信息--%><%--写完，暂未发现bug--%>
    <div style="display: none;" id="div1">
        <form action="addPosition" method="post">
            <table>
                <tr>
                    <td>职位名称：</td>
                    <td><input type="text" name="p_name"></td>
                </tr>
            </table>
            <input type="hidden" name="p_d_id" value="${sessionScope.department.d_id}">
            <input type="hidden" name="p_number" value="0">
            <input type="submit" value="添加职位">
        </form>
    </div>

    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#i1").click(function () {
                $("#div1").show()
            });
            <c:forEach var="po" items="${sessionScope.positions}">
            $("#change${po.p_id}").click(function () {
                if ($("#poNumber${po.p_id}").text() == 0){
                    $("#change${po.p_id}").attr("type","submit")
                }else {
                    alert("此职位目前有员工无法修改或删除")
                }
            });
            </c:forEach>
            <c:forEach var="po" items="${sessionScope.positions}">
            $("#del${po.p_id}").click(function () {
                if($("#poNumber${po.p_id}").text() == 0){
                    var v = confirm("确定要删除吗");
                    if(v == true){
                        $("#del${po.p_id}").attr("type","submit");
                    }
                }else {
                    alert("此职位目前有员工无法修改或删除")
                }
            });
            </c:forEach>
        })
    </script>
</body>
</html>
