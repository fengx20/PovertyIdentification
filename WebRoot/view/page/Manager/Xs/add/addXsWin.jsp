<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学生窗口</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript"> 
    function validate()
    {
    var stuNo=document.forms[0].stuNo.value;
    var stuName=document.forms[0].stuName.value;
    var sex=document.forms[0].sex.value;
    var className=document.forms[0].className.value;
    var xueyuan=document.forms[0].xueyuan.value;
    var grade=document.forms[0].grade.value;
    if(stuNo.length<=0){
    	alert("学号不能为空，请输入学号！");
    	return false;
    }
    else if(stuName.length<=0){
    	alert("姓名不能为空，请输入姓名！");
    	return false;
    }
    else if(sex.length<=0){
    	alert("性别不能为空，请输入性别！");
    	return false;
    }
    else if(className.length<=0){
    	alert("班级不能为空，请输入班级！");
    	return false;
    }
    else if(xueyuan.length<=0){
        alert("二级学院不能为空，请输入二级学院!");
        return false;
    }
    else if(grade.length<=0){
        alert("年级不能为空，请输入年级!");
        return false;
    }
    }else{
    	return true;
    }	
    }
   </script>

  </head>
  
  <body>
    <form name="addXs" method="post" id="form" onSubmit="return validate()" action="<%=path%>/servlet/XsServlet">
  <input type="hidden" name="action" id="action" value="10"/>
    <table width="598" height="370" border="1" align="center">
      <tr>
        <td width="189" align="right">学号：</td>
        <td width="393" align="left">
        <input type="text" name="stuNo" id="stuNo"  style="height:30px;width:250px"/>
        </td>
      </tr>
      <tr>
        <td align="right">姓名：</td>
        <td align="left"><input type="text" name="stuName" class="{required:true}" id="stuName" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right">性别：</td>
        <td align="left"><input type="text" name="sex" id="sex" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right">班级：</td>
        <td align="left"><input type="text" name="className" id="className" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right">二级学院：</td>
        <td align="left"><input type="text" name="xueyuan" id="xueyuan" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td align="right"> 年级：</td>
        <td align="left"><input type="text" name="grade" id="grade" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="addXs_tj" value="添加" style="height:30px;width:50px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="重置" style="height:30px;width:50px"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
