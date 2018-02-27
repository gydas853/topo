<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-02-12
  Time: 22:09
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
    <form action="sendInterview" method="post">
        应聘的职位：<input type="text" name="i_r_name" value="${offer.recruit.r_name}"><br>
        应聘者：<input type="text" name="i_v_name" value="${offer.vitae.v_name}"><br>
        应聘的公司：<input type="text" name="i_c_name" value="${offer.recruit.company.c_name}"><br>
        应聘的部门：<input type="text" name="i_d_name" value="${offer.recruit.department.d_name}"><br>
        应聘的职位：<input type="text" name="i_p_name" value="${offer.recruit.position.p_name}"><br>
        面试时间：<input type="text" name="i_interviewTime"><br>
        面试地点：<input type="text" name="i_interviewAddress"><br>
        <input type="hidden" value="${offer.o_r_id}" name="i_r_id">
        <input type="hidden" value="${offer.o_g_id}" name="i_g_id">
        <input type="hidden" value="${offer.o_r_id}" name="o_r_id">
        <input type="hidden" value="${offer.o_g_id}" name="o_g_id">
        <input type="hidden" value="${offer.recruit.department.d_id}" name="i_d_id">
        <input type="hidden" value="${offer.recruit.position.p_id}" name="i_p_id">
        <input type="hidden" name="i_result" value="0">
        <input type="submit" value="发送面试邀请">
    </form>
    <a href="forManagerMain"><input value="重新选择" type="button"></a>
</body>
</html>
