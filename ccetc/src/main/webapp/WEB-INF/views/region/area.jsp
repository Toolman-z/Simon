<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>区域管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
function add() {
	window.location.href = "${pageContext.request.contextPath}/region/areaAddJump.action?row=10&page=1";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/region/areaEditjump.action?row=10&page=1&areaid=" + rows[0].areaid;
	}
}
function delt(){
	var rows = $('#dg').datagrid('getChecked');
	 if (rows.length > 1) {
			$.messager.alert('消息', '只能修改一笔数据！', 'info');
		} else if (rows.length == 0) {
			$.messager.alert('消息', '请选择一笔数据！', 'info');
		} else {
			$("#dd").panel('open');
			deltfive();
		}
	
}
function deltfive(){
	var rows = $('#dg').datagrid('getChecked');
	var areaid=rows[0].areaid;
	 $("#delt").empty();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/deltfive.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:areaid
		},
		dataType:"json",
		success:function(data){			
			 var obj='';       			 
			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +="<tr><td> "+option.areaname+" </td><td> "+option.deptname.deptname+" </td><td> "+option.technologyname.technologyname+" </td><td> "+option.dutiesname.dutiesname+" </td><td> "+option.username.username+" </td></tr>";
				  };				 
				  $("#delt").append(obj);
		}
	});
}
function cancel(){
	$("#dd").panel('close');
}
$(function(){
	$("#dg").datagrid("getPager").pagination({
	    total: '${total}',
	    pageSize: 10,
	    pageList: [10,20,30],
	    pageNumber:parseInt('${region.page}'),
	    pageSize:'${region.row}',
	    onSelectPage: function(pageNumber, pageSize) {
	    	query();
	    }
	});
});
function query(){	
	var row = $(".pagination-page-list").val();//每页显示多少条
	var page = $(".pagination-num").val();//当前是第几页
	window.location.href="${pageContext.request.contextPath}/region/adm.action?row="+row+"&page="+page;
}
function getPos(ev){	
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;	
	var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft;	
	return {x:ev.clientX+scrollLeft,y:ev.clientY+scrollTop}}document.onmousemove = function(ev){	
		var oDiv = document.getElementsByTagName('p')	
		var oEvent = ev||event;	var pos = getPos(oEvent)	
		//后面的div跟这前面的div走	
		for(var i = oDiv.length-1; i>0;i--){		
			oDiv[i].style.left = oDiv[i-1].offsetLeft+'px';		
			oDiv[i].style.top = oDiv[i-1].offsetTop+'px';	}	
		//第一个div跟着鼠标走	
		oDiv[0].style.left = pos.x+'px';	
		oDiv[0].style.top = pos.y+'px'; } 
</script>
<style type="text/css">
.divc{

	width: 10px;

	height: 10px;
	
	background: url(resources/img/jupp.gif);

	position: absolute;

    z-index:100;
    
    pointer-events:none;
}
</style>
</head>
<body class="easyui-layout" style="width:100%;height:100%">
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>

<div data-options="region:'north',title:'操作'  " style="height: 68px;">
<div style="float:right;margin-top: 5px; margin-right: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a> 	
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="delt()">删除</a> 			
		</div>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">

<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,pagination:true,pagePosition:'bottom',fit:true,checkOnSelect:true,idField:'areaid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'areaid',hidden:true,width:300">区域id</th>
<th data-options="field:'username',width:300">区域名称</th>
</tr>
</thead>
<tbody>
<c:forEach items="${regionList}" var="re">
<tr>
<td></td>
<td>${re.areaid }</td>
<td>${re.areaname }</td>
 </tr>
 </c:forEach >
 </tbody>
</table>
</div>
<div id="dd" class="easyui-dialog" title="确认删除" style="width:800px;height:400px;" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
<div align="center" ><span><font color="red" size="5">您的此次删除操作将会对以下信息造成影响</font></span></div>
<div align="center">
<br> <br> <br> <br> 
<table>
<thead>
<tr>
<th style="width:50px;">区域</th>
<th style="width:50px;">部门</th>
<th style="width:100px;">技术方向</th>
<th style="width:100px;">职务</th>
<th style="width:100px;">员工</th>
</tr>
</thead>
<tbody id="delt">
</tbody>
</table>
</div >
<div align="center">
<br> <br> <br> <br> 
<a onclick="remove()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">删除</a> 
 <a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
 </div> 
</div>    
</body>
</html>