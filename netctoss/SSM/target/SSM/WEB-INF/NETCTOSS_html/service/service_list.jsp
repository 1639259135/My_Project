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
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //删除
            function deleteAccount(id) {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                window.location.href = "${pageContext.request.contextPath}/service/delete?serviceId=" + id;
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState(id) {
                var r = window.confirm("确定要开通/暂停此业务账号吗？");
                window.location.href = "${pageContext.request.contextPath}/service/openOrClose?serviceId=" + id;
                document.getElementById("operate_result_info").style.display = "block";
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
            <%--<form action="" method="">--%>
                <!--查询-->
                <div class="search_add">
                    <form action="${pageContext.request.contextPath}/service/showService?pageCode=1" method="post">
                        <div>OS 账号：<input type="text" name="osUsername" class="width100 text_search" /></div>
                        <div>服务器 IP：<input type="text" name="unixHost" class="width100 text_search" /></div>
                        <div>身份证：<input type="text" name="idcardNo" class="text_search" /></div>
                        <div>状态：
                            <select class="select_search" name="status">
                                <option value="">全部</option>
                                <option value="1">开通</option>
                                <option value="0">暂停</option>
                                <option value="2">删除</option>
                            </select>
                        </div>
                        <div><input type="submit" value="搜索" class="btn_search" /></div>
                    </form>
                    <input type="button" value="增加" class="btn_add"
                           onclick="location.href='${pageContext.request.contextPath}/service/toAdd';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${servicePage.serviceList}" step="1" var="service">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/service/showDetail?serviceId=${service.serviceId}" title="查看明细">${service.serviceId}</a></td>
                            <td>${service.accountId}</td>
                            <td>${service.account.idcardNo}</td>
                            <td>${service.account.realName}</td>
                            <td>${service.osUsername}</td>
                            <c:if test="${service.status == 1}"><td>开通</td></c:if>
                            <c:if test="${service.status == 0}"><td>暂停</td></c:if>
                            <c:if test="${service.status == 2}"><td>删除</td></c:if>
                            <td>${service.unixHost}</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.cost.name}</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    ${service.cost.descr}
                                </div>
                            </td>
                            <td class="td_modi">
                                <c:if test="${service.status == 2}">
                                    <span class="btn_delete">已删除</span>
                                </c:if>
                                <c:if test="${service.status != 2}">
                                    <c:if test="${service.status == 1}">
                                        <input type="button" value="暂停" class="btn_pause" onclick="setState(${service.serviceId});" />
                                    </c:if>
                                    <c:if test="${service.status == 0}">
                                        <input type="button" value="开通" class="btn_start" onclick="setState(${service.serviceId});" />
                                    </c:if>
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.jsp';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${service.serviceId});" />
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
                <c:set var="tp" scope="page" value="${servicePage.totalPages}"/>
                <c:set var="pc" scope="page" value="${servicePage.pageCode}"/>
                <div id="pages">

                    <c:if test="${pc == 1}">
                        <a href="#">已首页</a>
                    </c:if>
                    <c:if test="${pc > 1}">
                        <a href="${pageContext.request.contextPath}/service/showService?pageCode=1">首页</a>
                        <a href="${pageContext.request.contextPath}/service/showService?pageCode=${pc - 1}">上一页</a>
                    </c:if>


                    <c:if test="${tp <= 5}">
                        <c:set var="begin" value="1" scope="page"/>
                        <c:set var="end" value="${tp}" scope="page"/>
                    </c:if>

                    <c:if test="${tp > 5}">
                        <c:if test="${pc < 3}">
                            <c:set var="begin" value="1" scope="page"/>
                        </c:if>
                        <c:if test="${pc >= 3}">
                            <c:set var="begin" value="${pc - 2}"/>
                        </c:if>

                        <c:if test="${begin + 4 >= tp}">
                            <c:set var="end" value="${tp}"/>
                        </c:if>
                        <c:if test="${begin + 4 < tp}">
                            <c:set var="end" value="${begin + 4}"/>
                        </c:if>

                        <c:if test="${end == tp}">
                            <c:set var="begin" value="${tp - 5}"/>
                        </c:if>
                    </c:if>

                    <c:forEach var="p1" begin="${begin}" end="${end}" step="1">
                        <c:if test="${pc == p1}">
                            <a href="${pageContext.request.contextPath}/service/showService?pageCode=${p1}" class="current_page">${p1}</a>
                        </c:if>
                        <c:if test="${pc != p1}">
                            <a href="${pageContext.request.contextPath}/service/showService?pageCode=${p1}">${p1}</a>
                        </c:if>
                    </c:forEach>


                    <c:if test="${pc == tp}">
                        <a href="#">已尾页</a>
                    </c:if>
                    <c:if test="${pc < tp}">
                        <a href="${pageContext.request.contextPath}/service/showService?pageCode=${tp}">尾页</a>
                        <a href="${pageContext.request.contextPath}/service/showService?pageCode=${pc + 1}">下一页</a>
                    </c:if>
                </div>
            <%--</form>--%>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司 </p>
        </div>
    </body>
</html>
