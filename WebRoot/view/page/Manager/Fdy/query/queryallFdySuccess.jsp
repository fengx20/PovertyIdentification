<%@ page language="java" import="java.util.*,java.util.List,com.wzxy.povertyidentification.bean.Fdy" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看所有辅导员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	 function openAdd(){
	      window.open(href="<%=path%>/view/page/Manager/Fdy/add/addFdyWin.jsp","_blank","width=700,height=400,top=200,left=400");
     }
        
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
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" style="align:center;">
   <tr>
    <th width="9%" align="left">
        <input type="button" name="refresh" value="刷新" style="height:30px;width:50px" onclick="location.reload()"/>
    </th>
    <th width="17%" align="left">    
        <a href="javascript:void(0)" onclick="openAdd();" style="color:red">添加辅导员信息</a>
    </th>
    <th width="74%" align="left" valign="bottom">    
        <form name="chazhao" method="post" action="<%=path%>/servlet/FdyServlet">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="hidden" name="action" value="4"/>
        <input type="text" name="teacherNo" id="teacherNo" style="height:30px;width:200px" />
        <input type="submit" name="chazhao_fdy" style="height:30px;width:50px" value="查找"/>
        </form>
    </th>
   </tr>
  </table>
   <div style="width:100%;height:90%;overflow:auto">
    <table width="95%" border="1" align="center" cellpadding="3" cellspacing="3" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
     <th width="227" height="32">教师工号</th>
     <th width="117">姓名</th>
     <th width="267">所属院系</th>
     <th width="147">联系电话</th>
     <th colspan="2">操作</th>
    </tr>
   <%
   //循环显示数据
   @SuppressWarnings("unchecked")
    List<Fdy>list=(List)request.getAttribute("list"); // 取request里面的对象队列
    if(list.size()!=0){
      for(int i=0;i<list.size();i++){
      Fdy fdy=new Fdy(); //新建对象
      fdy=list.get(i);   //每循环一次后将此时的值保存到对象里
   %>
   <tr style="font-weight:bold;" align="center">
      <td height="41"><%=list.get(i).getTeacherNo() %></td> 
      <td><%=list.get(i).getTeacherName() %></td>
      <td><%=list.get(i).getXueyuan()%></td>
      <td><%=list.get(i).getPhoneNum()%></td>
       <td width="113"><a href="servlet/FdyServlet?action=<%=5 %>&teacherNo=<%=list.get(i).getTeacherNo()%>" >修改</a>
       </td>
       <td width="113"><a href="servlet/FdyServlet?action=<%=2 %>&teacherNo=<%=list.get(i).getTeacherNo()%>" onclick="confirmdialog()" >删除</a>
       </td>
   </tr>
  <%
      }
    }else{
  %>
    <tr><td colspan="8">数据库中没有数据！</td></tr>
  <%
     }
  %> 
</table>
</div>
  </body>
</html>
