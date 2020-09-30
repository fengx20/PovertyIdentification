<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Fdy" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>修改辅导员信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <script type="text/javascript">
        function confirmdialog() {
            if (window.confirm("确定修改？")) {
                return true;
            } else {
                return false;
            }
        }
    </script>

</head>

<body>
<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold" align="center">
        <td>教师工号</td>
        <td>姓名</td>
        <td>所属学院</td>
        <td>联系电话</td>
    </tr>
    <tr style="font-weight:bold;" align="center">
        <%
            String teacherNo = "";
            List<Fdy> list = new ArrayList<Fdy>();
            list = (ArrayList<Fdy>) request.getAttribute("result");
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    Fdy fdy = list.get(i);
                    teacherNo = fdy.getTeacherNo();
                    out.print("<td>" + fdy.getTeacherNo() + "</td>");
                    out.print("<td>" + fdy.getTeacherName() + "</td>");
                    out.print("<td>" + fdy.getXueyuan() + "</td>");
                    out.print("<td>" + fdy.getPhoneNum() + "</td>");
                }
            }
        %>
    </tr>
</table>
<p>&nbsp;</p>
<form name="update" action="<%=path%>/servlet/FdyServlet" onsubmit="return confirmdialog()" method="post">
    <input type="hidden" name="action" value="6"/>
    <table width="60%" height="370" border="1" align="center">
        <tr>
            <td width="189" align="right">教师工号：</td>
            <td width="393" align="left">
                <input type="text" name="teacherNo" value="<%=teacherNo %>" title="教职工号不能改变"
                       style="height:30px;width:250px"/>
            </td>
        </tr>
        <tr>
            <td align="right">姓名：</td>
            <td align="left"><input type="text" name="teacherName" id="teacherName" style="height:30px;width:250px"/>
            </td>
        </tr>
        <tr>
            <td align="right">所属学院：</td>
            <td align="left"><input type="text" name="xueyuan" id="xueyuan" style="height:30px;width:250px"/></td>
        </tr>
        <tr>
            <td align="right">联系电话：</td>
            <td align="left"><input type="text" name="phoneNum" id="phoneNum" style="height:30px;width:250px"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="updateFdy_tj" value="确定"
                                                  style="height:30px;width:50px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                    type="button" name="fanhui" value="返回" style="height:30px;width:50px"
                    onclick="window.history.go(-1)"/></td>
        </tr>
    </table>
</form>
</body>
</html>
