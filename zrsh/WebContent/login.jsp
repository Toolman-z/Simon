<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>超进化失败</h1>
<h1>时总狠狠的打了你的头</h1>
<h6>您的账号是：<%= request.getParameter("username") %></h6>
<h6>您的密码是：<%= request.getParameter("password") %></h6>
<h6>您的IP是：<%= request.getRemoteAddr()%></h6>
</body>
</html>