<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>管理员登陆</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/index.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/tendina.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
</head>
<body>
<!--顶部-->
<div class="layout_top_header">
    <div style="float: left">
        <span style="font-size: 20px;line-height: 45px;padding-left: 20px;color:#FFFFFF">贫困认定管理系统后台</span></div>
    <div id="ad_setting" class="ad_setting">
        <a class="ad_setting_a" href="javascript:;">
            <i class="icon-user glyph-icon" style="font-size: 20px"></i>
            <span><%=request.getAttribute("user_no") %>(管理员)</span>
            <i class="icon-chevron-down glyph-icon"></i>
        </a>
        <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
            <li class="ad_setting_ul_li">
                <a href="ChangePwd.jsp?user_no=+<%=request.getAttribute("user_no")%>" target="menuFrame">
                    <i class="icon-cog glyph-icon"></i>修改密码
                </a>
            </li>
            <li class="ad_setting_ul_li">
                <a href="login.jsp">
                    <i class="icon-signout glyph-icon"></i>
                    <span class="font-bold">退出</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="layout_left_menu">
    <ul id="menu">
        <li class="childUlLi">
            <a href="welcome.jsp" target="menuFrame">
                <i class="glyph-icon icon-home"></i>首页
            </a>
        </li>
        <li class="childUlLi">
            <a href="user.html" target="menuFrame">
                <i class="glyph-icon icon-reorder"></i>学生管理
            </a>
            <ul>
                <li>
                    <a href="view/page/Manager/Xs/add/addXs.jsp" target="menuFrame">
                        <i class="glyph-icon icon-chevron-right"></i>添加学生
                    </a>
                </li>
                <li>
                    <a href="servlet/XsServlet?action=<%=3 %>" target="menuFrame">
                        <i class="glyph-icon icon-chevron-right"></i>查询学生
                    </a>
                </li>
            </ul>
        </li>
        <li class="childUlLi">
            <a href="role.html" target="menuFrame">
                <i class="glyph-icon icon-reorder"></i>辅导员管理
            </a>
            <ul>
                <li>
                    <a href="view/page/Manager/Fdy/add/addFdy.jsp" target="menuFrame">
                        <i class="glyph-icon icon-chevron-right"></i>添加辅导员
                    </a>
                </li>
                <li>
                    <a href="servlet/FdyServlet?action=<%=3 %>" target="menuFrame">
                        <i class="glyph-icon icon-chevron-right"></i>查询辅导员
                    </a>
                </li>
            </ul>
        </li>
        <li class="childUlLi">
            <a href="">
                <i class="glyph-icon  icon-location-arrow"></i>申请表管理
            </a>
            <ul>
                <li>
                    <a href="servlet/PkrdsqbServlet?action=<%=19 %>" target="menuFrame">
                        <i class="glyph-icon icon-chevron-right"></i>查询申请表
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</div>
<!--菜单-->
<div id="layout_right_content" class="layout_right_content">
    <div class="route_bg">
        <a href="welcome.jsp" target="menuFrame">主页</a>
        <i class="glyph-icon icon-chevron-right"></i>
    </div>
    <div class="mian_content">
        <div id="page_content">
            <iframe id="menuFrame" name="menuFrame" src="welcome.jsp" style="overflow:scroll;"
                    scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
</div>
</body>
</html>