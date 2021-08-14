<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  		<script>
		function validate(){
		var userName = document.myForm.userName.value;
		document.getElementById("msgNo").innerHTML = "<font color = 'red'>*</font>";
		msgNo.innerHTML = "";
		if(userName == ""){
			document.getElementById("msgNo").innerHTML = "<font color = 'red'>请输入帐号</font>";
			document.getElementById("uNo").style = "border-color : red;";
			return false;
			}
		var userPwd = document.myForm.userPwd.value;		
		document.getElementById("msgPwd").innerHTML = "<font color = 'red'>*</font>";
		msgPwd.innerHTML = "";
		if(userPwd == ""){
			document.getElementById("msgPwd").innerHTML = "<font color = 'red'>请输入密码</font>";
			document.getElementById("uPwd").style = "border-color : red;";
			return false;
			}
		return true;	
		}		
	</script>
  <body>
  		 <h1>用户登录</h1>
  		 <div ><font color="red">${msg }</font></div>
  		 <div ><font color="green">${success }</font></div>
  		  <div ><font color="red">${error }</font></div>
	  	 <form action = "login" method = "post" name = "myForm">
	   	 帐号：<input type="text" name = "userName" id="uNo" value="${userName }">
	   	 <div id = "msgNo" style = "display:inline"><font color = "red">*</font></div><br>
	   	 密码：<input type="password" name = "userPwd" id="uPwd">
	   	 <div id = "msgPwd" style = "display:inline"><font color = "red">*</font></div><br>
	   	 <input type="submit" name = "submit" value = "登录" onclick = "return validate();" >&nbsp;&nbsp;&nbsp;&nbsp;
	   	 <input type="reset" name = "reset" value = "重置">&nbsp;&nbsp;&nbsp;&nbsp;
	   	 <a href ="regist.jsp">新用户注册</a>  	
   </form>
		 <div><h1><font color="red">${msg}</font></h1></div>
  </body>
</html>
