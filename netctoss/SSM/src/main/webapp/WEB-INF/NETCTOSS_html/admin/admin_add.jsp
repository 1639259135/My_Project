<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../../images/logo.png" alt="logo" class="left"/>
            <a href="../../../index.jsp">[退出]</a>
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="../../../index.jsp" class="index_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/role/showRole?pageCode=1" class="role_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=1" class="admin_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/cost/showCost?pageCode=1" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/account/showAccount?pageCode=1" class="account_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/service/showService?pageCode=1" class="service_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/bill?pageCode=1" class="bill_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/report?pageCode=1" class="report_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/userInfo" class="information_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/userModi" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath}/admin/addAdmin" method="post" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="name"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long">20长度以内的汉字、字母、数字的组合</div>
                    </div>

                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminCode" />
                        <span class="required">*</span>
                        <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                    </div>

                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="password" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">30长度以内的字母、数字和下划线的组合</div>
                    </div>

                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="password2" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">两次密码必须相同</div>
                    </div>

                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="telephone" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
                    </div>

                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" name="email" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>

                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <li><input type="checkbox" name="moduleInfos[0].name" value="角色管理"/>角色管理</li>
                                <li><input type="checkbox" name="moduleInfos[1].name" value="管理员"/>管理员</li>
                                <li><input type="checkbox" name="moduleInfos[2].name" value="资费管理"/>资费管理</li>
                                <li><input type="checkbox" name="moduleInfos[3].name" value="账务账号"/>账务账号</li>
                                <li><input type="checkbox" name="moduleInfos[4].name" value="业务账号"/>业务账号</li>
                                <li><input type="checkbox" name="moduleInfos[5].name" value="账单管理"/>账单管理</li>
                                <li><input type="checkbox" name="moduleInfos[6].name" value="报表"/>报表</li>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
                        <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/admin/showAdmin?pageCode=1';" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>
