<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户权限管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
function query(){
	var userid = $("#userid").val();
	var row = $(".pagination-page-list").val();//每页显示多少条
	var page = $(".pagination-num").val();//当前是第几页
	window.location.href="${pageContext.request.contextPath}/user/userRole.action?userid=" + userid +"&row=" + row + "&page=" + page;
}

function edit(){
	var rows = $('#dg').datagrid('getChecked');  
	if(rows.length > 1){
		$.messager.alert('消息','只能修改一笔数据！','info');
	}else if(rows.length == 0){
		$.messager.alert('消息','请选择一笔数据！','info');
	}else{
		window.location.href="${pageContext.request.contextPath}/user/userRoleEdit.action?userid=" + rows[0].userid;
	}
}

function status(value){
	var rows = $('#dg').datagrid('getChecked');
	if(rows.length == 0){
		$.messager.alert('消息','请选择数据！','info');
		return;
	}
	var ids = [];
	for(var i = 0 ; i < rows.length; i++){
		ids.push(rows[i].userid);
	}
	$.ajax({
		url:"${pageContext.request.contextPath}/user/userUpdateStatus.action",
		type:"post",
		data:{
			ids:ids.join(","),
			status : value
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

function resetPwd(){
	var rows = $('#dg').datagrid('getChecked');
	if(rows.length == 0){
		$.messager.alert('消息','请选择数据！','info');
		return;
	}
	var ids = [];
	for(var i = 0 ; i < rows.length; i++){
		ids.push(rows[i].userid);
	}
	$.ajax({
		url:"${pageContext.request.contextPath}/user/userUpdatePwd.action",
		type:"post",
		data:{
			ids:ids.join(",")
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

$(function(){
	$("#dg").datagrid("getPager").pagination({
	    total: '${total}',
	    pageSize: 10,
	    pageList: [10,20,30],
	    pageNumber:'${user.page}',
	    pageSize:'${user.row}',
	    onSelectPage: function(pageNumber, pageSize) {
	    	query();
	    }
	});
});

</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'条件检索'  " style="height: 68px;">
		<div style="float: left; margin-top: 5px; margin-left: 10px;">
			员工账号:${page}<input id="userid" class="easyui-textbox" style="width: 150px" value="${user.userid}"> <a onclick="query()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		</div>
		<div style="float: right; margin-top: 5px; margin-right: 10px;">
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a> 
			<a onclick="status(0)" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'">禁用</a> 
			<a onclick="status(1)" href="#"class="easyui-linkbutton" data-options="iconCls:'icon-ok'">启用</a>
			<a onclick="resetPwd()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置密码</a>
		</div>
	</div>
	<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
		<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,pagination:true,pagePosition:'bottom',fit:true,checkOnSelect:true,idField:'userid'">
			<thead>
				<tr>
					<th data-options="field:'checkbox',width:30,checkbox:true"></th>
					<th data-options="field:'username',width:300">名称</th>
					<th data-options="field:'userid',width:300">账号</th>
					<th data-options="field:'roleid',width:300">角色</th>
					<th data-options="field:'status',width:300">状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td></td>
						<td>${user.username}</td>
						<td>${user.userid}</td>
						<td>${user.roleid}</td>
						<td>
							<c:choose>
								<c:when test="${user.status == 0}">停用</c:when>
								<c:otherwise>启用</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>