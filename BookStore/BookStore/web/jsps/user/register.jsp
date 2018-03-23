<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
	  body{
		  background-color: #d8ffd7;
	  }
	  ol li{
		  display: inline;
	  }
	  label,input{
		  width: 400px;
		  height:40px;
		  position: absolute;
		  font-size: 18px
	  }
  </style>

  </head>
  
  <body>

  <div style="background-color: white">
	  <ol>
		  <li><img src="images/网易云.png" style="width: 50px;height: 25px;"></li>
		  <li style="font-size: 20px">网易云</li>
		  <li style="font-size: 17px">账号注册</li>
	  </ol>
  </div>


  <div style="position: fixed;left: 15%;top: 15%;
        background-color: #d6eaff; width: 70%;height:70%;">

	  <div style="position: fixed; left:45%;top: 20%;
            width: 120px;font-size:20px">
		  邮箱号注册
	  </div>

	  <form action="../../user" method="post">

		  <input type="hidden" name="method" value="register"/>

		  <label style="left: 30%;top: 25%" for="username" >用户名</label>
		  <input style="left: 40%;top: 23%" placeholder="英文用户名"
				 onfocus="inputFocus(this)" onblur="inputBlur(this)"
				 type="text" name="username" id="username">

		  <label style="left: 30%;top: 40%" for="email" >邮箱地址</label>
		  <input style="left: 40%;top: 38%" placeholder="请输入邮箱地址"
				 onfocus="inputFocus(this)" onblur="inputBlur(this)"
				 type="text" name="email" id="email">


		  <label style="left: 30%;top: 55%" for="password" >登录密码</label>
		  <input style="left: 40%;top: 53%" placeholder="请输入密码"
				 onfocus="inputFocus(this)" onblur="inputBlur(this)"
				 type="password" name="password" id="password">


		  <input id="next"  value="下一步"
				 style="background-color: dodgerblue;height: 50px;left: 40%;top: 70%;"
				 onmousedown="mousedown()" onmouseup="mouseup()"
				 type="submit">
	  </form>


	  <%--<input type="checkbox" id="service"--%>
			 <%--style="width: 15px;height:15px;left: 40%;top: 65%;">--%>
	  <%--<label style="position: fixed;left: 45%;top: 63%;" for="service">--%>
		  <%--同意并遵守<span style="color: dodgerblue"> 《服务条款》</span></label>--%>


	  <%--<div id="um" style="color: red;position: fixed;font-size: 18px;left: 65%;top: 37%;--%>
                <%--visibility: hidden" >--%>
		  <%--请使用邮箱注册</div>--%>
	  <%--<div id="pd" style="color: red;position: fixed;font-size: 18px;left: 65%;top: 47.5%;--%>
                <%--visibility: hidden">--%>
		  <%--密码长度不少于6位,不多于16位</div>--%>

  </div>





  <%--<h1>注册</h1>--%>
<%--<p style="color: red; font-weight: 900">${msg }</p>--%>
<%--<form action="../../user" method="post">--%>
	<%--<input type="hidden" name="method" value="register"/>--%>
	<%--用户名：<input type="text" name="username" value=""/><br/>--%>
	<%--密　码：<input type="password" name="password"/><br/>--%>
	<%--邮　箱：<input type="text" name="email" value=""/><br/>--%>
	<%--<input type="submit" value="注册"/>--%>
<%--</form>--%>
  </body>
  <script type="text/javascript">
      function mousedown() {
          var register = document.getElementById("next");
          register.style.backgroundColor = "green"
      }
      function mouseup() {
          var register = document.getElementById("next");
          register.style.backgroundColor = "dodgerblue"
      }

      function inputFocus(ele) {
          // var a = document.getElementById("a");
          ele.style.width = "450px";
          ele.style.height = "50px";
          ele.style.borderColor = "red";
          ele.style.fontSize = "23px";
      }
      function inputBlur(ele) {
          // var b = document.getElementById("a");
          ele.style.width = "400px";
          ele.style.height = "40px";
          ele.style.borderColor = "";
          ele.style.fontSize = "18px";
      }

      var mydate=new Date();
      var minutes = mydate.getMinutes();
      var hours = mydate.getHours();
      var month=mydate.getMonth()+1;
      var day= mydate.getDate();
      var yar= mydate.getYear();
      document.write(yar+"-"+month+"-"+day+"\t"+hours+":"+minutes);

  </script>

</html>
