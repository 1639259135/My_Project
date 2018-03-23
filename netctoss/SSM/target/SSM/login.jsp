<%@page isELIgnored="false" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body class="index">
    <div class="login_box">
        <form id="admin_info" action="#" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="username" name="adminCode" type="text" class="width150" /></td>
                    <td class="login_error_info"><span class="required">30长度以内的字母、数字和下划线</span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="password" name="password" type="password" class="width150" /></td>
                    <td><span class="required">30长度以内的字母、数字和下划线</span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input id="imgCode" name="imgCode" type="text" class="width70" /></td>
                    <%--<td><img id="code_img" src="images/valicode.jpg" alt="验证码" title="点击更换" onclick="changeImg()" /></td>--%>
                    <td><img id="code_img" alt="验证码" title="点击更换" src="${pageContext.request.contextPath}/login/createImg.do" onclick="changeImg()" /></td>
                    <td><span id="codeError" class="required"></span></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <%--<a href="index.jsp"><img src="images/login_btn.png" /></a>--%>
                        <a href="javascript:login();"><img src="images/login_btn.png" /></a>
                    </td>
                    <td><span id="loginError" class="required"></span></td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script language="JavaScript" type="text/javascript">

    function changeImg() {
        $("code_img").attr("src","${pageContext.request.contextPath}/login/createImg.do?date=" + new Date().getTime())
    }

    function login(){
//        $.get(
//            "${pageContext.request.contextPath}/login/login.do",
//            $('#admin_info').serialize(),
//            function (data) {
//                alert("data="+data);
//                console.log(data);
//            }
//        );
        $.ajax({
            url:"${pageContext.request.contextPath}/login/login",
            type:'get',
            dataType:'json',
            data:$('#admin_info').serialize(),
            success:function (data) {
                if (data.result === 0){
                    window.location.href = "${pageContext.request.contextPath}/index.jsp"
                }else {
                    alert(data.resultMsg);
                }
            }
        });
    }

</script>
</html>
