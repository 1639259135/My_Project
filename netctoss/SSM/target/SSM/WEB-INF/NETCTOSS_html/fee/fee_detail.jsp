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
                <li><a href="${pageContext.request.contextPath}/cost/showCost?pageCode=1" class="fee_on"></a></li>
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
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${costDetail.id}" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${costDetail.name}"/></div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled>
                        <c:if test="${costDetail.status == 0}">
                            <option>开通</option>
                            <option selected="selected">暂停</option>
                            <option>删除</option>
                        </c:if>
                        <c:if test="${costDetail.status == 1}">
                            <option selected="selected">开通</option>
                            <option>暂停</option>
                            <option>删除</option>
                        </c:if>
                        <c:if test="${costDetail.status == 2}">
                            <option>开通</option>
                            <option>暂停</option>
                            <option selected="selected">删除</option>
                        </c:if>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <c:if test="${costDetail.costType == 0}">
                        <input type="radio" name="radFeeType" checked="checked" id="monthly" disabled="disabled" />
                        <label for="monthly">包月</label>
                        <input type="radio" name="radFeeType" id="package" disabled="disabled" />
                        <label for="package">套餐</label>
                        <input type="radio" name="radFeeType" id="timeBased" disabled="disabled" />
                        <label for="timeBased">计时</label>
                    </c:if>
                    <c:if test="${costDetail.costType == 1}">
                        <input type="radio" name="radFeeType" id="monthly" disabled="disabled" />
                        <label for="monthly">包月</label>
                        <input type="radio" name="radFeeType" checked="checked" id="package" disabled="disabled" />
                        <label for="package">套餐</label>
                        <input type="radio" name="radFeeType" id="timeBased" disabled="disabled" />
                        <label for="timeBased">计时</label>
                    </c:if>
                    <c:if test="${costDetail.costType == 2}">
                        <input type="radio" name="radFeeType" id="monthly" disabled="disabled" />
                        <label for="monthly">包月</label>
                        <input type="radio" name="radFeeType" id="package" disabled="disabled" />
                        <label for="package">套餐</label>
                        <input type="radio" name="radFeeType" checked="checked" id="timeBased" disabled="disabled" />
                        <label for="timeBased">计时</label>
                    </c:if>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" readonly value="${costDetail.baseDuration}"  />
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${costDetail.baseCost}" />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${costDetail.unitCost}" />
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="${costDetail.creatime}" /></div>
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="${costDetail.startime}" /></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${costDetail.descr}</textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save"
                           onclick="location.href='${pageContext.request.contextPath}/cost/showCost?pageCode=1';" />
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
