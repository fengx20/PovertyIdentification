<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Pkrdsqb,java.util.List" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小组成员投票</title>
    
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
    var Toupiao=document.forms[0].toupiao.value;
    
     if(Toupiao.length<=0){
    	alert("请投票！");
    	return false;
     }else{ 
    	return true;
     }	
    }
    </script>
    
    <style type="text/css">
  #form table {
	font-family: "微软雅黑";
	
  }
  </style>

  </head>
  <body>
   <%
    @SuppressWarnings("unchecked")
    List<Pkrdsqb>list=(List)request.getAttribute("cksqb");
    String BjcystuNo=(String)request.getAttribute("bjcystuNo");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
            Pkrdsqb sqb=list.get(i);
            %>
            
  <form name="addPkrdsqb" method="post" id="form" onSubmit="return validate()"  action="<%=path%>/servlet/PkrdsqbServlet">
  <input type="hidden" name="action" id="action" value="6"/>
   <input type="hidden" name="className" value=<%=list.get(i).getClassName()%> id="bjcystuNo" />
  <input type="hidden" name="bjcystuNo" value=<%=BjcystuNo %> id="bjcystuNo" />
  <table width="745" height="743" border="1" align="center">
    <tr>
      <td colspan="3" align="center" valign="middle">贫困认定申请表</td>
    </tr>
    <tr>
      <td width="221" height="50" align="right" valign="middle">学号:&nbsp;&nbsp;<input type="text" name="fullstuNo" readOnly id="fullstuNo" value="<%=list.get(i).getFullstuNo()%>"  style="height:25px;width:160px;font-size:15px"/></td>
      <td width="259" align="right" valign="middle">姓名:&nbsp;&nbsp;<input type="text" name="stuName" id="stuName" readOnly value="<%=list.get(i).getStuName()%>"  style="height25px;width:160px;font-size:15px"/></td>
      <td width="253" rowspan="5">&nbsp;</td>
    </tr>
    <tr align="center" valign="middle">
      <td height="50" align="right">性别:&nbsp;&nbsp;<input type="text" name="sex" id="sex" readOnly value="<%=list.get(i).getSex()%>"  style="height:25px;width:160px;font-size:15px"/></td>
      <td align="right">出生年月:&nbsp;&nbsp;<input type="text" name="birth" id="birth" readOnly value="<%=list.get(i).getBirth()%>"  style="height:25px;width:160px;font-size:15px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td height="50" align="right">学院:&nbsp;&nbsp;<input type="text" name="xueyuan" id="xueyuan" readOnly value="<%=list.get(i).getXueyuan()%>"  style="height:25px;width:160px;font-size:15px"/></td>
      <td align="right">班级:&nbsp;&nbsp;<input type="text" name="className" id="className" readOnly value="<%=list.get(i).getClassName()%>"  style="height:25px;width:160px;font-size:15px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:&nbsp;&nbsp;<input type="text" name="phoneNum" readOnly id="phoneNum" value="<%=list.get(i).getPhoneNum()%>"  style="height:25px;width:160px;font-size:15px"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号:&nbsp;&nbsp;<input type="text" name="idNo" id="idNo" readOnly value="<%=list.get(i).getIdNo()%>"  style="height:25px;width:160px;font-size:15px"/></td>
    </tr>
    <tr>
      <td colspan="3" align="center" valign="middle">家庭人均收入:&nbsp;&nbsp;
        <input type="text" name="money" id="money" readOnly value="<%=list.get(i).getMoney()%>"  style="height:25px;width:220px;font-size:15px"/></td>
    </tr>  
    <tr>
      <td colspan="3">申请认定理由:</td>
    </tr>
    <tr>
      <td colspan="3" height="300" ><textarea style="width:745px; height:300px;font-size:20px" name="reason" readOnly id="reason" ><%=list.get(i).getReason()%></textarea></td>
    </tr>
    <%
    }
    }
     %>   
    <tr>
    <td colspan="3" align="center" valign="middle"><input type="radio" name="toupiao" id="toupiao" value="tongguo" />通过&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="toupiao" id="toupiao" value="fandui" />反对</td>
    </tr>
    <tr>
      <td colspan="3" align="center" valign="middle"><input type="submit" name="toupiao_tj" value="提交" style="height:30px;width:50px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="back" value="返回" style="height:30px;width:50px" onclick="window.history.go(-1)"/></td>
    </tr>
  </table>
  </form>         
  </body>
</html>
