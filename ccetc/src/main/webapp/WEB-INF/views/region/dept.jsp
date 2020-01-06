<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>区域管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
function add() {
	window.location.href = "${pageContext.request.contextPath}/region/deptAddJump.action";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/region/deptEditjump.action?areaid="+rows[0].areaid+"&deptname="+rows[0].deptname;
	}
}
function query(){	
	var row = $(".pagination-page-list").val();//每页显示多少条
	var page = $(".pagination-num").val();//当前是第几页
	window.location.href="${pageContext.request.contextPath}/region/department.action?row="+row+"&page="+page;
}
$(function(){
	$("#dg").datagrid("getPager").pagination({
	    total: '${total}',
	    pageSize: 10,
	    pageList: [10,20,30],
	    pageNumber:parseInt('${department.page}'),
	    pageSize:'${department.row}',
	    onSelectPage: function(pageNumber, pageSize) {
	    	query();
	    }
	});
});
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
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,pagination:true,pagePosition:'bottom',fit:true,checkOnSelect:true,idField:'userid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'areaid',hidden:true,width:100">区域id</th>
<th data-options="field:'deptname',width:100">部门名称</th>
<th data-options="field:'areaname',width:100">所属区域</th>
</tr>
</thead>
<tbody>
<c:forEach items="${departmentList}" var="re">
<tr>
<td></td>
<td>${re.areaid}</td>
<td>${re.deptname}</td>
<td>${re.areaname.areaname}</td>
</tr>
 </c:forEach >
 </tbody>
</table>
</div>
</body>
</html>