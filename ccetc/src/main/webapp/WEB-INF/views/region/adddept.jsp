<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>添加部门</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var boo;
$(document).ready(function(){
	$("#testrs").hide();
})
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/region/department.action?row=10&page=1";
}
function add(){
	var name=$("#deptname").val();
	if(boo && name!= ""){
	var a=$("#area").find("option:selected").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/deptAdd.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:a,
			deptname:$("#deptname").val()
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				window.location.href = "${pageContext.request.contextPath}/region/department.action?row=10&page=1";
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
function test(){
	var a=$("#area").find("option:selected").val();
	var name=$("#deptname").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/testdeptname.action?row=10&page=1",
		type:"POST",
		data:{
			deptname:name,
			areaid:a
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				$("#testrs").show();
				return boo=true;				
			} else {
				$.messager.show({
					title : '名称重复',
					msg : data.message
				});
				$("#testrs").hide();
				alert("名称重复");
				return boo=false;
			}
		}
	});
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>部门名称</td>
			<td><input id="deptname" name="role"   style="width: 150px"  onblur="test()"><span id="testrs">区域名可用</span></td>
		</tr>
		<tr>
			<td>部门所属区域</td>
			<td><select  style="width: 150px;" id="area">
					<c:forEach items="${List}" var="re">
					<option value="${re.areaid}">${re.areaname}</option>
                    </c:forEach >
			</select></td>
		</tr>		
		<tr>
			<td><a onclick="add()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</body>
</html>