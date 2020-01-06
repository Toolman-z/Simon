<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>添加职务</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var boo=false;
$(document).ready(function(){
	$("#testrs").hide();
})
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/region/duties.action?row=10&page=1";
}
function test(){
	
	var a=$("#area").find("option:selected").val();
	var d=$("#dept").find("option:selected").val();
	var name=$("#dutiesname").val();
	
	if(name != ""){
	$.ajax({
		url:"${pageContext.request.contextPath}/region/testdutiesname.action?row=10&page=1",
		type:"POST",
		data:{
			deptid:d,
			areaid:a,
			dutiesname:name
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
	}else{
		alert("请输入职务名称");
	}
}
function add(){
	var a=$("#area").find("option:selected").val();
	var d=$("#dept").find("option:selected").val();
	var name=$("#dutiesname").val();
	if(boo && name!= ""){	
	$.ajax({
		url:"${pageContext.request.contextPath}/region/dutiesAdd.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:a,
			deptid:d,
			dutiesname:name
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				window.location.href = "${pageContext.request.contextPath}/region/duties.action?row=10&page=1";
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
function childone(){
	 $("#dept").empty();
	var areaid=$("#area").find("option:selected").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/childone.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:areaid		
		},
		dataType:"json",
		success:function(data){
			 var obj='';       			 
 			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +="<option value='"+option.deptid+"'>"+option.deptname+"</option>";
				  };
				 
				  $("#dept").append(obj);
		}
	});
}
</script>
</head>
<body>
<table>
		<tr>
			<td>职务名称</td>
			<td><input id="dutiesname" name="role"   style="width: 150px"  onblur="test()"><span id="testrs">职务名称可用</span></td>
		</tr>
		<tr>
			<td>职务所属区域</td>
			<td><select  style="width: 150px;" id="area" onblur="childone()">
					<c:forEach items="${List}" var="re">
					<option value="${re.areaid}">${re.areaname}</option>
                    </c:forEach >
			</select></td>
		</tr>	
		<tr>
			<td>职务所属部门</td>
			<td><select  style="width: 150px;" id="dept">
					<%-- <c:forEach items="${deptList}" var="re">
					<option value="${re.deptid}">${re.deptname}</option>
                    </c:forEach > --%>
			</select></td>
		</tr>		
		<tr>
			<td><a onclick="add()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</body>
</html>