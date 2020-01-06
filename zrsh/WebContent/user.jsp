<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>进化成功了</h1>
<h1>邹运变成了精神小伙</h1>
<h6>您的账号是：<%= request.getParameter("username") %></h6>
<h6>您的密码是：<%= request.getParameter("password") %></h6>
<h6>您的IP是：<%= request.getRemoteAddr()%></h6>
<h6>您的登陆状态：<%= session.getAttribute("login") %></h6>
<%!
public int add(int x,int y){
	return x+y;
}
Date d= new Date();
%>
现在时间：<%= d.toLocaleString() %>
</body>
</html>