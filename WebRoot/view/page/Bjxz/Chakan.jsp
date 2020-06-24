<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Toupiao,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小组成员查看班级</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <!-- 在xsxx中查询与pkrdsqbxx相同主键的数据输出来，点击“查看申请”弹出窗口（将主键数据传值给servlet执行方法到pkrdsqbxx查找然后输出到窗口Toupiao.jsp查看并投票） -->
  
  <body>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="refresh" value="刷新" style="height:30px;width:50px" onclick="location.reload()"/>
    <p>&nbsp;</p>
    <div style="width:100%;height:90%;overflow:auto">
    <table width="95%" border="1" align="center" cellpadding="3" cellspacing="3" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
     <th width="139">学号</th>
     <th width="59">姓名</th>
     <th width="59">性别</th>
     <th width="59">班级</th>
     <th width="109">二级学院</th>
     <th width="46">投票状态</th>
     <th width="71" colspan="2">操作</th>
    </tr> 
   <%
    @SuppressWarnings("unchecked")
    List<Toupiao>list=(List)request.getAttribute("bbxs_ytj");
    String BjcystuNo=(String)request.getAttribute("bjcystuNo");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
            Toupiao tp=list.get(i);
         //每循环一次后将此时的值保存到对象里
   %>
   <tr style="font-weight:bold;" align="center">
      <td><%=list.get(i).getXs() %></td> 
      <td><%=list.get(i).getXsName() %></td>
      <td><%=list.get(i).getSex()%></td>
      <td><%=list.get(i).getClassName()%></td>
      <td><%=list.get(i).getXueyuan()%></td>
      <td><%=list.get(i).getZhuangtai()%></td>
       <td><a href="servlet/PkrdsqbServlet?action=<%=5 %>&fullstuNo=<%=list.get(i).getXs()%>&bjcystuNo=<%=BjcystuNo%>" >查看申请书并投票</a>
      </td>
   </tr>
  <%
      }
    }else{
  %>
    <tr><td colspan="9">数据库中没有数据！</td></tr>
  <%
    }
  %> 
  </table>
  </div>
  </body>
</html>
