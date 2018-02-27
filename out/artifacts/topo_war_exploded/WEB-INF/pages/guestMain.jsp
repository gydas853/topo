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
                <td><input id="in4" type="button" value="我的面试邀请"></td>
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
                            <input type="hidden" name="o_v_name" value="${sessionScope.vitae.v_name}">
                            <input type="hidden" name="o_r_id" value="${recruit.r_id}">
                            <input type="hidden" name="o_g_id" value="${sessionScope.vitae.v_g_id}">
                            <input type="hidden" name="o_state" value="0">
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
        <c:choose>
            <c:when test="${empty sessionScope.vitae}">
                <form action="addVitae" method="post">
                    <table>
                        <tr>
                            <td>姓名：</td>
                            <td><input type="text" name="v_name"></td>
                            <td>性别：</td>
                            <td><input type="text" name="v_sex"></td>
                        </tr>
                        <tr>
                            <td>年龄：</td>
                            <td><input type="text" name="v_age"></td>
                            <td>生日：</td>
                            <td><input type="text" name="v_birth"></td>
                        </tr>
                        <tr>
                            <td>民族：</td>
                            <td><input type="text" name="v_ethnicity"></td>
                            <td>籍贯：</td>
                            <td><input type="text" name="v_nativePlace"></td>
                        </tr>
                        <tr>
                            <td>学历：</td>
                            <td><input type="text" name="v_qualification"></td>
                            <td>邮箱地址：</td>
                            <td><input type="text" name="v_email"></td>
                        </tr>
                        <tr>
                            <td>联系电话：</td>
                            <td><input type="text" name="v_tel"></td>
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
            </c:when>
            <c:otherwise>
                已有简历，无需新建
            </c:otherwise>
        </c:choose>
    </div>

    <%--查看我的简历--%><%--这里也没问题了--%>
    <div style="display: none" id="div4">
        <c:choose>
            <c:when test="${!empty sessionScope.vitae}">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td>${sessionScope.vitae.v_name}</td>
                        <td>性别：</td>
                        <td>${sessionScope.vitae.v_sex}</td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td>${sessionScope.vitae.v_age}岁</td>
                        <td>生日：</td>
                        <td>${sessionScope.vitae.v_birth}</td>
                    </tr>
                    <tr>
                        <td>民族：</td>
                        <td>${sessionScope.vitae.v_ethnicity}</td>
                        <td>籍贯：</td>
                        <td>${sessionScope.vitae.v_nativePlace}</td>
                    </tr>
                    <tr>
                        <td>学历：</td>
                        <td>${sessionScope.vitae.v_qualification}</td>
                        <td>邮箱地址：</td>
                        <td>${sessionScope.vitae.v_email}</td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td>${sessionScope.vitae.v_tel}</td>
                        <td>专业：</td>
                        <td>${sessionScope.vitae.v_specialty}</td>
                    </tr>
                    <tr>
                        <td>工作经验：</td>
                        <td>${sessionScope.vitae.v_serviceYear}</td>
                        <td>意向工作地点：</td>
                        <td>${sessionScope.vitae.v_willSpot}</td>
                    </tr>
                    <tr>
                        <td>到岗时间：</td>
                        <td>${sessionScope.vitae.v_adsumDate}</td>
                        <td>希望从事的行业：</td>
                        <td>${sessionScope.vitae.v_promisingIndustry}</td>
                    </tr>
                    <tr>
                        <td>
                            <input id="in5" type="button" value="修改简历" style="float: left">
                            <form action="deleteVitae" method="post" style="float: left">
                                <input type="hidden" value="${sessionScope.vitae.v_id}" name="v_id">
                                <input type="hidden" value="${sessionScope.vitae.v_g_id}" name="v_g_id">
                                <input id="in8" type="button" value="删除简历">
                            </form>
                        </td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                尚无简历信息，请创建简历
            </c:otherwise>
        </c:choose>
    </div>

    <%--查看我的面试邀请--%><%--需要进行循环操作 因为面试邀请不可能只有一个--%>
    <div style="display: none;" id="div5">
        <c:choose>
            <c:when test="${!empty sessionScope.interview}">
                <table>
                    <tr>
                        <td>面试职位：</td>
                        <td>${sessionScope.interview.i_r_name}</td>
                    </tr>
                    <tr>
                        <td>面试公司：</td>
                        <td>${sessionScope.interview.i_c_name}</td>
                    </tr>
                    <tr>
                        <td>面试时间：</td>
                        <td>${sessionScope.interview.i_interviewTime}</td>
                    </tr>
                    <tr>
                        <td>面试地点：</td>
                        <td>${sessionScope.interview.i_interviewAddress}</td>
                    </tr>
                </table>
                <form action="employ" method="post">
                    <input type="hidden" value="${sessionScope.interview.i_g_id}" name="i_g_id">
                    <input type="hidden" value="${sessionScope.interview.i_r_id}" name="i_r_id">
                    <input id="in9" type="button" value="确认面试">
                </form>
            </c:when>
            <c:otherwise>
                面试已通过或暂未收到任何面试邀请
            </c:otherwise>
        </c:choose>
    </div>

    <%--修改我的简历--%><%--这个没问题了--%>
    <div style="display: none;" id="div6">
        <form action="changeVitae" method="post">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="v_name" value="${sessionScope.vitae.v_name}"></td>
                        <td>性别：</td>
                        <td><input type="text" name="v_sex" value="${sessionScope.vitae.v_sex}"></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="v_age" value="${sessionScope.vitae.v_age}"></td>
                        <td>生日：</td>
                        <td><input type="text" name="v_birth" value="${sessionScope.vitae.v_birth}"></td>
                    </tr>
                    <tr>
                        <td>民族：</td>
                        <td><input type="text" name="v_ethnicity" value="${sessionScope.vitae.v_ethnicity}"></td>
                        <td>籍贯：</td>
                        <td><input type="text" name="v_nativePlace" value="${sessionScope.vitae.v_nativePlace}"></td>
                    </tr>
                    <tr>
                        <td>学历：</td>
                        <td><input type="text" name="v_qualification" value="${sessionScope.vitae.v_qualification}"></td>
                        <td>邮箱地址：</td>
                        <td><input type="text" name="v_email" value="${sessionScope.vitae.v_email}"></td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td><input type="text" name="v_tel" value="${sessionScope.vitae.v_tel}"></td>
                        <td>专业：</td>
                        <td><input type="text" name="v_specialty" value="${sessionScope.vitae.v_specialty}"></td>
                    </tr>
                    <tr>
                        <td>工作经验：</td>
                        <td><input type="text" name="v_serviceYear" value="${sessionScope.vitae.v_serviceYear}"></td>
                        <td>意向工作地点：</td>
                        <td><input type="text" name="v_willSpot" value="${sessionScope.vitae.v_willSpot}"></td>
                    </tr>
                    <tr>
                        <td>到岗时间：</td>
                        <td><input type="text" name="v_adsumDate" value="${sessionScope.vitae.v_adsumDate}"></td>
                        <td>希望从事的行业：</td>
                        <td><input type="text" name="v_promisingIndustry" value="${sessionScope.vitae.v_promisingIndustry}"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" value="${sessionScope.vitae.v_id}" name="v_id">
                            <input type="hidden" value="${sessionScope.vitae.v_g_id}" name="v_g_id">
                            <input id="in7" type="button" value="确认修改">
                            <input id="in6" type="button" value="取消修改">
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
                $("#div5").hide();
            });
            $("#in6").click(function () {

                $("#div1").hide();
                $("#div2").hide();
                $("#div4").hide();
                $("#div5").hide();
                $("#div6").hide()
            });
            $("#in7").click(function () {
                var v = confirm("确定修改吗?");
                if(v == true){
                    $("#in7").attr("type","submit");
                }
            });
            $("#in8").click(function () {
                var v = confirm("确定删除吗");
                if(v == true){
                    $("#in8").attr("type","submit");
                }
            });
            $("#in9").click(function () {
                alert("面试通过，欢迎加入我们公司");
                alert("请以员工身份登录系统，谢谢配合");
                $("#in9").attr("type","submit")
            });
            $("#inp1").click(function () {
                if(${empty sessionScope.vitae}){
                    $("#inp1").attr("type","submit")
                }else {
                    alert("已有简历，不能新建");
                    alert("修改已有简历或删除当前简历再创建")
                }
            });

            <c:forEach var="re" items="${sessionScope.recruits}">
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
