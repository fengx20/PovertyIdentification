<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Xs,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询单个学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	function confirmdialog(){
       if(window.confirm("您确定要删除此条信息？")){
          return true;
       }
       else{
          return false;
       }      
    }
    </script>

  </head>
  
  <body>
    <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
     <th width="266">学号</th>
     <th width="104">姓名</th>
     <th width="104">性别</th>
     <th width="104">班级</th>
     <th width="205">二级学院</th>
     <th width="106">年级</th>
     <th width="100" colspan="2">操作</th>
    </tr>
    
    <%
    @SuppressWarnings("unchecked")
    List<Xs>list=(List)request.getAttribute("xs1");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
            Xs xs=list.get(i);
            %>
      <tr style="font-weight:bold;" align="center">      
      <td><%=list.get(i).getStuNo() %></td> 
      <td><%=list.get(i).getStuName() %></td>
      <td><%=list.get(i).getSex()%></td>
      <td><%=list.get(i).getClassName()%></td>
      <td><%=list.get(i).getXueyuan()%></td>
      <td><%=list.get(i).getGrade()%></td>
      <td><a href="servlet/XsServlet?action=<%=5 %>&stuNo=<%=list.get(i).getStuNo()%>">修改</a>
      </td>
      <td><a href="servlet/XsServlet?action=<%=2 %>&stuNo=<%=list.get(i).getStuNo()%>" onclick="confirmdialog()">删除</a>
      </td>
     </tr>
     <%
     }
     }
      %>
   </table>
   <p>&nbsp;&nbsp;</p>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="servlet/XsServlet?action=<%=3 %>"   onClick="save()">返回列表并刷新</a> 
  </body>
</html>
