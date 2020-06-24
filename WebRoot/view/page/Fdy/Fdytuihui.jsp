<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>退回申请表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	function validate(){
    
    var reason=document.forms[0].reason.value;
    
    if(reason.length<=0){
    	alert("理由不能为空，请输入理由！");
    	return false;
    }
    if(window.confirm("确定退回？"){
       return true;
    }else{
       return false;    
    }
    }
	</script>

  </head>
  
  <body>
    
    <form name="fdytuihui" method="post" id="form" onSubmit="return validate()" action="<%=path%>/servlet/PkrdsqbServlet">
    <input type="hidden" name="action" id="action" value="14"/>
     <input type="hidden" name="fullstuNo" id="fullstuNo" value=<%=request.getParameter("fullstuNo")%>/>
            请填写退回理由：<textarea style="width:745px; height:300px;align:center;font-size:23" name="juti" id="juti" ></textarea>
     <input type="submit" value="提交"/>       
    </form>
  </body>
</html>
