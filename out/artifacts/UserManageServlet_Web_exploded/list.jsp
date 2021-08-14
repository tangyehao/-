<%@page import="cn.com.service.UserBeanServiceInf"%>
<%@page import="cn.com.service.UserBeanServiceImpl"%>
<%@page import="cn.com.pojo.UserBean"%>
<jsp:useBean id="u" class = "cn.com.pojo.UserBean"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <title>list.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
		<c:if test="${uInfo == null }">
		<c:set var = "msg" value = "您没有登录，请登录后操作" scope = "page"></c:set>
		<jsp:forward page = "jump.jsp"></jsp:forward>
		</c:if>			
		<h1>用户信息表</h1>
		<h2>欢迎您:${uInfo.username }</h2>
		<form action = 'search' method = 'post'>
		帐号<input type = 'text' name = 'userName'>&nbsp;<input type = 'submit' value = '查询'><br>
		</form>
		<table border= '1' cellSpacing = '0' cellPadding = '0'>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>电话</th>
				<th>email</th>
				<th>地址</th>
				<th>备注</th>
				<th>操作</th>	
			</tr>
		<c:forEach var = "u" items="${allInfo }" varStatus="s">
		<tr>
			<td>${s.count }</td>
			<td>${u.username }</td>
			<td>${u.phone }</td>
			<td>${u.email}</td>
			<td>${u.address }</td>
			<td>${u.mtext }</td>
			<td>
			<a href="updateUser?userId=${u.userid}">修改</a>&nbsp;
			<c:choose>
			 <c:when test="${uInfo.userid == u.userid }">
			 	删除
			 </c:when>
			 <c:otherwise>
			 <a href="del?userId=${u.userid }">删除</a>
			 </c:otherwise>
			 </c:choose>
		</c:forEach>	
	</table>
		<div><h1><font color="red">${msg}</font></h1></div>
		<br>
  </body>
</html>
