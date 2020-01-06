<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>区域修改</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var boo;
$(document).ready(function(){
	$("#testrs").hide();
})
function test(){
	
	var name=$("#areaname").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/testareaname.action?row=10&page=1",
		type:"POST",
		data:{
			areaname:name
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				$.messager.show({
					title : '名称重复',
					msg : data.message
				});
				$("#testrs").hide();
				alert("名称重复");
				return boo=false;
			} else {
				
				$("#testrs").show();
				return boo=true;
			}
		}
	});
}
function edit(){
	var name=$("#areaname").val();
	var ida=$("#ida").text();
	if(boo && name!= ""){	
	$.ajax({
		url:"${pageContext.request.contextPath}/region/areaEdit.action?row=10&page=1",
		type:"POST",
		data:{
			areaname:$("#areaname").val(),
			areaid:ida
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				alert("修改成功");
				window.location.href = "${pageContext.request.contextPath}/region/adm.action?row=10&page=1";
			} else {
				$.messager.show({
					title : '消息',
					msg : data.message
				});
			}
		}
	});
	}else{
		alert("请重新填写名称");
	}
}
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/region/adm.action?row=10&page=1";
}
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'center',title:'原始数据'" style="padding: 5px;">
<table  id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid',heigth:300">
<thead>
<tr>
<th data-options="field:'areaid',hidden:true,width:300">区域id</th>
<th data-options="field:'areaname',width:300">区域名称</th>
<th data-options="field:'creatdate',width:300">区域创建日期</th>
<th data-options="field:'creatid',width:300">区域创建者</th>
<th data-options="field:'editid',width:300">区域修改者</th>
<th data-options="field:'editdate',width:300">区域修改日期</th>
</tr>
</thead>
<tbody>
<c:forEach items="${area}" var="re">
<tr>
<td id="ida">${re.areaid }</td>
<td>${re.areaname }</td>
<td>
<c:choose>
			<c:when test="${re.createdate == null}">无</c:when>
			<c:otherwise>
			<c:set var="now" value="${re.createdate }" />
			<fmt:formatDate pattern="yyyy-MM-dd" 
            value="${now}" />
			</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
			<c:when test="${re.createid == null}">无</c:when>
			<c:otherwise>${re.createid }</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
			<c:when test="${re.editid == null}">暂无修改者</c:when>
			<c:otherwise>${re.editid }</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
			<c:when test="${re.editdate == null}">暂无修改日期</c:when>
			<c:otherwise>
			<c:set var="noww" value="${re.editdate }" />
			<fmt:formatDate pattern="yyyy-MM-dd" 
            value="${noww}" />
			</c:otherwise>
</c:choose>
</td>
</tr >
 </c:forEach >
</tbody>
</table>
<div style="z-index:2;position: absolute;top:150px">
 <table>
		<tr>
			<td>修改区域名称</td>
			<td><input type="text" onblur="test()" id="areaname" name="role"   style="width: 150px" /><span id="testrs">区域名可用</span></td>
		</tr>		
		<tr>
			<td><a onclick="edit()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</div>
	</div>
</body>
</html>