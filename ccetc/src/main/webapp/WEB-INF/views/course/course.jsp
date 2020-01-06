<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>课程体系</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
function add() {
	window.location.href = "${pageContext.request.contextPath}/classroom/roomaddjump.action?row=10&page=1";
}
function exp(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能导出一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		expp();
	}
}
function sc(){
	$("#dd").panel('open');
}
function cancel(){
	$("#dd").panel('close');
}
function save(){
	
	$("#form").submit();
	
}

function savetwo(){
	
	$("#formtwo").submit();
}
function expp(){
	var rows = $('#dg').datagrid('getChecked');
	var clazzid=rows[0].clazzid;
	$.ajax({
		url:"${pageContext.request.contextPath}/course/exp.action",
		type:"post",
		data:{
			clazzid:clazzid
		},
		dataType:"json",
		success:function(data){
			if(data.success){
				window.location.href = "${pageContext.request.contextPath}/resources/file/downloads/users.xls";
			}
		}
	});
}
function change(){
	var rows = $('#dg').datagrid('getChecked');	
	var courseid= rows[0].courseid;
	var oldtechnologyid=rows[0].clazzid;
	alert(oldtechnologyid);
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		$("#cc").panel('open');
		$("#courseidid").val(courseid);
		$("#courseidid").hide();	
		$("#oldtechnologyidid").val(oldtechnologyid);
		$("#oldtechnologyidid").hide();
	}
	
}
function test(){
	
}

</script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'操作'  " style="height: 68px;">
<div style="float:right;margin-top: 5px; margin-right: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="sc()">上传</a>
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="exp()">导出</a> 
			<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="change()">修改</a>				
		</div>
</div>

<div id="dd" class="easyui-dialog" title="文件上传" style="width:400px;height:200px;" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    <form id="form" action="${pageContext.request.contextPath}/course/sc.action" method="post" enctype="multipart/form-data">
    <a href="${pageContext.request.contextPath}/resources/file/user_template.xls">下载模板(excel格式)</a>
  <br>
  选择技术方向：<select  style="width: 150px;" id="technology" name="technologyid">
					<c:forEach items="${tech}" var="tech">
					<option value="${tech.technologyid}">${tech.technologyname}</option>
                    </c:forEach >
 </select>
  
  <br>
  课程体系名称：<input type="text"  style="width:140px" name="coursename"><br>    
    <input name="file" class="easyui-filebox" style="width:300px"><br>
    <a onclick="save()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
    <a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>                              
     </form>
</div>
<div id="cc" class="easyui-dialog" title="文件上传" style="width:400px;height:200px;" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    <form id="formtwo" action="${pageContext.request.contextPath}/course/xg.action" method="post" enctype="multipart/form-data">
    <a href="${pageContext.request.contextPath}/resources/file/user_template.xls">下载模板(excel格式)</a>
  <br>
  选择技术方向：<select  style="width: 150px;" id="technology" name="technologyid">
					<c:forEach items="${tech}" var="tech">					
					
				<option value="${tech.technologyid}">${tech.technologyname}
					</option>												
                    </c:forEach >
 </select>
  
  <br>
  课程体系名称：<input type="text"  style="width:140px" name="coursename" id="coursenameee" ><br> 
  <input type="text"  style="width:140px" name="courseid" id="courseidid"> 
  <input type="text"  style="width:140px" name="oldtechnologyid" id="oldtechnologyidid">   
    <input name="file" class="easyui-filebox" style="width:300px"><br>
    <a onclick="savetwo()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
    <a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>                              
     </form>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'clazzid',hidden:true,width:300">id</th>
<th data-options="field:'courseid',hidden:true,width:300">id</th>
<th data-options="field:'name',width:300">课程名称</th>
</tr>
</thead>
<tbody>
<c:forEach items="${course}" var="cour">
<tr>
<td></td>
<td>
${cour.technologyid}
</td>
<td>${cour.courseid}</td>
<td>${cour.coursename}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>