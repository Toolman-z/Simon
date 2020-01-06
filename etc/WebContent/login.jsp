<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script>
function reg(){
	window.location.href="user.jsp"
}
</script>
</head>
<body>
	<font color="red"><%= request.getAttribute("message")==null?"": request.getAttribute("message") %></font>
	<form action="login" method="post">
		账号:<input type="text" name="username"><br> 
		密码:<input type="password" name="password"><br> 
		<input type="submit" value="登录">
		<a href="reg.jsp"><input type="button" value="注册"></a> 
		<input type="button" value="查询" onclick="reg()">
	</form>
</body>
</html>