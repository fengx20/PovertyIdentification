<%@ page language="java" import="java.util.*,com.wzxy.povertyidentification.bean.Xs,java.util.List" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级小组成员登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/tendina.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
  </head>
  
  <!--  班级小组成员的页面-->
  
  <body>
    <!--顶部-->
    <div class="layout_top_header">
             <div style="float: left"><span style="font-size: 20px;line-height: 45px;padding-left: 20px;color:#FFFFFF">贫困认定管理系统</span></div>
            <div id="ad_setting" class="ad_setting">
                <a class="ad_setting_a" href="javascript:; ">
                    <i class="icon-user glyph-icon" style="font-size: 20px"></i>
                    <span><%=request.getAttribute("fullstuNo") %>(小组组员)</span>
                    <i class="icon-chevron-down glyph-icon"></i>
                </a>
                <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                <li class="ad_setting_ul_li"> <a href="ChangePwd.jsp?user_no=+<%=request.getAttribute("fullstuNo") %>" target="menuFrame"><i class="icon-cog glyph-icon"></i>修改密码</a></li>
                    <li class="ad_setting_ul_li"> <a href="login.jsp"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
                </ul>
            </div>
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <%
  @SuppressWarnings("unchecked")
    List<Xs>list=(List)request.getAttribute("className");
    String BjcystuNo=(String)request.getAttribute("fullstuNo");
     if(list.size()!=0){
       for(int i=0;i<list.size();i++){
           Xs xs=list.get(i);
    %>
    <div class="layout_left_menu">
        <ul id="menu">
            <li class="childUlLi">
               <a href="welcome.jsp" target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
            </li>
            <li class="childUlLi">
                <a href=""  target="menuFrame"> <i class="glyph-icon icon-reorder"></i>申请表投票</a>
                <ul>
                    <li><a href="servlet/PkrdsqbServlet?action=<%=4 %>&className=<%=list.get(i).getClassName()%>&bjcystuNo=<%=request.getAttribute("fullstuNo") %>" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>本班申请表</a></li>   
                </ul>
            </li>
        </ul>
    </div>
    <!--菜单-->
    <div id="layout_right_content" class="layout_right_content">

        <div class="route_bg">
            <a href="welcome.jsp" target="menuFrame">主页</a><i class="glyph-icon icon-chevron-right"></i>
            <a href="servlet/PkrdsqbServlet?action=<%=4 %>&className=<%=list.get(i).getClassName()%>&bjcystuNo=<%=request.getAttribute("fullstuNo") %>" target="menuFrame">查看本班申请表</a>
        </div>
        <div class="mian_content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame" src="welcome.jsp" style="overflow:visible;"
                        scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
            </div>
        </div>
    </div>
     <%
    }
    }
     %>
</body>
</html>
