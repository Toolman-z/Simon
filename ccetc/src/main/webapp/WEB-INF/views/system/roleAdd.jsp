<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户角色添加</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	function cancel() {
		window.history.back();
	}

	function insert() {
		var nodes = $('#tree').tree('getChecked', [ 'checked', 'indeterminate' ]);
		var authids = [];
		for (var i = 0; i < nodes.length; i++) {
			authids.push(nodes[i].id);
		}
		$.ajax({
			url : "${pageContext.request.contextPath}/system/roleInsert.action",
			type : "post",
			data : {
				role : $("#role").val(),
				status : $("#status").combobox('getValue'),
				remark : $("#remark").val(),
				authids : authids.join(",")
			},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					window.location.href = "${pageContext.request.contextPath}/system/role.action";
				} else {
					$.messager.show({
						title : '消息',
						msg : data.message
					});
				}
			}
		});
	}
</script>
</head>
<body class="easyui-layout">
	<table>
		<tr>
			<td>角色名称</td>
			<td><input id="role" name="role" class="easyui-textbox"  style="width: 150px"></td>
		</tr>
		<tr>
			<td>状态</td>
			<td><select class="easyui-combobox" style="width: 150px;" id="status">
					<option <c:if test="${user.status == '1'}">selected="selected"</c:if> value="1">启用</option>
					<option <c:if test="${user.status == '0'}">selected="selected"</c:if> value="0">停用</option>
			</select></td>
		</tr>
		<tr>
			<td>角色描述</td>
			<td><input id="remark" name="role" class="easyui-textbox" style="width: 150px"></td>
		</tr>
		<tr>
			<td>拥有权限</td>
			<td>
				<ul id="tree" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/system/authTree.action',checkbox:true"></ul>
			</td>
		</tr>
		<tr>
			<td><a onclick="insert()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</body>
</html>