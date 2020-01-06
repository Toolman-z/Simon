<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>教室管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
function add() {
	window.location.href = "${pageContext.request.contextPath}/classroom/roomaddjump.action?row=10&page=1";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/classroom/classroomEditjump.action?row=10&page=1&classroomid=" + rows[0].classroomid;
	}
}
function closestatue(){
	var rows = $('#dg').datagrid('getChecked');
	var id=rows[0].classroomid;
	if (rows.length > 1) {
		$.messager.alert('消息', '只能选择一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		$.ajax({
			url:"${pageContext.request.contextPath}/classroom/classstatus.action",
			type:"post",
			data:{
				classroomid:id,
				status:0
			},
			dataType:"json",
			success:function(data){
				if (data.success) {
					alert("已关闭");
					window.location.href = "${pageContext.request.contextPath}/classroom/roomjump.action";
				} else {
				alert("失败");
				}
			}
		});
		
	}
}
function openstatus(){
	var rows = $('#dg').datagrid('getChecked');
	var id=rows[0].classroomid;
	if (rows.length > 1) {
		$.messager.alert('消息', '只能选择一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		$.ajax({
			url:"${pageContext.request.contextPath}/classroom/classstatus.action",
			type:"post",
			data:{
				classroomid:id,
				status:1
			},
			dataType:"json",
			success:function(data){
				if (data.success) {
					alert("已开启");
					window.location.href = "${pageContext.request.contextPath}/classroom/roomjump.action";
				} else {
				alert("失败");
				}
							
			}
		});
		
	}
}
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'操作'  " style="height: 68px;">
<div style="float:right;margin-top: 5px; margin-right: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a>
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="openstatus()">开启</a> 
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closestatue()">关闭</a> 				
		</div>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'classroomid',hidden:true,width:300">教室id</th>
<th data-options="field:'classroomname',width:300">教室名称</th>
<th data-options="field:'areaname',width:300">所属区域</th>
<th data-options="field:'contain',width:300">容纳人数</th>
<th data-options="field:'status',width:300">教室状态</th>
</tr>
</thead>
<tbody>
<c:forEach items="${classroomList}" var="re">
<tr>
<td></td>
<td>${re.classroomid }</td>
<td>${re.calssroomname }</td>
<td>${re.areaname.areaname }</td>
<td>${re.contain }</td>
<td>
<c:choose>
			<c:when test="${re.status == 1}">开启</c:when>
			<c:otherwise>关闭</c:otherwise>
</c:choose>
</td>
</tr>
 </c:forEach >
 </tbody>
</table>
</div>
</body>
</html>