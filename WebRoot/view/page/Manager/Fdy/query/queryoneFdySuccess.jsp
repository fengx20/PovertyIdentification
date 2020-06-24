<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Fdy,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询单个辅导员</title>
    
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
     <th width="266">教师工号</th>
     <th width="104">姓名</th>
     <th width="104">所属院系</th>
     <th width="104">联系电话</th>
     <th width="100" colspan="2">操作</th>
    </tr>
   <%
   //循环显示数据
   @SuppressWarnings("unchecked")
    List<Fdy>list=(List)request.getAttribute("fdy1"); // 取request里面的对象队列
    if(list.size()!=0){
      for(int i=0;i<list.size();i++){
      Fdy fdy=new Fdy(); //新建对象
      fdy=list.get(i);   //每循环一次后将此时的值保存到对象里
      
   %>
   <tr style="font-weight:bold;" align="center">
      <td><%=list.get(i).getTeacherNo() %></td> 
      <td><%=list.get(i).getTeacherName() %></td>
      <td><%=list.get(i).getXueyuan()%></td>
      <td><%=list.get(i).getPhoneNum()%></td>
       <td><a href="servlet/FdyServlet?action=<%=5 %>&teacherNo=<%=list.get(i).getTeacherNo()%>" >修改</a>
      </td>
       <td><a href="servlet/FdyServlet?action=<%=2 %>&teacherNo=<%=list.get(i).getTeacherNo()%>" onclick="confirmdialog()">删除</a>
      </td>
   </tr>
   <%
   }
   }
    %>
   </table>
   <p>&nbsp;&nbsp;</p>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="servlet/FdyServlet?action=<%=3 %>" onClick="save()">返回列表并刷新</a> 
  </body>
</html>
