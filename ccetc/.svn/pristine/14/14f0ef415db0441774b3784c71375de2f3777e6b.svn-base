<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<jsp:include page="inc.jsp"></jsp:include>
		<title></title>
		<script>
			function menu(title,url) {
				$("#iframe").attr("src", '${pageContext.request.contextPath}'+url);
				$('#cc').panel('setTitle', title);
			}
		</script>
	</head>

	<body class="easyui-layout">
		<div data-options="region:'north'" style="height:60px;">
			<div style="float: left;"><img src="resources/img/logo.png" /></div>
			<div style="float: right;margin-top: 30px;">管理员，欢迎您！
				<a href="#" class="easyui-linkbutton" data-options="">退出</a>
			</div>
		</div>
		<div data-options="region:'south'" style="height:25px;">
			<div align="center">Copy Right &copy; 中软国际</div>
		</div>
		<div data-options="region:'west',title:'菜单导航',collapsible:false" style="width:150px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<c:forEach items="${menuList}" var="auth">
					<div title="${auth.authname}">
					<ul class="easyui-tree">
						<c:forEach items="${auth.children}" var="au">
						<li>
							<div onclick="menu('${auth.authname}>${au.authname}','${au.url}')"><span>${au.authname}</span></div>
						</li>
						</c:forEach>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
		<div id="cc" data-options="region:'center',title:'内容'" style="padding:5px;">
			<iframe id="iframe" src="" width="100%" height="99%" style="border: 0px;"></iframe>
		</div>
	</body>

</html>