<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Pkrdsqb" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>组长查看投票情况</title>

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
&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="refresh" value="刷新" style="height:30px;width:50px"
                               onclick="location.reload()"/>
<p>&nbsp;</p>
<div style="width:100%;height:90%;overflow:auto">
    <table width="98%" border="1" align="center" cellpadding="3" cellspacing="3" style="align:center;">
        <tr bgcolor="ff9900" style="font-weight:bold;">
            <th width="73">学号</th>
            <th width="69">姓名</th>
            <th width="81">二级学院</th>
            <th width="74">班级</th>
            <th width="47">通过</th>
            <th width="47">反对</th>
            <th width="79">投票情况</th>
            <th width="170">申请表状态</th>
            <th colspan="3">操作</th>
        </tr>
        <%
            @SuppressWarnings("unchecked")
            List<Pkrdsqb> list = (List) request.getAttribute("tpqingkuang");
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    Pkrdsqb sqb = list.get(i);
                    //每循环一次后将此时的值保存到对象里
        %>
        <tr style="font-weight:bold;" align="center">
            <td><%=list.get(i).getFullstuNo() %>
            </td>
            <td><%=list.get(i).getStuName() %>
            </td>
            <td><%=list.get(i).getXueyuan()%>
            </td>
            <td><%=list.get(i).getClassName()%>
            </td>
            <td><%=list.get(i).getTongguo()%>
            </td>
            <td><%=list.get(i).getFandui()%>
            </td>
            <td><%=list.get(i).getQingkuang()%>
            </td>
            <td><%=list.get(i).getZhuangtai()%>
            </td>
            <td width="87">
                <a href="servlet/PkrdsqbServlet?action=<%=12 %>&fullstuNo=<%=list.get(i).getFullstuNo()%>">查看申请表</a>
            </td>
            <td width="125"><a href="servlet/PkrdsqbServlet?action=<%=8 %>&fullstuNo=<%=list.get(i).getFullstuNo()%>"
                               onclick="return confirm('确定提交？')">提交至辅导员岗</a>
            </td>
            <td width="111">
                <a href="javascript:void(0)"
                   onclick="window.open('view/page/Bjxz/bjxzzztuihui.jsp?fullstuNo=<%=list.get(i).getFullstuNo()%>','_blank','width=740,height=330,top=250,left=350')"
                   style="color:red">退回并填写不通过理由</a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="11">暂无通过的申请！</td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
