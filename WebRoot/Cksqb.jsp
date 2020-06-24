<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Pkrdsqb,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看申请表</title>
    
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
    <%
    @SuppressWarnings("unchecked")
    List<Pkrdsqb>list=(List)request.getAttribute("cksqb");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
            Pkrdsqb sqb=list.get(i);
            %>
         
 <table width="745" height="743" border="1" align="center">
    <tr>
      <td colspan="3" align="center" valign="middle">贫困认定申请表</td>
    </tr>
    <tr>
      <td width="221" height="50" align="right" valign="middle">学号:&nbsp;&nbsp;<input type="text" name="fullstuNo" id="fullstuNo" readOnly value="<%=list.get(i).getFullstuNo()%>"  style="height:25px;font-size:15px;width:160px"/></td>
      <td width="259" align="right" valign="middle">姓名:&nbsp;&nbsp;<input type="text" name="stuName" id="stuName" readOnly value="<%=list.get(i).getStuName()%>"  style="height:25px;font-size:15px;width:160px"/></td>
      <td width="253" rowspan="5">&nbsp;</td>
    </tr>
    <tr align="center" valign="middle">
      <td height="50" align="right">性别:&nbsp;&nbsp;<input type="text" name="sex" id="sex" readOnly value="<%=list.get(i).getSex()%>"  style="height: 25px; width: 160px;font-size:15px"/></td>
      <td align="right">出生年月:&nbsp;&nbsp;<input type="text" name="birth" id="birth" readOnly value="<%=list.get(i).getBirth()%>"  style="height:25px;width:160px;font-size:15px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td height="50" align="right">学院:&nbsp;&nbsp;<input type="text" name="xueyuan" id="xueyuan" readOnly value="<%=list.get(i).getXueyuan()%>"  style="height:25px;font-size:15px;width:160px"/></td>
      <td align="right">班级:&nbsp;&nbsp;<input type="text" name="className" id="className" readOnly value="<%=list.get(i).getClassName()%>"  style="height:25px;font-size:15px;width:160px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:&nbsp;&nbsp;<input type="text" name="phoneNum" id="phoneNum" readOnly value="<%=list.get(i).getPhoneNum()%>"  style="height:25px;font-size:15px;width:160px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号:&nbsp;&nbsp;<input type="text" name="idNo" id="idNo" readOnly value="<%=list.get(i).getIdNo()%>"  style="height:25px;font-size:15px;width:160px"/></td>
    </tr>
    <tr>
      <td colspan="3" align="center" valign="middle">家庭人均收入:&nbsp;&nbsp;
        <input type="text" name="money" id="money" readOnly value="<%=list.get(i).getMoney()%>"  style="height:25px;font-size:15px;width:220px"/></td>
    </tr>  
    <tr>
      <td colspan="3">申请认定理由:</td>
    </tr>
    <tr>
      <td colspan="3" height="300" ><textarea style="font-size:18px;width:745px; height:300px" name="reason" readOnly id="reason" ><%=list.get(i).getReason()%></textarea></td>
    </tr>
    
    <%
    }
    }
     %>   
    <tr>
      <td colspan="3" align="center" valign="middle"><input type="button" name="back" value="返回" style="height:30px;width:50px" onclick="window.history.go(-1)"/></td>
    </tr>
  </table>
  </body>
</html>
