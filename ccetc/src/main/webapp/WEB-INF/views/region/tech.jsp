<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>技术方向管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
function add() {
	window.location.href = "${pageContext.request.contextPath}/region/techAddJump.action?row=10&page=1";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/region/techEditjump.action?row=10&page=1&technologyid=" + rows[0].technologyid;
	}
}
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'操作'  " style="height: 68px;">
<div style="float:right;margin-top: 5px; margin-right: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a> 				
		</div>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'technologyid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'technologyid',hidden:true,width:300">技术方向id</th>
<th data-options="field:'name',width:300">技术方向</th>
<th data-options="field:'area',width:300">所属区域</th>
</tr>
</thead>
<tbody>
<c:forEach items="${techList}" var="re">
<tr>
<td></td>
<td>${re.technologyid }</td>
<td>${re.technologyname }</td>
<td>${re.areaname.areaname }</td>
</tr>
 </c:forEach >
 </tbody>
</table>
</div>
</body>
</html>