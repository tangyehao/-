<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="cn.com.service.UserBeanServiceInf"%>
<%@page import="cn.com.service.UserBeanServiceImpl"%>
<%@page import="cn.com.pojo.UserBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    <title>My JSP 'updateList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function validate(){
		
		var userPwd = document.myform.userPwd.value;
		document.getElementById('msgPwd').innerHTML ="";
		if(userPwd == ''){
		document.getElementById('msgPwd').innerHTML = "<font color = 'red'>请输入密码</font>";
		document.getElementById('uPwd').style = "border-color : red;";
		return ;
		}
		var reg = /^[\w]{6,20}$/;
		if(!reg.test(userPwd)){
			document.getElementById('msgPwd').innerHTML = "<font color = 'red'>密码长度6-20位！</font>";
			document.getElementById('uPwd').style = 'border-color : red';
			return;
		}

		var userPhone = document.myform.userPhone.value;
		document.getElementById('msgPhone').innerHTML ="";
		if(userPhone == ''){
		document.getElementById('msgPhone').innerHTML = "<font color = 'red'>请输入电话</font>";
		document.getElementById('uPhone').style = 'border-color : red';
		return;
		}
		reg = /^1[0-9]{10}$/;
		if(!reg.test(userPhone)){
		document.getElementById('msgPhone').innerHTML ="<font color = 'red'>电话号码非法！</font>";
		document.getElementById('uPhone').style = 'border-color : red';
		return ;
		}
		
		var userEmail = document.myform.userEmail.value;
			document.getElementById('msgEmail').innerHTML ="";
		if(userEmail == ''){
			document.getElementById('msgEmail').innerHTML = "<font color = 'red'>请输入邮箱</font>";
			document.getElementById('uEmail').style = 'border-color : red';
		return ;
		}
		reg = /\w+@\w+[\w\.]+\w+$/;
		if(!reg.test(userEmail)){
		document.getElementById('msgEmail').innerHTML ="<font color = 'red'>邮箱非法！</font>";
		document.getElementById('uEmail').style = 'border-color : red';
		return ;
		}
			document.getElementById('form').submit();
		}
		</script>
  </head>
  
  <body>		
  		<c:if test="${uInfo == null }">
		<c:set var = "msg" value = "您没有登录，请登录后操作" scope = "page"></c:set>
		<jsp:forward page = "jump.jsp"></jsp:forward>
		</c:if>	
		<h1>当前操作员是:${uInfo.username}</h1>		
		<form action = 'update' method = 'post' name = 'myform' id = 'form'>
		<input type = 'hidden' name = 'userId'value = "${ui.userid }">
		帐号:<input type = 'text' name = 'userName' readonly = 'readonly' value = "${ui.username }"><br>
		密码<input type = 'password' name = 'userPwd' id = 'uPwd'><br>
		<div id = 'msgPwd' style = 'display:inline'></div><br>
		电话:<input type = 'text' name = 'userPhone' id = 'uPhone' value = "${ui.phone}"><br>
		<div id = 'msgPhone' style = 'display:inline'></div><br>
		email:<input type = 'text' name = 'userEmail' id = 'uEmail' value = "${ui.email}"><br>
		<div id = "msgEmail" style = "display:inline"></div><br>
		地址:<input type = 'text' name = 'userAddress' value = "${ui.address}"><br>
		备注:<textArea name = 'mText' rows = '5' cols = '20'>${ui.mtext}</textArea><br>
		<input type = 'button' value = '确认修改' onclick='validate()'>&nbsp;<input type = 'reset' value = '重置' >
		</form> 
  </body>
  <div ><font color="red">${error }</font></div>
</html>
