<%@page import="java.util.ArrayList"%>
<%@page import="com.chinasofti.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户</title>
</head>
<body>
	当前 时间:
	<fmt:formatDate value="${nowDate}" pattern="yyyy-MM-dd HH:mm:ss" />
	<form action="queryUsers" method="post">
		<input type="text" name="username" value="输入账号"> <input
			type="text" name="password" value="输入密码"> <input
			type="submit" value="查询">
	</form>
	<%
		Object obj = request.getAttribute("userList");
		List<User> userList = new ArrayList<User>();
		if (obj != null) {
			userList = (List<User>) obj;
		}
	%>
	<table border="1">
		<thead>
			<tr>
				<th>账号</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%-- <%
			for(User user : userList){
				out.write("<tr>");
				out.write("<td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td><td></td>");
				out.write("</tr>");
			}
		%> --%>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${ user.username }</td>
					<td><c:if test="${ user.password == null} ">无密码</c:if> ${ user.password }
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>