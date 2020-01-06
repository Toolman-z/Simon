<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>职务修改</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var boo=false;
$(document).ready(function(){
	$("#testrs").hide();
})
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/region/tech.action?row=10&page=1";
}

function test(){
	var ida=$("#ida").text();
	var name=$("#dutiesname").val();
	var a=$("#area").find("option:selected").val();
if(name != ""){
	$.ajax({
		url:"${pageContext.request.contextPath}/region/testtechnameedit.action?row=10&page=1",
		type:"POST",
		data:{
			technologyid:ida,
			areaid:a,
			technologyname:name
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
	alert("请填写技术方向");
}
}
function edit(){
	var ida=$("#ida").text();
	var name=$("#dutiesname").val();
	var a=$("#area").find("option:selected").val();
	if(boo && name!= ""){	
	$.ajax({
		url:"${pageContext.request.contextPath}/region/techEdit.action?row=10&page=1",
		type:"POST",
		data:{
			technologyid:ida,
			technologyname:name,
			areaid:a
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
				alert("修改成功");
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
<body class="easyui-layout">
<div data-options="region:'center',title:'原始数据'" style="padding: 5px;">
<table  id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid',heigth:300">
<thead>
<tr>
<th data-options="field:'dutiesid',hidden:true,width:300">技术方向id</th>
<th data-options="field:'dutiesname',width:300">技术方向</th>
<th data-options="field:'creatdate',width:300">创建日期</th>
<th data-options="field:'creatid',width:300">创建者</th>
<th data-options="field:'editid',width:300">修改者</th>
<th data-options="field:'editdate',width:300">修改日期</th>
<th data-options="field:'areaname',width:300">所属区域</th>

</tr>
</thead>
<tbody>
<c:forEach items="${tech}" var="re">
<tr>
<td id="ida">${re.technologyid }</td>
<td>${re.technologyname }</td>
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
<td>${re.areaname.areaname}</td>
</tr >
 </c:forEach >
</tbody>
</table>
<div style="z-index:2;position: absolute;top:150px">
 <table>
		<tr>
			<td>修改技术方向</td>
			<td><input type="text" onblur="test()" id="dutiesname" name="role"   style="width: 150px" /><span id="testrs">可用</span></td>
		</tr>	
		<tr>
			<td>修改技术方向所属区域</td>
			<td><select  style="width: 150px;" id="area" onblur="childone()">
					<c:forEach items="${List}" var="rea">
					<option value="${rea.areaid}">${rea.areaname}</option>
                    </c:forEach >
			</select></td>
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