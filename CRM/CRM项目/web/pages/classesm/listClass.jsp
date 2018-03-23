<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
<title>班级管理</title>
</head>
<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<form name="createForm" action="" method="post">
<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="20%" align="left">[班级管理]</td>
    <td width="42%"align="center">&nbsp;</td>
    <td width="36%"align="right">
    	<%--添加班级  /html/classesm/addClass.jsp--%>
    	<a href="${pageContext.request.contextPath}/pages/classesm/addOrEditClass.jsp">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/>
    	</a>
    	<%--高级查询 
        <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
    	--%>
    </td>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="97%" border="1">
	<thead>
		<tr class="henglan" style="font-weight:bold;">
			<th width="150px" align="center">班级名称</th>
			<th width="200px" align="center">所属课程</th>
			<th width="80px" align="center">开班时间</th>
			<th width="80px" align="center">毕业时间</th>

			<th width="80px" align="center">状态</th>
			<th width="70px" align="center">学生总数</th>
			<th width="70px" align="center">升学数</th>
			<th width="70px" align="center">转班数</th>
			<th width="50px" align="center">编辑</th>
			<th width="50px" align="center">查看</th>
			<th align="center">课程表</th>
		</tr>
	</thead>
	<tbody>
		<s:if test="#session.page.classesList != null">
			<s:iterator var="classes" value="#session.page.classesList" status="cla">
				<tr class="<s:property value="%{#cla.odd ? 'tabtd2' : 'tabtd1'}"/>">
					<td align="center"><s:property value="#classes.name"/> </td>
					<td align="center"><s:property value="#classes.courseType.courseName"/>  </td>
					<td align="center"><s:property value="#classes.beginTime"/> </td>
					<td align="center"><s:property value="#classes.endTime"/> </td>
					<td align="center"><s:property value="#classes.status"/> </td>
					<td align="center"><s:property value="#classes.totalCount"/>  </td>
					<td align="center"><s:property value="#classes.upgradeCount"/>  </td>
					<td align="center"><s:property value="#classes.changeCount"/>  </td>
					<td align="center">
						<s:url var="queryByClaID" value="queryByClaID.action">
							<s:param name="classes.classId"><s:property value="#classes.classId"/> </s:param>
						</s:url>
						<s:a href="%{queryByClaID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></s:a>
					</td>
					<td align="center">
						<s:url var="lookClass" value="queryByClaID2.action">
							<s:param name="classes.classId"><s:property value="#classes.classId"/> </s:param>
						</s:url>
						<s:a href="%{lookClass}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></s:a>
					</td>
					<td align="center" title="上次上传时间：2015-04-02">
						<a href="${pageContext.request.contextPath}/pages/classesm/uploadClass.jsp">上传</a>
						<a href="${pageContext.request.contextPath}/pages/classesm/downloadClass">下载</a> <br/>
					</td>
				</tr>
			</s:iterator>
		</s:if>
	</tbody>
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第<s:property value="#session.page.pageCode"/>/<s:property value="#session.page.totalPages"/>页</span>
        <span>
			<s:url var="claFirstPage" value="claPage.action">
				<s:param name="page.pageCode">1</s:param>
			</s:url>
        	<s:a href="%{claFirstPage}">[首页]</s:a>&nbsp;&nbsp;

			<s:if test="#session.page.pageCode != 1">
				<s:url var="claLastPage" value="claPage.action">
					<s:param name="page.pageCode"><s:property value="#session.page.pageCode - 1"/> </s:param>
				</s:url>
				<s:a href="%{claLastPage}">[上一页]</s:a>&nbsp;&nbsp;
			</s:if>
			<s:else>
				<s:a href="#">[上一页]</s:a>&nbsp;&nbsp;
			</s:else>

			<s:if test="#session.page.pageCode != 1">
				<s:url var="claNextPage" value="claPage.action">
					<s:param name="page.pageCode"><s:property value="#session.page.pageCode + 1"/> </s:param>
				</s:url>
				<s:a href="%{claNextPage}">[下一页]</s:a>&nbsp;&nbsp;
			</s:if>
			<s:else>
				<s:a href="#">[下一页]</s:a>&nbsp;&nbsp;
			</s:else>

			<s:url var="claEndPage" value="claPage.action">
				<s:param name="page.pageCode"><s:property value="#session.page.totalPages"/> </s:param>
			</s:url>
            <s:a href="%{claEndPage}">[尾页]</s:a>
        </span>
    </td>
  </tr>
</table>

</body>
</html>
