<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Pkrdsqb,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学工处查看</title>
    
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
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="refresh" value="刷新" style="height:30px;width:50px" onclick="location.reload()"/>
    <p>&nbsp;</p>
    <table width="95%" border="1" align="center" cellpadding="3" cellspacing="3" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
     <th width="139">学号</th>
     <th width="59">姓名</th>
     <th width="109">学院</th>
     <th width="59">班级</th>
     <th           >申请表状态</th>
     <th width="71" colspan="2">操作</th>
    </tr>
   <%
    @SuppressWarnings("unchecked")
    List<Pkrdsqb>list=(List)request.getAttribute("xgcchakan");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
           Pkrdsqb sqb=list.get(i);
         //每循环一次后将此时的值保存到对象里
   %>
   <tr style="font-weight:bold;" align="center">
      <td><%=list.get(i).getFullstuNo() %></td> 
      <td><%=list.get(i).getStuName() %></td>
      <td><%=list.get(i).getXueyuan()%></td>
      <td><%=list.get(i).getClassName()%></td>
      <td><%=list.get(i).getZhuangtai()%></td>
      <td>
      <a href="servlet/PkrdsqbServlet?action=<%=12 %>&fullstuNo=<%=list.get(i).getFullstuNo()%>">查看申请表</a>    
      </td>
      <td>
      <a href="servlet/PkrdsqbServlet?action=<%=23 %>&fullstuNo=<%=list.get(i).getFullstuNo()%>" onclick="return confirm('确认通过？')" >审核通过</a>
      </td>
   </tr>
  <%
      }
    }else{
  %>
    <tr><td colspan="9">数据库中没有数据！</td></tr>
  <%
    }
  %> 
  </table>
  </body>
</html>
