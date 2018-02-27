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
    <p>管理员${sessionScope.manager.m_name}上线</p>

    <%--管理员主菜单--%>
    <table>
        <tr>
            <td><input id="input1" type="button" value="招聘管理"></td>
            <td><input id="input2" type="button" value="公司管理"></td>
            <td><input id="input3" type="button" value="员工管理"></td>
            <td><input id="input4" type="button" value="资金管理"></td>
            <td><a href="forSystem"><input type="button" value="返回主界面"></a></td>
        </tr>
    </table>

    <%--招聘管理次级菜单--%>
    <div id="d1" style="display: none;">
        <table>
            <tr>
                <td><input id="i1" type="button" value="发布招聘信息"></td>
                <td><input id="i2" type="button" value="所有招聘信息"></td>
                <td><input id="i3" type="button" value="查看应聘消息"></td>
            </tr>
        </table>
    </div>

    <%--发布招聘信息--%><%--写完，可以发布 暂未发现bug--%>
    <div style="display: none;" id="div1">
        <form action="addRecruit" method="post">
            职位：<input type="text" name="r_name"><br>
            <input type="hidden" value="${sessionScope.company.c_id}" name="r_c_id">
            部门：<select name="r_d_id" id="dept">
            <option value="0" selected>请选择：</option>
            <c:forEach var="department" items="${sessionScope.departments}">
                <option value="${department.d_id}">${department.d_name}</option>
            </c:forEach>
        </select><br>
            职位：<select name="r_p_id" id="position">
            <option value="0">请选择：</option>
        </select><br>
            月薪：<input type="text" name="r_money"><br>
            <input type="submit" value="确认发布">
        </form>
    </div>

    <%--查看所有招聘信息--%><%--写完，暂未发现bug--%>
    <div style="display: none;" id="div2">
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
                                <form action="forChangeRecruit" method="post">
                                    <input type="hidden" value="${recruit.r_id}" name="r_id">
                                    <input type="submit" value="修改招聘信息">
                                </form>
                                <form action="deleteRecruit" method="post">
                                    <input type="hidden" value="${recruit.r_id}" name="r_id">
                                    <input id="delete${recruit.r_id}" type="button" value="删除招聘信息">
                                </form>
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

    <%--查看应聘信息--%>
    <div style="display: none;" id="div3">
        <c:choose>
            <c:when test="${!empty sessionScope.offers}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <tr>
                        <td>应聘者姓名</td>
                        <td>性别</td>
                        <td>申请的职位</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="offer" items="${sessionScope.offers}">
                        <tr>
                            <td>${offer.o_v_name}</td>
                            <td>${offer.vitae.v_sex}</td>
                            <td>${offer.recruit.r_name}</td>
                            <td><input id="show${offer.o_id}" type="button" value="详细信息"></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                暂未收到应聘申请
            </c:otherwise>
        </c:choose>
        <c:forEach var="offer" items="${sessionScope.offers}">
            <div style="display: none; float: left" id="offerdiv${offer.o_id}">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td>${offer.o_v_name}</td>
                        <td>性别：</td>
                        <td>${offer.vitae.v_sex}</td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td>${offer.vitae.v_age}</td>
                        <td>生日：</td>
                        <td>${offer.vitae.v_birth}</td>
                    </tr>
                    <tr>
                        <td>民族：</td>
                        <td>${offer.vitae.v_ethnicity}</td>
                        <td>籍贯：</td>
                        <td>${offer.vitae.v_nativePlace}</td>
                    </tr>
                    <tr>
                        <td>学历：</td>
                        <td>${offer.vitae.v_qualification}</td>
                        <td>邮箱地址：</td>
                        <td>${offer.vitae.v_email}</td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td>${offer.vitae.v_tel}</td>
                        <td>专业：</td>
                        <td>${offer.vitae.v_specialty}</td>
                    </tr>
                    <tr>
                        <td>工作经验：</td>
                        <td>${offer.vitae.v_serviceYear}</td>
                        <td>意向工作地点：</td>
                        <td>${offer.vitae.v_willSpot}</td>
                    </tr>
                    <tr>
                        <td>到岗时间：</td>
                        <td>${offer.vitae.v_adsumDate}</td>
                        <td>希望从事的行业：</td>
                        <td>${offer.vitae.v_promisingIndustry}</td>
                    </tr>
                    <tr>
                        <td>应聘的公司：</td>
                        <td>${offer.recruit.company.c_name}</td>
                        <td>应聘的部门：</td>
                        <td>${offer.recruit.department.d_name}</td>
                    </tr>
                    <tr>
                        <td>应聘的职位：</td>
                        <td>${offer.recruit.position.p_name}</td>
                        <td>
                            <form action="forInterview" method="post">
                                <input type="hidden" value="${offer.o_id}" name="o_id">
                                <input id="interview${offer.o_id}" type="button" value="创建面试邀请函">
                            </form>
                        </td>
                    </tr>
                </table>
                <input id="hide${offer.o_id}" type="button" value="最小化此窗口">
            </div>
        </c:forEach>
    </div>

    <%--公司管理次级菜单--%>
    <div id="d2" style="display: none;">
        <table>
            <tr>
                <td><input id="i4" type="button" value="公司信息管理"></td>
                <td><input id="i5" type="button" value="部门与职位信息管理"></td>
            </tr>
        </table>
    </div>

    <%--管理公司信息--%><%--写完，暂未发现bug--%>
    <div style="display: none;" id="div4">
        <c:choose>
            <c:when test="${!empty sessionScope.company}">
        <table border="1" cellpadding="10" cellspacing="0" style="text-align: center">
            <tr>
                <td>公司名称</td>
                <td>公司规模</td>
                <td>公司简介</td>
                <td>公司地址</td>
                <td>联系电话</td>
                <td>操作</td>
            </tr>
            <tr>
                <td>${sessionScope.company.c_name}</td>
                <td>${sessionScope.company.c_companyScale}</td>
                <td>${sessionScope.company.c_summary}</td>
                <td>${sessionScope.company.c_address}</td>
                <td>${sessionScope.company.c_phone}</td>
                <td>
                    <form action="forChangeCompany" method="post" style="float: left">
                        <input type="submit" value="修改公司信息">
                    </form>
                </td>
            </tr>
        </table>
            </c:when>
            <c:otherwise>
                SORRY，未找到公司信息
            </c:otherwise>
        </c:choose>
    </div>

    <%--部门与职位信息管理--%><%--写完 暂未发现bug--%>
    <div style="display: none;" id="div5">
        <c:choose>
            <c:when test="${!empty sessionScope.departments}">
                <table border="1" cellpadding="10" cellspacing="0" style="text-align: center">
                    <tr>
                        <td>部门名称</td>
                        <td>在职人数</td>
                        <td>创建时间</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="department" items="${sessionScope.departments}">
                        <tr>
                            <td>${department.d_name}</td>
                            <td id="deNumber${department.d_id}">${department.d_number}</td>
                            <td>${department.d_createTime}</td>
                            <td>
                                <form action="forChangeDepartment" method="post" style="float: left;">
                                    <input type="hidden" name="d_id" value="${department.d_id}">
                                    <input id="ch${department.d_id}" type="button" value="修改部门信息">
                                </form>
                                <form action="deleteDepartment" method="post" style="float: left;">
                                    <input type="hidden" name="d_id" value="${department.d_id}">
                                    <input id="de${department.d_id}" type="button" value="删除部门信息">
                                </form>
                                <form action="showPosition" method="post" style="float: left;">
                                    <input type="hidden" name="p_d_id" value="${department.d_id}">
                                    <input type="submit" value="当前部门职位信息">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                SORRY，未找到部门信息
            </c:otherwise>
        </c:choose>
        <input id="i6" type="button" value="添加一个部门信息">
    </div>

    <%--管理员增加一个部门信息--%><%--写完，暂未发现bug--%>
    <div style="display: none;" id="div6">
        <form action="addDepartment" method="post">
            <table>
                <tr>
                    <td>部门名称：</td>
                    <td><input type="text" name="d_name"></td>
                </tr>
            </table>
            <input type="hidden" value="0" name="d_number">
            <input type="submit" value="添加部门">
        </form>
    </div>

    <%--员工管理次级菜单--%>
    <div id="d3" style="display: none;">
        <table>
            <tr>
                <td><input id="i7" type="button" value="显示所有员工"></td>
                <td><input id="i8" type="button" value="部门查询员工"></td>
                <td><input id="i9" type="button" value="职位查询员工"></td>
                <td><input id="i10" type="button" value="发布培训信息"></td>
            </tr>
        </table>
    </div>

    <%--查看所有员工--%>
    <div style="display: none;" id="div7">
        <c:choose>
            <c:when test="${!empty sessionScope.employees}">
                <table border="1" cellpadding="10" cellspacing="0" style="text-align: center">
                    <tr>
                        <td>姓名：</td>
                        <td>年龄：</td>
                        <td>联系方式：</td>
                        <td>邮箱地址：</td>
                        <td>薪资：</td>
                        <td>部门：</td>
                        <td>职位</td>
                        <td>培训</td>
                        <td>状态</td>
                    </tr>
                    <c:forEach var="employee" items="${sessionScope.employees}">
                        <tr>
                            <td>${employee.e_trueName}</td>
                            <td>${employee.e_age}</td>
                            <td>${employee.e_phone}</td>
                            <td>${employee.e_email}</td>
                            <td>${employee.e_salary}</td>
                            <td>${employee.e_department}</td>
                            <td>${employee.e_position}</td>
                            <td>${employee.e_training}</td>
                            <td>${employee.e_state}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                公司还没有员工，去拉人吧
            </c:otherwise>
        </c:choose>
    </div>

    <%--查询部门下所有员工--%>
    <div style="display: none;" id="div8">

    </div>

    <%--查询职位下所有员工--%>
    <div style="display: none;" id="div9">

    </div>

    <%--发布培训信息--%>
    <div style="display: none;" id="div10">

    </div>

    <%--资金管理次级菜单--%>
    <div id="d4" style="display: none;">
        <table>
            <tr>
                <td>资金管理</td>
            </tr>
        </table>
    </div>

    <script>
        $(document).ready(function () {
            $("#d1").hide();
            $("#input1").click(function () {
                $("#d1").show();
                $("#d2").hide();
                $("#d3").hide();
                $("#d4").hide();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#d2").hide();
            $("#input2").click(function () {
                $("#d2").show();
                $("#d1").hide();
                $("#d3").hide();
                $("#d4").hide();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#d3").hide();
            $("#input3").click(function () {
                $("#d3").show();
                $("#d1").hide();
                $("#d2").hide();
                $("#d4").hide();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#d4").hide();
            $("#input4").click(function () {
                $("#d4").show();
                $("#d1").hide();
                $("#d2").hide();
                $("#d3").hide();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div1").hide();
            $("#i1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div2").hide();
            $("#i2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div3").hide();
            $("#i3").click(function () {
                $("#div3").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div4").hide();
            $("#i4").click(function () {
                $("#div4").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div5").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div5").hide();
            $("#i5").click(function () {
                $("#div5").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div6").hide();
                $("#div7").hide()
            });
            $("#div6").hide();
            $("#i6").click(function () {
                $("#div6").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div7").hide()
            });
            $("#div7").hide();
            $("#i7").click(function () {
                $("#div7").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide();
            });
            <c:forEach var="re" items="${sessionScope.recruits}">
            $("#delete${re.r_id}").click(function () {
                var v = confirm("确定要删除吗");
                if(v == true){
                    $("#delete${re.r_id}").attr("type","submit");
                }
            });
            </c:forEach>
            <c:forEach var="de" items="${sessionScope.departments}">
            $("#ch${de.d_id}").click(function () {
                if($("#deNumber${de.d_id}").text() == 0){
                    $("#ch${de.d_id}").attr("type","submit")
                }else {
                    alert("此部门目前有员工无法修改或删除")
                }
            });
            </c:forEach>
            <c:forEach var="de" items="${sessionScope.departments}">
            $("#de${de.d_id}").click(function () {
                if($("#deNumber${de.d_id}").text() == 0){
                    var v = confirm("确定要删除吗");
                    if(v == true){
                        $("#de${de.d_id}").attr("type","submit");
                    }
                }else {
                    alert("此部门目前有员工无法修改或删除")
                }
            });
            </c:forEach>
            <c:forEach var="offer" items="${sessionScope.offers}">
                $("#offerdiv${offer.o_id}").hide();
                $("#show${offer.o_id}").click(function () {
                    $("#offerdiv${offer.o_id}").show()
                });
                $("#hide${offer.o_id}").click(function () {
                    $("#offerdiv${offer.o_id}").hide()
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

    <script>
        $(function () {
            $("#dept").change(function () {
                var d = $(this).val();
                $.ajax({
                    url:"getPositionByD_name",
                    data:{"p_d_id":d},
                    javaType:"json",
                    success:function (positions) {
                        $("#position").empty();
                        var p=eval(positions);
                        var str="";
                        $.each(positions,function (index,value) {
                            str+="<option value="+value.p_id

                                +">"+value.p_name

                                +"</option>"
                        });
                        $("#position").append(str)
                    }
                })
            })
        })
    </script>

</body>
</html>
