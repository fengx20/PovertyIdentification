<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系学院处退回辅导员岗</title>
    
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
    <form name="tuihui" method="post" id="form" onSubmit="return comfirm('确认退回？')" action="<%=path%>/servlet/PkrdsqbServlet">
    <input type="hidden" name="action" id="action" value="18"/>
     <input type="hidden" name="fullstuNo" id="fullstuNo" value=<%=request.getParameter("fullstuNo")%>/>
                请填写退回理由：<textarea style="width:700px; height:250px;align:center" name="juti" id="juti" ></textarea>
     <input type="submit" value="提交"/>             
    </form>
  </body>
</html>
