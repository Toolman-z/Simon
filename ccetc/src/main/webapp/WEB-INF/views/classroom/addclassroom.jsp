<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>添加教室</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var boo=false;
var bood=false;
$(document).ready(function(){
	$("#testrs").hide();
	$("#testrsb").hide();
})
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/classroom/roomjump.action?row=10&page=1";
}
function add(){
	var na=$("#contain").val();
	var a=$("#area").find("option:selected").val();
	var name=$("#classroomname").val();
	if(boo && name!= "" && bood){
	$.ajax({
		url:"${pageContext.request.contextPath}/classroom/Addclassroom.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:a,
			calssroomname:name,
			contain:na
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				window.location.href = "${pageContext.request.contextPath}/classroom/roomjump.action?row=10&page=1";
			} else {
				$.messager.show({
					title : '消息',
					msg : data.message
				});
			}
		}
	});
	}else{
		alert("请重新填写");
	}
}
function testname(){
	var a=$("#area").find("option:selected").val();
	var name=$("#classroomname").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/classroom/testclassroomname.action?row=10&page=1",
		type:"POST",
		data:{
			calssroomname:name,
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

function testpeople(){	
	var name=$("#contain").val();
	var numtest=/^[0-9]*$/;//正则判断是否是数字 
	if(numtest.test(name)){
		$("#testrsb").show();
		return bood=true;
	}else{
		alert("请填写数字,例如“30”");
		return bood=false;
	}
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>教室名称</td>
			<td><input id="classroomname" name="role"   style="width: 150px"  onblur="testname()"><span id="testrs">教室名称可用</span></td>
		</tr>
		<tr>
			<td>容纳人数</td>
			<td><input id="contain" name="rolepeople"   style="width: 150px"  onblur="testpeople()"><span id="testrsb">通过</span></td>
		</tr>
		<tr>
			<td>教室所属区域</td>
			<td><select  style="width: 150px;" id="area">
					<c:forEach items="${areaList}" var="re">
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