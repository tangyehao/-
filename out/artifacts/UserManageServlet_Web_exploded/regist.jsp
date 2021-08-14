<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
	function getValue(){
		returnValue = document.myForm.userNo;
		close();
		}

	function validateData(){
		var userNo = document.myForm.userName.value;
		document.getElementById("msgName").innerHTML = "<font color = 'red'>*</font>";
		document.getElementById("msgName").innerHTML = "";
		if(userNo == ""){
			document.getElementById("msgName").innerHTML = "<font color = 'red'>请输入帐号</font>";
			document.getElementById("uName").style = "border-color : red;";
			return;
			}
		var userPwd = document.myForm.userPwd.value;
		document.getElementById("msgPwd").innerHTML = "<font color = 'red'>*</font>";
		document.getElementById('msgPwd').innerHTML = "";
		
		if(userPwd == ""){
				document.getElementById('msgPwd').innerHTML = "<font color = 'red'>请输入密码</font>";
				document.getElementById('uPwd').select();
				document.getElementById('uPwd').style = 'border-color : red';
				return;
		}
		var reg = /^[\w]{6,20}$/;
		if(!reg.test(userPwd)){
			document.getElementById('msgPwd').innerHTML = "<font color = 'red'>密码长度6-20位！</font>";
			document.getElementById('uPwd').style = 'border-color : red';
			return;
		}
		var userEPwd = document.myForm.userEPwd.value;
		document.getElementById("msgEPwd").innerHTML = "<font color = 'red'>*</font>";
		document.getElementById('msgEPwd').innerHTML = "";
		if(userPwd != userEPwd){
					document.getElementById("msgEPwd").innerHTML = 
					"<font color = 'red'>两次输入密码不一致！</font>";
					document.getElementById("uEPwd").select();
					document.getElementById("uEPwd").style = "border-color : red;";
					return;
			}
		var userPhone = document.myForm.userPhone.value;
		document.getElementById("msgPhone").innerHTML = "<font color = 'red'>*</font>";
		document.getElementById('msgPhone').innerHTML = "";	
		if(userPhone == ""){
			document.getElementById("msgPhone").innerHTML = "<font color = 'red'>请输入电话号码</font>";
			document.getElementById("uPhone").style = "border-color : red;";
			return;
			}			
	
		if(!(/^1[0-9]{10}$/).test(userPhone)){
			document.getElementById('msgPhone').innerHTML ="<font color = 'red'>电话号码非法！</font>";
			document.getElementById('uPhone').select();
			document.getElementById('uPhone').style = 'border-color : red'
			return;
		}
		var userEmail = document.myForm.userEmail.value;
		document.getElementById("msgEmail").innerHTML = "<font color = 'red'>*</font>";
		document.getElementById('msgEmail').innerHTML = "";
		if(userEmail == ""){
			document.getElementById("msgEmail").innerHTML = "<font color = 'red'>请输入邮箱</font>";
			document.getElementById("uEmail").style = "border-color : red;";
			return;
			}
		reg = /^\w+@\w+[\w\.]+\w+$/;		
		if(!reg.test(userEmail)){
			document.getElementById("msgEmail").innerHTML =
					"<font color = 'red'>邮箱非法</font>";
					return;
		}
		document.myForm.submit();
}
		function acceptBtn(obj){
				document.getElementById("btn").disabled = !obj.checked;
			}

  </script>
  </head>
  <body>
    <h1>用户注册</h1>

	<form action = "add" method = "post" name = "myForm">
		用户帐号：<input type = "text" name = "userName" id = "uName" value="${uInfo.username }">
		<div id = "msgName" style = "display:inline"><font color = "red">*</font></div><br>
		用户密码：<input type = "password" name = "userPwd" size = "21" id = "uPwd">
		<div id = "msgPwd" style = "display:inline"><font color = "red">*</font></div><br>	
		确认密码：<input type = "password" name = "userEPwd" size = "21" id = "uEPwd">
		<div id = "msgEPwd" style = "display:inline"><font color = "red">*</font></div><br>
		电话号码:&nbsp;&nbsp;&nbsp;<input type = 'text' name = 'userPhone' id = 'uPhone'>
		<div id = 'msgPhone' style = 'display:inline'><font color = "red">*</font></div><br>
		邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "userEmail" id = "uEmail">
		<div id = "msgEmail" style = "display:inline"><font color = "red">*</font></div><br>
		地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = 'text' name = 'userAddress'><p>
		备注:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textArea name = 'mText' rows = '5' clos = '20'></textArea><br>
		<input type = "reset" name = "reset" value = "重置">&nbsp;&nbsp;
		<input type = "button" id = "btn" value = "同意以下协议，并注册" disabled = "disabled" onclick = "validateData();"><p>
		<textarea >
1
2
3
4
5
		</textarea><p>
<input type = "checkbox" name = "recept" onclick = "acceptBtn(this)">同意<br>
	</form>
	<br>
	<div><h1>${msg}</h1></div>
  </body>
</html>
