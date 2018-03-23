<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            function resetPwd() {
                alert("请至少选择一条数据！");
                document.getElementById("formId").submit();
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteAdmin(id) {
                var r = window.confirm("确定要删除此管理员吗？");
                window.location.href = "${pageContext.request.contextPath}/admin/deleteAdmin?adminId=" + id;
                document.getElementById("operate_result_info").style.display = "block";
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type === "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
        </script>       
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../../images/logo.png" alt="logo" class="left"/>
            <a href="${pageContext.request.contextPath}/login/logout.do">[退出]</a>
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
            <!--查询-->
            <div class="search_add">
                <form action="${pageContext.request.contextPath}/admin/showAdmin?pageCode=1" method="post">
                    <div>
                        模块：
                        <select id="selModules" name="moduleName" class="select_search">
                            <option value="">全部</option>
                            <option value="角色管理">角色管理</option>
                            <option value="管理员管理">管理员管理</option>
                            <option value="资费管理">资费管理</option>
                            <option value="账务账号">账务账号</option>
                            <option value="业务账号">业务账号</option>
                            <option value="账单管理">账单管理</option>
                            <option value="报表">报表</option>
                        </select>
                    </div>
                    <div>角色：<input type="text" name="roleName" class="text_search width200" /></div>
                    <div><input type="submit" value="搜索" class="btn_search"/></div>
                </form>
                <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/admin/toAdd';" />
            </div>
            <!--删除和密码重置的操作提示-->
            <div id="operate_result_info" class="operate_fail">
                <img src="../../../images/close.png" onclick="this.parentNode.style.display='none';"/>
                <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
            </div>
            <!--数据区域：用表格展示数据-->
            <div id="data">
                <form id="fromId" action="${pageContext.request.contextPath}/admin/resetPwd" method="post">
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>
                        <c:forEach var="admin" items="${adminPage.adminInfos}" step="1" varStatus="status">
                            <tr>
                                <td><input type="checkbox" name="adminInfos[${status.count}].adminId" value="${admin.adminId}"/></td>
                                <td>${admin.adminId}</td>
                                <td>${admin.name}</td>
                                <td>${admin.adminCode}</td>
                                <td>${admin.telephone}</td>
                                <td>${admin.email}</td>
                                <td>${admin.enrolldate}</td>
                                <td>
                                    <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">
                                        <c:forEach step="1" items="${admin.roleInfos}" var="role">
                                            ${role.name} &nbsp;
                                        </c:forEach>
                                    </a>
                                    <!--浮动的详细信息-->
                                    <div class="detail_info">
                                        <c:forEach step="1" items="${admin.roleInfos}" var="role">
                                            <c:forEach step="1" items="${role.moduleInfos}" var="module">
                                                ${module.name} &nbsp;
                                            </c:forEach>
                                        </c:forEach>
                                    </div>
                                </td>
                                <td class="td_modi">
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/admin/toModi?adminId=${admin.adminId}';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.adminId});" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
            <!--分页-->
            <c:set var="tp" scope="page" value="${adminPage.totalPages}"/>
            <c:set var="pc" scope="page" value="${adminPage.pageCode}"/>
            <div id="pages">

                <c:if test="${pc == 1}">
                    <a href="#">已首页</a>
                </c:if>
                <c:if test="${pc > 1}">
                    <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=1">首页</a>
                    <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=${pc - 1}">上一页</a>
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
                        <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=${p1}" class="current_page">${p1}</a>
                    </c:if>
                    <c:if test="${pc != p1}">
                        <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=${p1}">${p1}</a>
                    </c:if>
                </c:forEach>


                <c:if test="${pc == tp}">
                    <a href="#">已尾页</a>
                </c:if>
                <c:if test="${pc < tp}">
                    <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=${tp}">尾页</a>
                    <a href="${pageContext.request.contextPath}/admin/showAdmin?pageCode=${pc + 1}">下一页</a>
                </c:if>
            </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>
