<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改员工权限</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
function cancel(){
	window.history.back();
}

function update(){
	$.ajax({
		url:"${pageContext.request.contextPath}/user/userRoleUpdate.action",
		type:"post",
		data:{
			userid:$("#userid").val(),
			roleid:$("#roleid").combobox('getValue'),
			status:$("#status").combobox('getValue')
		},
		dataType:"json",
		success:function(data){
			if(data.success){
				window.location.href="${pageContext.request.contextPath}/user/userRole.action?row=10&page=1";
			}else{
				$.messager.show({
					title:'消息',
					msg:data.message
				});
			}
		}
	});
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>用户账户</td>
			<td>${user.userid}<input type="hidden" id="userid" value="${user.userid}"/></td>
		</tr>
		<tr>
			<td>用户名称</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>角色</td>
			<td>
				<select class="easyui-combobox" style="width: 150px;" id="roleid">
					<c:forEach items="${roleList}" var="role">
						<option <c:if test="${role.roleid == user.roleid}">selected="selected"</c:if> value="${role.roleid}">${role.role}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<select class="easyui-combobox"  style="width: 150px;" id="status">
					<option <c:if test="${user.status == '1'}">selected="selected"</c:if> value="1">启用</option>
					<option <c:if test="${user.status == '0'}">selected="selected"</c:if> value="0">停用</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><a onclick="update()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> </td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</body>
</html>