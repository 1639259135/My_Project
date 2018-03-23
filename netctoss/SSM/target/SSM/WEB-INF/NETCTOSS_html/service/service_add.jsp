<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
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

            //自动查询账务账号
            function searchAccounts(txtObj) {
                //document.getElementById("a1").innerHTML = txtObj.value;
                window.location.href = "${pageContext.request.contextPath}/service/accountByIdcard?iscardNo=" + txtObj;
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
                <li><a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=1" class="admin_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/cost/showCost?pageCode=1" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/account/showAccount?pageCode=1" class="account_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/service/showService?pageCode=1" class="service_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/bill?pageCode=1" class="bill_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/report?pageCode=1" class="report_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/userInfo" class="information_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/userModi" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="${pageContext.request.contextPath}/service/addService" method="post" class="main_form">
                <!--内容项-->
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" name="account.idcardNo" value="${accountByIdcard.idcardNo}" placeholder="查询出的结果写入账务账号" class="width180" onkeyup="searchAccounts(this);"  />
                    <%--<input type="button" value="查询账务账号" class="btn_search_large" />--%>
                    <span class="required">*</span>
                    <div class="validate_msg_short">${accountMsg}</div>
                </div>

                <div class="text_info clearfix"><span>账务账号：</span></div>
                <div class="input_info">
                    <input type="text" name="account.loginName" value="${accountByIdcard.loginName}"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">没有此账务账号，请重新录入。</div>
                </div>

                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name="cost.costType">
                        <option value="0">包月</option>
                        <option value="1">套餐</option>
                        <option value="2">计时</option>
                    </select>                        
                </div>

                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="unixHost"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">15 长度，符合IP的地址规范</div>
                </div>

                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="osUsername" placeholder="创建即启用，状态为开通" value=""  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
                </div>

                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="loginPasswd" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" name="password2"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/showService?pageCode=1';" />
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
