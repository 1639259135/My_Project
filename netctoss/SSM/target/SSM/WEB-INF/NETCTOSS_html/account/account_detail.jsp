<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../../images/logo.png" alt="logo" class="left" />
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
                <li><a href="${pageContext.request.contextPath}/account/showAccount?pageCode=1" class="account_on"></a></li>
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
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${accountDetail.accountId}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info"><input type="text" value="${accountDetail.realName}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" value="${accountDetail.idcardNo}" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${accountDetail.loginName}" readonly class="readonly" />
                </div>                   
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200 readonly" readonly value="${accountDetail.telephone}" />
                </div>
                <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.recommenderId}" /></div>
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.recommenderIdcard}" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select disabled>
                        <c:if test="${accountDetail.status == 0}">
                            <option>开通</option>
                            <option selected="selected">暂停</option>
                            <option>删除</option>
                        </c:if>
                        <c:if test="${accountDetail.status == 1}">
                            <option selected="selected">开通</option>
                            <option>暂停</option>
                            <option>删除</option>
                        </c:if>
                        <c:if test="${accountDetail.status == 2}">
                            <option>开通</option>
                            <option>暂停</option>
                            <option selected="selected">删除</option>
                        </c:if>
                    </select>                        
                </div>                    
                <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
                <c:if test="${accountDetail.status == 0}">
                    <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.createDate}" /></div>
                </c:if>
                <c:if test="${accountDetail.status == 1}">
                    <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.pauseDate}" /></div>
                </c:if>
                <c:if test="${accountDetail.status == 2}">
                    <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.closeDate}" /></div>
                </c:if>
                <div class="text_info clearfix"><span>上次登录时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.lastLoginTime}" /></div>
                <div class="text_info clearfix"><span>上次登录IP：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${accountDetail.lastLoginIp}" /></div>
                <!--可选项数据-->
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input type="text" readonly class="readonly" placeholder="由身份证计算而来" value="${accountDetail.birthdate}" />
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width350 readonly" readonly value="${accountDetail.email}" />
                </div> 
                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                    <select disabled>
                        <c:if test="${accountDetail.occupation.equals('干部')}">
                            <option selected="selected">干部</option>
                            <option>学生</option>
                            <option>技术人员</option>
                            <option>其他</option>
                        </c:if>
                        <c:if test="${accountDetail.occupation.equals('学生')}">
                            <option>干部</option>
                            <option selected="selected">学生</option>
                            <option>技术人员</option>
                            <option>其他</option>
                        </c:if>
                        <c:if test="${accountDetail.occupation.equals('技术人员')}">
                            <option>干部</option>
                            <option>学生</option>
                            <option selected="selected">技术人员</option>
                            <option>其他</option>
                        </c:if>
                        <c:if test="${accountDetail.occupation.equals('其他')}">
                            <option>干部</option>
                            <option>学生</option>
                            <option>技术人员</option>
                            <option selected="selected">其他</option>
                        </c:if>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <c:if test="${accountDetail.gender == 1}">
                        <input type="radio" name="radSex" id="female" disabled />
                        <label for="female">女</label>
                        <input type="radio" checked="checked" name="radSex" id="male" disabled />
                        <label for="male">男</label>
                    </c:if>
                    <c:if test="${accountDetail.gender == 0}">
                        <input type="radio" checked="checked" name="radSex" id="female" disabled />
                        <label for="female">女</label>
                        <input type="radio" name="radSex" id="male" disabled />
                        <label for="male">男</label>
                    </c:if>
                </div> 
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info"><input type="text" class="width350 readonly" readonly value="${accountDetail.emailaddress}" /></div>
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${accountDetail.zipcode}" /></div>
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${accountDetail.qq}" /></div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/account/showAccount?pageCode=1';" />
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
