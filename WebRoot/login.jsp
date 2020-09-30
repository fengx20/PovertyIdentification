<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    /*使用request对象获取路径相关数据*/
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>贫困认定管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var $tab_li = $('#tab ul li');
            $tab_li.hover(function () {
                $(this).addClass('selected').siblings().removeClass('selected');
                var index = $tab_li.index(this);
                $('div.tab_box > div').eq(index).show().siblings().hide();
            });
        });
    </script>
    <script type="text/javascript">

        $(function () {
            $(".screenbg ul li").each(function () {
                $(this).css("opacity", "0");
            });
            $(".screenbg ul li:first").css("opacity", "1");
            var index = 0;
            var t;
            var li = $(".screenbg ul li");
            var number = li.size();

            function change(index) {
                li.css("visibility", "visible");
                li.eq(index).siblings().animate({opacity: 0}, 3000);
                li.eq(index).animate({opacity: 1}, 3000);
            }

            function show() {
                index = index + 1;
                if (index <= number - 1) {
                    change(index);
                } else {
                    index = 0;
                    change(index);
                }
            }

            t = setInterval(show, 8000);
            //根据窗口宽度生成图片宽度
            var width = $(window).width();
            $(".screenbg ul img").css("width", width + "px");
        });
    </script>
</head>
<body>
<div id="tab">
    <div class="tab_box">
        <form name="login" method="post" action="<%=path%>/servlet/UserLoginServlet">
            <input type="hidden" name="action" id="action" value="1"/>
            <div>
                <div class="stu_error_box">贫困认定管理系统</div>
                <div id="username">
                    <label>学工号：</label>
                    <input type="text" id="user_no" name="user_no"/>
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="stu_code_hide" value="DTEF" name="code"/>
                    <img src="images/captcha.jpg" title="点击更换" alt="验证码占位图"/>
                </div>
                <div align="center">
                    <input type="radio" name="actor" checked value="Xs"/>学生
                    <input type="radio" name="actor" value="Bjxz"/>班级小组
                    <input type="radio" name="actor" value="Fdy"/>辅导员
                    <input type="radio" name="actor" value="Xxyc"/>系学院处
                    <input type="radio" name="actor" value="Xxgc"/>校学工处
                    <input type="radio" name="actor" value="Root"/>管理员
                </div>
                <div id="remember">
                    <input type="checkbox" checked name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="images/004.jpg"></a></li>
        <li><a href="javascript:;"><img src="images/002.jpg"></a></li>
        <li><a href="javascript:;"><img src="images/003.jpg"></a></li>
        <li><a href="javascript:;"><img src="images/001.jpg"></a></li>
        <li><a href="javascript:;"><img src="images/005.jpg"></a></li>
    </ul>
</div>
</body>
<script type="text/javascript">
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes') {
        alert("学工号或密码错误或用户选择错误，请重新输入!");
    }
</script>
</html>