<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[部门管理]</td>
   
    <td width="57%"align="right">
    	<%--添加部门 --%>
       <a href="${pageContext.request.contextPath}/pages/department/addOrEditDepartment.jsp">
       		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
       </a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  
    <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center">部门名称</td>
    <td width="7%" align="center">编辑</td>
    </tr>

    <s:if test="#session.page.departmentList != null">
        <s:iterator var="department" value="#session.page.departmentList" status="dep">
            <tr class="<s:property value="%{#dep.odd ? 'tabtd2' : 'tabtd1'}"/>">
                <td align="center"><s:property value="#department.depName"/> </td>
                <td width="7%" align="center">
                    <s:url var="queryBDID" value="queryByDepId.action">
                        <s:param name="department.depId"><s:property value="#department.depId"/></s:param>
                    </s:url>
                    <s:a href="%{queryBDID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></s:a>
                </td>
            </tr>
        </s:iterator>
    </s:if>
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
        <span>第<s:property value="#session.page.pageCode"/>/<s:property value="#session.page.totalPages"/>页</span>
        <span>
			<s:url var="depFirstPage" value="depPage.action">
                <s:param name="page.pageCode">1</s:param>
            </s:url>
        	<s:a href="%{depFirstPage}">[首页]</s:a>&nbsp;&nbsp;

			<s:if test="#session.page.pageCode != 1">
                <s:url var="depLastPage" value="depPage.action">
                    <s:param name="page.pageCode"><s:property value="#session.page.pageCode - 1"/> </s:param>
                </s:url>
                <s:a href="%{depLastPage}">[上一页]</s:a>&nbsp;&nbsp;
            </s:if>
			<s:else>
                <s:a href="#">[上一页]</s:a>&nbsp;&nbsp;
            </s:else>

			<s:if test="#session.page.pageCode != 1">
                <s:url var="depNextPage" value="depPage.action">
                    <s:param name="page.pageCode"><s:property value="#session.page.pageCode + 1"/> </s:param>
                </s:url>
                <s:a href="%{depNextPage}">[下一页]</s:a>&nbsp;&nbsp;
            </s:if>
			<s:else>
                <s:a href="#">[下一页]</s:a>&nbsp;&nbsp;
            </s:else>

			<s:url var="depEndPage" value="depPage.action">
                <s:param name="page.pageCode"><s:property value="#session.page.totalPages"/> </s:param>
            </s:url>
            <s:a href="%{depEndPage}">[尾页]</s:a>
        </span>
    </td>
  </tr>
</table>
</body>
</html>
