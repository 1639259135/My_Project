<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[编辑班级]</td>
   
    <td width="52%"align="right">
    	<s:a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
    		<img src="${pageContext.request.contextPath}/images/button/save.gif" />
    	</s:a>
       <s:a href="queryAllClasses.action"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:set var="CBCI" value="#session.classByClassId"/>
<s:form action="editClass" method="POST">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">班级名称：</td>
	    <td width="20%"><s:textfield name="classes.name" value="%{#CBCI.name}"/> </td>
	    <td width="8%">所属类别：</td>
	    <td width="62%">
	    	<s:select name="classes.crmCourseType.courseTypeId" list="%{#session.allType}"
					  listKey="courseTypeId" listValue="courseName"
					  headerKey="%{#CBCI.crmCourseType.courseTypeId}" headerValue="%{#CBCI.crmCourseType.courseName}"
			>
			</s:select>

			<%--<select name="crmCourseType.courseTypeId">--%>
			    <%--<option value="">---请选择---</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000008">JavaEE</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000009">大数据</option>--%>
			<%--</select>--%>
		</td>
	  </tr>
	  <tr>
	    <td>开课时间：</td> 
	    <td>
	    	<s:textfield name="classes.beginTime" value="%{#CBCI.beginTime}" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td>结业时间：</td>
	    <td>
	    	<s:textfield name="classes.endTime" value="%{#CBCI.endTime}" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	  </tr>
	  <tr>
	    <td>其他说明：</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4"><s:textarea name="classes.remark" cols="60" rows="10" value="%{#CBCI.remark}"/></td>
	  </tr>
	</table>
</s:form>

</body>
</html>
