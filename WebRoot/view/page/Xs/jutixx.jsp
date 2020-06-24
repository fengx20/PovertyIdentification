<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Pkrdsqb,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生查看消息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"> 
	function closeWin(){
	       window.opener.location.reload();
	       window.close();
	       }
    </script>
  </head>
  
  <body>
   <%
    @SuppressWarnings("unchecked")
    List<Pkrdsqb>list=(List)request.getAttribute("jutixx");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
            Pkrdsqb sqb=list.get(i);
            %>
    <table width="701" height="251" border="0" align="center">
    <tr>
    <td height="251"><textarea style="width:700px; height:250px;align:center;font-size:15px" name="juti" id="juti" ><%=list.get(i).getJuti()%></textarea></td>
    </tr>
   <%
   }
   }
    %> 
    </table>
    <input type="button" value="确定" onclick="return closeWin()"/>
  </body>
</html>
