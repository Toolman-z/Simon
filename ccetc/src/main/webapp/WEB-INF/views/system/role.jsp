<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户角色</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	function add() {
		window.location.href = "${pageContext.request.contextPath}/system/roleAdd.action";
	}

	function edit() {
		var rows = $('#dg').datagrid('getChecked');
		if (rows.length > 1) {
			$.messager.alert('消息', '只能修改一笔数据！', 'info');
		} else if (rows.length == 0) {
			$.messager.alert('消息', '请选择一笔数据！', 'info');
		} else {
			window.location.href = "${pageContext.request.contextPath}/system/roleEdit.action?roleid=" + rows[0].roleid;
		}
	}

	function remove() {
		var rows = $('#dg').datagrid('getChecked');
		if (rows.length == 0) {
			$.messager.alert('消息', '请选择一笔数据！', 'info');
		} else {
			$.messager.confirm('确认对话框', '您确认删除么？', function(r) {
				if (r) {
					var ids = [];
					for(var i = 0 ; i < rows.length; i++){
						ids.push(rows[i].roleid);
					}
					$.ajax({
						url : "${pageContext.request.contextPath}/system/roleDelete.action",
						type : "post",
						data : {
							roleids : ids.join(",")
						},
						dataType : "json",
						success : function(data) {
							if (data.success) {
								$.messager.alert('消息', '操作成功', 'info');
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
			});

		}
	}
	
	function status(){
		var rows = $('#dg').datagrid('getChecked');
		if(rows.length == 0){
			$.messager.alert('消息','请选择数据！','info');
			return;
		}
		var ids = rows[0].roleid;
		alert(ids);
		$.ajax({
			url:"${pageContext.request.contextPath}/user/userUpdateroleStatus.action",
			type:"post",
			data:{
				roleid:ids,
				status :0
			},
			dataType:"json",
			success:function(data){
				if(data.success){
					$.messager.alert('消息','操作成功','info');
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
	function status1(){
		var rows = $('#dg').datagrid('getChecked');
		if(rows.length == 0){
			$.messager.alert('消息','请选择数据！','info');
			return;
		}
		var ids = rows[0].roleid;
		$.ajax({
			url:"${pageContext.request.contextPath}/user/userUpdateroleStatus.action",
			type:"post",
			data:{
				roleid:ids,
				status :1
			},
			dataType:"json",
			success:function(data){
				if(data.success){
					$.messager.alert('消息','操作成功','info');
					window.location.href="${pageContext.request.contextPath}/system/role.action";
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
<body class="easyui-layout">
	<div data-options="region:'north',title:'操作列表'  " style="height: 68px;">
		<div style="float: right; margin-top: 5px; margin-right: 10px;">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a> <a
				onclick="remove()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a> <a onclick="status()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'">禁用</a>
			<a onclick="status1()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">启用</a>
		</div>
	</div>
	<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
		<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid'">
			<thead>
				<tr>
					<th data-options="field:'checkbox',width:30,checkbox:true"></th>
					<th data-options="field:'roleid',hidden:true,width:300">角色ID</th>
					<th data-options="field:'role',width:300">角色名称</th>
					<th data-options="field:'count',width:300">用户数量</th>
					<th data-options="field:'remark',width:300">角色说明</th>
					<th data-options="field:'status',width:300">状态状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roleList}" var="role">
					<tr>
						<td></td>
						<td>${role.roleid}</td>
						<td>${role.role}</td>
						<td>${role.count}</td>
						<td>${role.remark}</td>
						<td><c:choose>
								<c:when test="${role.status == 0}">禁用</c:when>
								<c:otherwise>启用</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>