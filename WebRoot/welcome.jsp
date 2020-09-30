<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>欢迎页</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/index.css" type="text/css" media="screen"/>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/tendina.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        .a1 {
            font-size: 4em;
            font-family: "微软雅黑";
            color: #F00;
        }
    </style>
    <style type="text/css">
        body {
            background-image: url(images/001.jpg);
            background-size: cover;
        }
    </style>

</head>


<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center" class="a1">欢迎登陆贫困认定管理系统</div>
</body>
</html>
