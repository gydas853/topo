<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nero0
  Date: 2018-01-29
  Time: 14:07
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
    <p>管理员${sessionScope.manager.m_name}登录</p>
    <table>
        <tr>
            <td><input id="i1" type="button" value="发布招聘信息"></td>
            <td><input id="i2" type="button" value="所有招聘信息"></td>
            <td><input id="i3" type="button" value="公司信息管理"></td>
            <td><input id="i4" type="button" value="部门信息管理"></td>
            <td><input id="i5" type="button" value="职位信息管理"></td>
            <td><input id="i6" type="button" value="查看应聘消息"></td>
            <td><a href="forSystem"><input type="button" value="返回主界面"></a></td>
        </tr>
    </table>
    <%--发布招聘信息--%><%--可以发布 暂未找到bug--%>
    <div style="display: none;" id="div1">
        <form action="addRecruit" method="post">
            职位：<input type="text" name="r_name"><br>
            公司：<select name="r_c_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="company" items="${sessionScope.companies}" >
                <option value="${company.c_id}">${company.c_name}</option>
            </c:forEach>
        </select><br>
            部门：<select name="r_d_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="department" items="${sessionScope.departments}">
                <option value="${department.d_id}">${department.d_name}</option>
            </c:forEach>
        </select><br>
            职位：<select name="r_p_id">
            <option value="0" selected>请选择：</option>
            <c:forEach var="position" items="${sessionScope.positions}">
                <option value="${position.p_id}">${position.p_name}</option>
            </c:forEach>
        </select><br>
            月薪：<input type="text" name="r_money"><br>
            <input type="submit" value="确认发布">
        </form>
    </div>
    <%--查看所有招聘信息--%><%--可以了--%>
    <div style="display: none" id="div2">
        <c:choose>
            <c:when test="${!empty sessionScope.recruits}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <tr>
                        <td>招聘岗位</td>
                        <td>招聘公司</td>
                        <td>招聘部门</td>
                        <td>招聘职位</td>
                        <td>月薪</td>
                        <td>公司地址</td>
                        <td>公司规模</td>
                        <td>联系方式</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="recruit" items="${sessionScope.recruits}">
                        <tr  id="tr${recruit.r_id}">
                            <td>${recruit.r_name}</td>
                            <td>${recruit.company.c_name}</td>
                            <td>${recruit.department.d_name}</td>
                            <td>${recruit.position.p_name}</td>
                            <td>${recruit.r_money}</td>
                            <td>${recruit.company.c_address}</td>
                            <td>${recruit.company.c_companyScale}</td>
                            <td>${recruit.company.c_phone}</td>
                            <td>
                                <a href="forChangeRecruit?r_id=${recruit.r_id}"><input type="button" value="修改招聘信息"></a>
                                <a href="deleteRecruit?r_id=${recruit.r_id}"><input type="button" value="删除招聘信息"></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                SORRY，暂未发布任何招聘
            </c:otherwise>
        </c:choose>
    </div>
    <%--管理公司信息--%><%--尚未完善--%>
    <div style="display: none;" id="div3">
        <table>
            <tr>
                <td>公司名称</td>
                <td>公司规模</td>
                <td>公司简介</td>
                <td>公司地址</td>
                <td>联系电话</td>
                <td>操作</td>
            </tr>
            <c:forEach var="company" items="${sessionScope.companies}">
                <tr>
                    <td>${company.c_name}</td>
                    <td>${company.c_companyScale}</td>
                    <td>${company.c_summary}</td>
                    <td>${company.c_address}</td>
                    <td>${company.c_phone}</td>
                    <td>
                        <input type="button" value="修改信息">
                        <a><input type="button" value="删除信息"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%--管理部门信息--%><%--尚未完善--%>
    <div style="display: none" id="div4">
        <table>
            <tr>
                <td>部门名称</td>
                <td>操作</td>
            </tr>
            <c:forEach var="department" items="${sessionScope.departments}">
                <tr>
                    <td>${department.d_name}</td>
                    <td>
                        <input type="button" value="修改信息">
                        <a><input type="button" value="删除信息"></a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>
    <%--管理职位信息--%><%--尚未完善--%>
    <div style="display: none;" id="div5">

    </div>
    <%--查看应聘信息--%>
    <div style="display: none;" id="div6">
        <table>
            <tr>
                <td>应聘者编号</td>
                <td>操作</td>
            </tr>
            <c:forEach var="offer" items="${offers}">
                <tr>
                    <td>${offer.o_id}</td>
                    <td><input id="show${offer.o_id}" type="button" value="详细信息"></td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach var="vitae1" items="${vitaes}">
            <div style="display: none; float: left" id="d1">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td>${vitae1.v_name}</td>
                        <td>性别：</td>
                        <td>${vitae1.v_sex}</td>
                    </tr>
                    <tr>
                        <td>生日：</td>
                        <td>${vitae1.v_birth}</td>
                        <td>民族：</td>
                        <td>${vitae1.v_ethnicity}</td>
                    </tr>
                    <tr>
                        <td>籍贯：</td>
                        <td>${vitae1.v_nativePlace}</td>
                        <td>学历：</td>
                        <td>${vitae1.v_qualification}</td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td>${vitae1.v_tel}</td>
                    </tr>
                    <tr>
                        <td>邮箱地址：</td>
                        <td>${vitae1.v_email}</td>
                    </tr>
                    <tr>
                        <td>专业：</td>
                        <td>${vitae1.v_specialty}</td>
                        <td>工作经验：</td>
                        <td>${vitae1.v_serviceYear}</td>
                    </tr>
                    <tr>
                        <td>意向工作地点：</td>
                        <td>${vitae1.v_willSpot}</td>
                        <td>到岗时间：</td>
                        <td>${vitae1.v_adsumDate}</td>
                    </tr>
                    <tr>
                        <td>希望从事的行业：</td>
                        <td>${vitae1.v_promisingIndustry}</td>
                    </tr>
                    <c:forEach var="recruit1" items="${recruits1}">
                        <tr>
                            <td>应聘的公司：</td>
                            <td>${recruit1.company.c_name}</td>
                            <td>应聘的部门：</td>
                            <td>${recruit1.department.d_name}</td>
                            <td>应聘的职位：</td>
                            <td>${recruit1.position.p_name}</td>
                        </tr>
                    </c:forEach>
                    <c:forEach var="offer" items="${offers}">
                        <tr>
                            <td>
                                <a href="forInterview"><input id="interview${offer.o_id}" type="button" value="确认面试"></a>
                                <input id="hide${offer.o_id}" type="button" value="最小化此窗口">
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </c:forEach>
    </div>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#i1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div2").hide();
            $("#i2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div3").hide();
            $("#i3").click(function () {
                $("#div3").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#div6").hide();
            $("#i6").click(function () {
                $("#div6").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide()
            });
            <c:forEach var="offer" items="${offers}">
                $("#d${offer.o_id}").hide();
                $("#show${offer.o_id}").click(function () {
                    $("#d${offer.o_id}").show()
                });
                $("#hide${offer.o_id}").click(function () {
                    $("#d${offer.o_id}").hide()
                });
                $("#interview${offer.o_id}").click(function () {
                    var v = confirm("确认发送面试邀请吗？");
                    if(v == true){
                        $("#interview${offer.o_id}").attr("type","submit")
                    }
                });
            </c:forEach>
        })
    </script>
</body>
</html>
