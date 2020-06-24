<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Xs" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改学生信息</title>
    
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
       if(window.confirm("确定修改？")){
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
    <td>学号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>班级</td>
    <td>二级学院</td>
    <td>年级</td>
    </tr>
    <tr style="font-weight:bold;" align="center">
    <%
       String stuNo="";
       List<Xs> list=new ArrayList<Xs>();
       list=(ArrayList<Xs>)request.getAttribute("result");
       if(!list.isEmpty()){
       for(int i=0;i<list.size();i++){
            Xs xs=list.get(i);
            stuNo=xs.getStuNo();
            out.print("<td>"+xs.getStuNo()+"</td>");
            out.print("<td>"+xs.getStuName()+"</td>");
            out.print("<td>"+xs.getSex()+"</td>");
            out.print("<td>"+xs.getClassName()+"</td>");
            out.print("<td>"+xs.getXueyuan()+"</td>");
            out.print("<td>"+xs.getGrade()+"</td>"); 
            }
            }
     %>
     </tr>
    </table>
    <p>&nbsp;</p>
    <form name="update" action="<%=path%>/servlet/XsServlet" onsubmit="return confirmdialog()"  method="post" >
    <input type="hidden" name="action" value="6"/>
   <table width="60%" height="370" border="1" align="center">
      <tr>
        <td width="189" align="right">学号：</td>
        <td width="393" align="left">
       <input type="text" name="stuNo" value="<%=stuNo %>" title="学号不能改变" style="height:30px;width:250px"/>
        </td>
      </tr>
      <tr>
        <td align="right">姓名：</td>
        <td align="left"><input type="text" name="stuName" id="stuName" style="height:30px;width:250px"/></td>
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
        <td align="right">年级：</td>
        <td align="left"><input type="text" name="grade" id="grade" style="height:30px;width:250px"/></td>
      </tr>
      <tr>
      <td colspan="2" align="center"><input type="submit" name="updateXs_tj" value="提交" style="height:30px;width:50px"/></td>
      </tr> 
 </table>
  </form>
  </body>
</html>
