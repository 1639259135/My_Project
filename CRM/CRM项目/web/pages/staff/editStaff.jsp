<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<%--<script src="../../js/jquery-3.2.1.min.js"></script>--%>
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
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <s:a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </s:a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:set var="sta" value="#session.byIdStaff"/>
<s:url var="update" value="update.action">
	<s:param name="staff.staffId"><s:property value="#sta.staffId"/> </s:param>
</s:url>
<s:form action="%{update}" method="POST">
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><s:textfield name="staff.loginName" value="%{#sta.loginName}"/> </td>
	    <td>密码：</td>
	    <td><s:password name="staff.loginPwd" value="%{#sta.loginPwd}" showPassword="true"/> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="staff.staffName" value="%{#sta.staffName}" /> </td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女','?'}" name="staff.gender" value="%{#sta.gender}"/>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<s:select name="post.crmDepartment.depId" id="depSelect"
					  list="#session.crmDepartments"
					  listKey="depId" listValue="depName"
					  onchange="showPost1(this)"
					  headerKey="" value="----请--选--择----"
			/>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<s:select name="staff.crmPost.postId" id="postSelect"
					     list="post != null ? post.crmDepartment.postSet : {}"
						 listKey="postId" listValue="postName"
						 headerKey="" headerValue="----请--选--择----"
			/>

		</td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
			<s:date name="#sta.onDutyDate" var="date" format="yyyy-MM-dd" />
	    	<s:textfield name="staff.onDutyDate" value="%{#date}" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
		<s:property value="post.crmDepartment.postSet"/>
	</table>
</s:form>

</body>
<script src="../../js/jquery-3.2.1.min.js">

    function showPost1(departmentObj){
        //1 选择的部门id
        var depId = departmentObj.value;

        //2 发送ajax 通过部门id 查询对应职务
        var url = "${pageContext.request.contextPath}/queryPost?crmDepartment.depId=" + depId;

        //2.1 创建核心对象
        var xmlhttp=null;
        if (window.XMLHttpRequest) {
            xmlhttp=new XMLHttpRequest();
        }else if (window.ActiveXObject) {// code for IE5 and IE6
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }

        // 2.2 设置回调函数，当ajax请求完成之后，进行处理
        xmlhttp.onreadystatechange = function(){
            // * 发送成功， 并发送的正常页面
            if(xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                var postSelectObject = document.getElementById("postSelect");
                postSelectObject.innerHTML = "<option value=''>----请--选--择----</option>";

                //获得数据 json，并处理
                //@1 获得普通文本数据
                var textData = xmlhttp.responseText;
                //@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
                var jsonData = eval("("+textData+")");
                //@3 遍历数据，将数据添加到“职务”select
                for(var i = 0 ; i < jsonData.length ; i ++){
                    var postObj = jsonData[i];
                    // @3.1 编号
                    var postId = postObj.postId;
                    // @3.2 名称
                    var postName = postObj.postName;
                    // @3.3 追加
                    postSelectObject.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
                }
            }
        };

        // 2.3 打开连接 ,以get请求方式发送数据
        xmlhttp.open("GET",url);

        // 2.4 发送 , 没有请求体的内容，设置成null
        xmlhttp.send(null);
    }

</script>
</html>
