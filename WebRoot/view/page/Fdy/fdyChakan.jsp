<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Bj,java.util.List"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>查看所带班级</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<p>&nbsp;</p>
<table width="90%" border="1" align="center" cellpadding="4" cellspacing="4" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
        <th width="312">班级</th>
        <th width="351">学院</th>
        <th width="329" colspan="2">操作</th>
    </tr>
    <%
        @SuppressWarnings("unchecked")
        List<Bj> list = (List) request.getAttribute("suodaibj");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                Bj bj = list.get(i);
                //每循环一次后将此时的值保存到对象里
    %>
    <tr style="font-weight:bold;" align="center">
        <td><%=list.get(i).getClassName()%>
        </td>
        <td><%=list.get(i).getXueyuan()%>
        </td>
        <td><a href="servlet/PkrdsqbServlet?action=<%=9 %>&className=<%=list.get(i).getClassName() %>">查看小组已通过</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="servlet/PkrdsqbServlet?action=<%=26 %>&className=<%=list.get(i).getClassName() %>">查看所有</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="9">数据库中没有数据！</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
