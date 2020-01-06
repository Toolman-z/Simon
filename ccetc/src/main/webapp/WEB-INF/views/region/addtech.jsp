<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>添加技术方向</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
var boo=false;
$(document).ready(function(){
	$("#testrs").hide();
})
function test(){
	var a=$("#area").find("option:selected").val();
	var name=$("#techname").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/testtechname.action?row=10&page=1",
		type:"POST",
		data:{
			technologyname:name,
			areaid:a
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
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/region/tech.action?row=10&page=1";
}
function add(){
	var a=$("#area").find("option:selected").val();
	var name=$("#techname").val();
	if(boo && name!= ""){	
	$.ajax({
		url:"${pageContext.request.contextPath}/region/techAdd.action?row=10&page=1",
		type:"POST",
		data:{
			technologyname:name,
			areaid:a
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				alert("添加成功");
				window.location.href = "${pageContext.request.contextPath}/region/tech.action?row=10&page=1";
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
</script>
</head>
<body>
<table>
		<tr>
			<td>技术方向</td>
			<td><input type="text" onblur="test()" id="techname" name="role"   style="width: 150px" /><span id="testrs">技术方向可用</span></td>
		</tr>
			<tr>
			<td>所属区域</td>
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