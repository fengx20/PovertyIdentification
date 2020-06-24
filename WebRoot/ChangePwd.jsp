<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    
    <script type="text/javascript"> 
	
    function queren(){
    var newpassword=document.forms[0].newpassword.value;
    
     if(newpassword.length<=0){
    	alert("请输入新密码！");
    	return false;
     }
     else if(window.confirm("确认修改？")){
       return true;
       }
     else{
       return false;
    }
    	
    }
    </script>
  </head>
  
   <body>
  <%
  String User_no=request.getParameter("user_no");
  System.out.println(User_no);
   %>
  <div id="tab">
  <div class="tab_box"> 
  <label>修改密码</label>
  <p>&nbsp;</p>
   <form name="change" method="post" onSubmit="return queren()" action="<%=path%>/servlet/UserLoginServlet">
   <input type="hidden" name="action" id="action" value="2"/>
        <div id="username">
          <label>学工号：</label>
          <input type="text" id="user_no" value=<%=User_no %> readOnly name="user_no"/>
        </div>
        <div id="password">
          <label>请输入新密码：</label>
          <input type="password" id="newpassword" name="newpassword" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
        <p>&nbsp;</p>
        <input type="submit" name="addPkrdsqb_tj" value="提交" style="height:30px;width:50px"/>
   </form>
   </div>
   </div>
  </body>
</html>
