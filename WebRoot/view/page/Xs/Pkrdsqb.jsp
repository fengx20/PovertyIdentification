<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>学生填写贫困认定申请表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <script type="text/javascript">

        function validate() {
            var fullstuNo = document.forms[0].fullstuNo.value;
            var stuName = document.forms[0].stuName.value;
            var sex = document.forms[0].sex.value;
            var birth = document.forms[0].birth.value;
            var xueyuan = document.forms[0].xueyuan.value;
            var className = document.forms[0].className.value;
            var phoneNum = document.forms[0].phoneNum.value;
            var idNo = document.forms[0].idNo.value;
            var money = document.forms[0].money.value;
            var reason = document.forms[0].reason.value;

            if (fullstuNo.length <= 0) {
                alert("学号不能为空，请输入学号！");
                return false;
            } else if (stuName.length <= 0) {
                alert("姓名不能为空，请输入姓名！");
                return false;
            } else if (sex.length <= 0) {
                alert("性别不能为空，请输入性别！");
                return false;
            } else if (birth.length <= 0) {
                alert("班级不能为空，请输入班级！");
                return false;
            } else if (xueyuan.length <= 0) {
                alert("学院不能为空，请输入学院!");
                return false;
            } else if (className.length <= 0) {
                alert("班级不能为空，请输入班级!");
                return false;
            } else if (phoneNum.length <= 0) {
                alert("联系电话不能为空，请输入联系电话!");
                return false;
            } else if (idNo.length <= 0) {
                alert("身份证号不能为空，请输入身份证号!");
                return false;
            } else if (money.length <= 0) {
                alert("家庭人均收入不能为空，请输入家庭人均收入!");
                return false;
            } else if (reason.length <= 0) {
                alert("申请认定理由不能为空，请输入申请认定理由!");
                return false;
            } else if (window.confirm("提交后不可再修改，确认提交？")) {
                return true;
            } else {
                return false;
            }

        }
    </script>

    <style type="text/css">
        #form table {
            font-family: "微软雅黑";
            font-size: 20px;
        }
    </style>
</head>

<body>

<form name="addPkrdsqb" method="post" id="form" onSubmit="return validate()" action="<%=path%>/servlet/PkrdsqbServlet">
    <input type="hidden" name="action" id="action" value="1"/>
    <input type="hidden" name="tongguo" id="tongguo" value="0"/>
    <input type="hidden" name="fandui" id="fandui" value="0"/>
    <input type="hidden" name="zhuangtai" id="zhuangtai" value="申请已提交，班级贫困小组审核中"/>
    <input type="hidden" name="qingkuang" id="qingkuang" value="未完成投票"/>
    <input type="hidden" name="juti" id="juti" value="暂无消息"/>

    <table width="745" height="746" border="1" align="center">
        <tr>
            <td colspan="3" align="center" valign="middle">贫困认定申请表<input type="text" name="zhuangtai" id="zhuangtai"
                                                                         readOnly
                                                                         style="color:red;height:25px;text-align:center;line-height:20px;font-size:15px"
                                                                         value="申请未提交"/></td>
        </tr>
        <tr>
            <td width="217" height="50" align="center" valign="middle">学号:&nbsp;&nbsp;<input type="text"
                                                                                             name="fullstuNo"
                                                                                             id="fullstuNo" readOnly
                                                                                             value=<%=request.getParameter("fullstuNo") %>  style="height:25px;width:160px;font-size:15px"/>
            </td>
            <td width="257" align="right" valign="middle">姓名:&nbsp;&nbsp;<input type="text" name="stuName" id="stuName"
                                                                                style="height:25px;width:160px;font-size:15px"/>
            </td>
            <td width="259" rowspan="5">&nbsp;</td>
        </tr>
        <tr align="center" valign="middle">
            <td height="50">性别:&nbsp;&nbsp;<input type="text" name="sex" id="sex"
                                                  style="height: 25px; width: 160px;font-size:15px"/></td>
            <td align="right">出生年月:&nbsp;&nbsp;<input type="text" name="birth" id="birth"
                                                      style="height:25px;width:160px;font-size:15px"/></td>
        </tr>
        <tr align="center" valign="middle">
            <td height="50">学院:&nbsp;&nbsp;<input type="text" name="xueyuan" id="xueyuan"
                                                  style="height:25px;width:160px;font-size:15px"/></td>
            <td align="right">班级:&nbsp;&nbsp;<input type="text" name="className" id="className"
                                                    style="height:25px;width:160px;font-size:15px"/></td>
        </tr>
        <tr align="center" valign="middle">
            <td height="50" colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话:&nbsp;&nbsp;<input type="text"
                                                                                                             name="phoneNum"
                                                                                                             id="phoneNum"
                                                                                                             style="height:25px;width:160px;font-size:15px"/>
            </td>
        </tr>
        <tr align="center" valign="middle">
            <td height="50" colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号:&nbsp;&nbsp;<input type="text"
                                                                                                             name="idNo"
                                                                                                             id="idNo"
                                                                                                             style="height:25px;width:160px;font-size:15px"/>
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center" valign="middle">家庭人均收入:&nbsp;&nbsp;
                <input type="text" name="money" id="money" style="height:25px;width:220px;font-size:15px"/></td>
        </tr>
        <tr>
            <td colspan="3">申请认定理由:</td>
        </tr>
        <tr>
            <td colspan="3" height="300"><textarea style="width:745px; height:300px;font-size:20px" name="reason"
                                                   id="reason"></textarea></td>
        </tr>
        <tr>
            <td colspan="3" align="center" valign="middle"><input type="submit" name="addPkrdsqb_tj" value="提交"
                                                                  style="height:30px;width:50px"/></td>
        </tr>
    </table>
</form>
</body>
</html>
