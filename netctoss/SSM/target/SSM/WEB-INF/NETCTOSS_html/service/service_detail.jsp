<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
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
            <c:set var="sd" value="${serviceDetail}"/>
                <form action="" method="" class="main_form">
                    <!--必填项-->
                    <div class="text_info clearfix"><span>业务账号ID：</span></div>
                    <div class="input_info"><input type="text" value="${sd.serviceId}" readonly class="readonly" /></div>
                    <div class="text_info clearfix"><span>账务账号ID：</span></div>
                    <div class="input_info"><input type="text" value="${sd.account.accountId}" readonly class="readonly" /></div>
                    <div class="text_info clearfix"><span>客户姓名：</span></div>
                    <div class="input_info"><input type="text" readonly class="readonly" value="${sd.account.realName}" /></div>
                    <div class="text_info clearfix"><span>身份证号码：</span></div>
                    <div class="input_info"><input type="text" readonly class="readonly" value="${sd.account.idcardNo}" /></div>
                    <div class="text_info clearfix"><span>服务器 IP：</span></div>
                    <div class="input_info"><input type="text" value="${sd.unixHost}" readonly class="readonly" /></div>
                    <div class="text_info clearfix"><span>OS 账号：</span></div>
                    <div class="input_info"><input type="text" value="${sd.osUsername}" readonly class="readonly" /></div>
                    <div class="text_info clearfix"><span>状态：</span></div>
                    <div class="input_info">
                        <select disabled>
                            <c:if test="${sd.status == 1}">
                                <option selected="selected">开通</option>
                                <option>暂停</option>
                                <option>删除</option>
                            </c:if>
                            <c:if test="${sd.status == 0}">
                                <option>开通</option>
                                <option selected="selected">暂停</option>
                                <option>删除</option>
                            </c:if>
                            <c:if test="${sd.status == 2}">
                                <option>开通</option>
                                <option>暂停</option>
                                <option selected="selected">删除</option>
                            </c:if>
                        </select>
                    </div>
                    <div class="text_info clearfix"><span>开通时间：</span></div>
                    <div class="input_info"><input type="text" value="${sd.pauseDate}" readonly class="readonly" /></div>
                    <div class="text_info clearfix"><span>资费 ID：</span></div>
                    <div class="input_info"><input type="text" value="${sd.costId}" class="readonly" readonly /></div>
                    <div class="text_info clearfix"><span>资费名称：</span></div>
                    <div class="input_info"><input type="text" value="${sd.cost.name}" readonly class="width200 readonly" /></div>
                    <div class="text_info clearfix"><span>资费说明：</span></div>
                    <div class="input_info_high">
                        <textarea class="width300 height70 readonly" readonly>${sd.cost.descr}</textarea>
                    </div>
                    <!--操作按钮-->
                    <div class="button_info clearfix">
                        <input type="button" value="返回" class="btn_save"
                               onclick="location.href='${pageContext.request.contextPath}/service/showService?pageCode=1';" />
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
