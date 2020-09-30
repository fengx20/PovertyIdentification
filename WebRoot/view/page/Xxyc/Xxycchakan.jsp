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

    <title>系学院处查看整个学院的班级</title>

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
<table width="95%" border="1" align="center" cellpadding="3" cellspacing="3" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
        <th width="304">班级</th>
        <th width="336">学院</th>
        <th width="322" colspan="2">操作</th>
    </tr>
    <%
        @SuppressWarnings("unchecked")
        List<Bj> list = (List) request.getAttribute("xybj");
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
        <td><a href="servlet/PkrdsqbServlet?action=<%=15 %>&className=<%=list.get(i).getClassName() %>">查看已通过</a>
        </td>
        <td>
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
