<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加辅导员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" >
    
    function validate()
    {
    var teacherNo=document.forms[0].teacherNo.value;
    var teacherName=document.forms[0].teacherName.value;
    var xueyuan=document.forms[0].xueyuan.value;
    var phoneNum=document.forms[0].phoneNum.value;

    if(teacherNo.length<=0){
    	alert("教师工号不能为空，请输入教师工号！");
    	return false;
    }
    else if(teacherName.length<=0){
    	alert("姓名不能为空，请输入姓名！");
    	return false;
    }
    else if(xueyuan.length<=0){
    	alert("所属院系不能为空，请输入所属院系！");
    	return false;
    }
    else if(phoneNum.length<=0){
    	alert("联系电话不能为空，请输入联系电话！");
    	return false;
    }
    else{
    	return true;
    }
    }
   </script>
  
  </head>
 
  <body>
   <form  method="post" id="form12" onsubmit="return validate()" action="<%=path%>/servlet/FdyServlet" > 
  <input type="hidden" name="action" id="action"  value="1"/>
    <table width="598" height="370" border="1" align="center">
      <tr>
        <td width="189" align="right">教师工号：</td>
        <td width="393" align="left">
        <input type="text" name="teacherNo" id="teacherNo"  style="height:30px;width:250px"/>
        </td>
      </tr>
      <tr>
        <td align="right">姓名：</td>
        <td align="left"><input type="text" name="teacherName" class="{required:true}" id="teacherName" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right">所属院系：</td>
        <td align="left"><input type="text" name="xueyuan" id="xueyuan" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right">联系电话：</td>
        <td align="left"><input type="text" name="phoneNum" id="phoneNum" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit"  name="addFdy_tj" value="添加"  style="height:30px;width:50px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="重置" style="height:30px;width:50px"/></td>
      </tr>
    </table>
   </form> 
  </body>
</html>
