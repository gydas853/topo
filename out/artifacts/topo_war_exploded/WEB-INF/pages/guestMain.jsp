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
    <p>欢迎${sessionScope.guest.g_name}</p>
    <div>
        <table>
            <tr>
                <td><input id="in1" type="button" value="查看招聘信息"></td>
                <td><input id="in2" type="button" value="创建简历"></td>
                <td><input id="in3" type="button" value="查看我的简历"></td>
                <td><a href="forSystem"><input type="button" value="返回主界面"></a></td>
            </tr>
        </table>
    </div>
    <%--查看招聘信息  功能都结束 暂不能应聘--%>
    <div style="display: none;" id="div1">
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
                <tr>
                    <td>${recruit.r_name}</td>
                    <td>${recruit.company.c_name}</td>
                    <td>${recruit.department.d_name}</td>
                    <td>${recruit.position.p_name}</td>
                    <td>${recruit.r_money}</td>
                    <td>${recruit.company.c_address}</td>
                    <td>${recruit.company.c_companyScale}</td>
                    <td>${recruit.company.c_phone}</td>
                    <td>
                        <form action="offerToJob" method="post">
                            <input type="hidden" name="r_id" value="${sessionScope.recruit.r_id}">
                            <input type="hidden" name="v_id" value="${sessionScope.vitae.v_id}">
                            <input type="button" id="input${recruit.r_id}" value="应聘这份工作">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            SORRY，暂无招聘信息
        </c:otherwise>
    </c:choose>
    </div>
    <%--创建简历--%><%--可以创建 但空也能创建--%>
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
                    <td>专业：</td>
                    <td><input type="text" name="v_specialty"></td>
                </tr>
                <tr>
                    <td>工作经验：</td>
                    <td><input type="text" name="v_serviceYear"></td>
                    <td>意向工作地点：</td>
                    <td><input type="text" name="v_willSpot"></td>
                </tr>
                <tr>
                    <td>到岗时间：</td>
                    <td><input type="text" name="v_adsumDate"></td>
                    <td>希望从事的行业：</td>
                    <td><input type="text" name="v_promisingIndustry"></td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" value="${sessionScope.guest.g_id}" name="v_g_id">
                        <input id="inp1" type="button" value="确认创建简历">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%--查看我的简历--%><%--这里也没问题了，美化没做--%>
    <div style="display: none" id="div3">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td>${vitae.v_name}</td>
                    <td>性别：</td>
                    <td>${vitae.v_sex}</td>
                </tr>
                <tr>
                    <td>生日：</td>
                    <td>${vitae.v_birth}</td>
                    <td>民族：</td>
                    <td>${vitae.v_ethnicity}</td>
                </tr>
                <tr>
                    <td>籍贯：</td>
                    <td>${vitae.v_nativePlace}</td>
                    <td>学历：</td>
                    <td>${vitae.v_qualification}</td>
                </tr>
                <tr>
                    <td>联系电话：</td>
                    <td>${vitae.v_tel}</td>
                </tr>
                <tr>
                    <td>邮箱地址：</td>
                    <td>${vitae.v_email}</td>
                    <td>专业：</td>
                    <td>${vitae.v_specialty}</td>
                </tr>
                <tr>
                    <td>工作经验：</td>
                    <td>${vitae.v_serviceYear}</td>
                    <td>意向工作地点：</td>
                    <td>${vitae.v_willSpot}</td>
                </tr>
                <tr>
                    <td>到岗时间：</td>
                    <td>${vitae.v_adsumDate}</td>
                    <td>希望从事的行业：</td>
                    <td>${vitae.v_promisingIndustry}</td>
                </tr>
                <tr>
                    <td>
                        <input id="in4" type="button" value="修改简历">
                        <a href="deleteVitae?v_id=${sessionScope.vitae.v_id}"><input type="button" value="删除简历"></a>
                    </td>
                </tr>
            </table>
    </div>
    <%--修改我的简历--%><%--这里可以改的更好点--%>
    <div style="display: none;" id="div4">
        <form action="changeVitae" method="post">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="v_name" value="${vitae.v_name}"></td>
                        <td>性别：</td>
                        <td><input type="text" name="v_sex" value="${vitae.v_sex}"></td>
                    </tr>
                    <tr>
                        <td>生日：</td>
                        <td><input type="text" name="v_birth" value="${vitae.v_birth}"></td>
                        <td>民族：</td>
                        <td><input type="text" name="v_ethnicity" value="${vitae.v_ethnicity}"></td>
                    </tr>
                    <tr>
                        <td>籍贯：</td>
                        <td><input type="text" name="v_nativePlace" value="${vitae.v_nativePlace}"></td>
                        <td>学历：</td>
                        <td><input type="text" name="v_qualification" value="${vitae.v_qualification}"></td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td><input type="text" name="v_tel" value="${vitae.v_tel}"></td>
                    </tr>
                    <tr>
                        <td>邮箱地址：</td>
                        <td><input type="text" name="v_email" value="${vitae.v_email}"></td>
                    </tr>
                    <tr>
                        <td>专业：</td>
                        <td><input type="text" name="v_specialty" value="${vitae.v_specialty}"></td>
                        <td>工作经验：</td>
                        <td><input type="text" name="v_serviceYear" value="${vitae.v_serviceYear}"></td>
                    </tr>
                    <tr>
                        <td>意向工作地点：</td>
                        <td><input type="text" name="v_willSpot" value="${vitae.v_willSpot}"></td>
                        <td>到岗时间：</td>
                        <td><input type="text" name="v_adsumDate" value="${vitae.v_adsumDate}"></td>
                    </tr>
                    <tr>
                        <td>希望从事的行业：</td>
                        <td><input type="text" name="v_promisingIndustry" value="${vitae.v_promisingIndustry}"></td>
                        <td>
                            <input type="hidden" value="${vitae.v_id}" name="v_id">
                            <input id="in6" type="button" value="确认修改">
                            <input id="in5" type="button" value="取消修改">
                        </td>
                    </tr>
                </table>
        </form>
    </div>
    <script>
        $(document).ready(function () {
            $("#div1").hide();
            $("#in1").click(function () {
                $("#div1").show();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide()
            });
            $("#div2").hide();
            $("#in2").click(function () {
                $("#div2").show();
                $("#div1").hide();
                $("#div3").hide();
                $("#div4").hide()
            });
            $("#div3").hide();
            $("#in3").click(function () {
                $("#div3").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide()
            });
            $("#div4").hide();
            $("#in4").click(function () {
                $("#div4").show();
                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide()
            });
            $("#in5").click(function () {

                $("#div1").hide();
                $("#div2").hide();
                $("#div3").hide();
                $("#div4").hide()
            });
            $("#in6").click(function () {
                var v = confirm("确定修改吗?");
                if(v == true){
                    $("#in6").attr("type","submit");
                }
            });

            $("#inp1").click(function () {
                alert("dslfsaoidfuosadfasfd");
                if(${empty sessionScope.vitae}){
                    $("#input1").attr("type","submit")
                }else {
                    alert("已有简历，不能新建");
                    alert("修改已有简历或删除当前简历再创建")
                }
            });

            <c:forEach var="re" items="${recruits}">
                $("#input${re.r_id}").click(function () {
                    var v = confirm("确定应聘吗？");
                    if(v == true){
                        $("#input${re.r_id}").attr("type","submit");
                    }
                });
            </c:forEach>
        });
    </script>
</body>
</html>
