<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
$(document).ready(function(){	
	$("#technology").hide();//隐藏技术方向
	$("#dept").hide();//隐藏教室
	  $("#duties").hide();//隐藏技术方向
	  $("#two").hide();//隐藏技术方向
		$("#three").hide();//隐藏教室
		  $("#four").hide();//隐藏技术方向
})
function muohu(){
	var userid = $("#userid").val();
	$.ajax({
		url:"",
		type:"",
		data:{},
		dataType:"json",
		success:function(data){
			
		}
	});
}
function sc(){
	$("#dd").panel('open');
}
function cancel(){
	$("#technology").hide();//隐藏技术方向
	$("#dept").hide();//隐藏教室
	  $("#duties").hide();//隐藏技术方向
	$("#dd").panel('close');
}
function save(){
	$("#form").submit();
}

function add() {
	window.location.href = "${pageContext.request.contextPath}/user/userAddJump.action?row=10&page=1";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/user/userEditjump.action?row=10&page=1&userid=" + rows[0].userid;
	}
}
$(function(){
	$("#dg").datagrid("getPager").pagination({
	    total: '${total}',
	    pageSize: 10,
	    pageList: [10,20,30],
	    pageNumber: parseInt('${user.page}'),
	    pageSize:'${user.row}',
	    onSelectPage: function(pageNumber, pageSize) {
	    	query();
	    }
	});
});
function query(){	
	var userid = $("#userid").val();
	var row = $(".pagination-page-list").val();//每页显示多少条
	var page =$(".pagination-num").val();//当前是第几页
	if (userid == ""){
		window.location.href="${pageContext.request.contextPath}/user/user.action?row="+row+"&page="+page+"&userid=" + userid;
	}else{
	
	window.location.href="${pageContext.request.contextPath}/user/user.action?row=10&page=1&userid="+userid+"";
}
}
function childone(){
	 $("#technology").empty();
	 var areaid=$("#area").find("option:selected").val();
	 
	 $.ajax({
			url:"${pageContext.request.contextPath}/region/childthree.action",
			type:"POST",
			data:{
				areaid:areaid		
			},
			dataType:"json",
			success:function(data){
				 var obj='';       			 
				 for(var i=0;i<data.length;i++){     				 
					   var option=data[i];  				   
					   obj +="<option value='"+option.technologyid+"'>"+option.technologyname+"</option>";
					  };
					  childonee();
					  $("#technology").append(obj);					 
						$("#technology").show();//显示技术方向
						$("#dept").show();//显示技术方向
						 $("#duties").hide();//隐藏职务
						 $("#two").show();//显示技术方向
							$("#three").show();//显示技术方向
							 $("#four").hide();//隐藏职务
			}
		});
}
function childonee(){
	 $("#dept").empty();
	var areaid=$("#area").find("option:selected").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/region/childone.action",
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
function childtwo(){
	 $("#duties").empty();
	var areaid=$("#area").find("option:selected").val();
	var deptid=$("#dept").find("option:selected").val();	
		$.ajax({
			url:"${pageContext.request.contextPath}/region/childtwo.action",
			type:"POST",
			data:{
				areaid:areaid,	
				deptid:deptid		
			},
			dataType:"json",
			success:function(data){
				 var obj='';       			 
				 for(var i=0;i<data.length;i++){     				 
					   var option=data[i];  				   
					   obj +="<option value='"+option.dutiesid+"'>"+option.dutiesname+"</option>";
					  };
					 
					  $("#duties").append(obj);
					  $("#duties").show();//显示职务
					  $("#four").show();//显示职务
			}
		});
	
}
function removeuser(){
	var rows = $('#dg').datagrid('getChecked');
	var userid = rows[0].userid;
	if (rows.length > 1) {
		$.messager.alert('消息', '只能删除一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		$.ajax({
			url : "${pageContext.request.contextPath}/user/removeuser.action",
			type : "post",
			data : {
				userid : userid
			},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$.messager.alert('消息', '操作成功', 'info');
					window.location.href = "${pageContext.request.contextPath}/user/user.action?row=10&page=1";
				} else {
					$.messager.show({
						title : '消息',
						msg : data.message
					});
				}
			}
		});
		
	}
}
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'条件检索'  " style="height: 68px;">
		<div style="float: left; margin-top: 5px; margin-left: 10px;">
			员工账号:${page}<input id="userid" class="easyui-textbox" style="width: 150px" value="${user.userid}"> <a onclick="query()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		</div>
		<div style="float: right; margin-top: 5px; margin-right: 10px;">
		<a onclick="sc()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">文件上传</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
		<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a>
		<a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="removeuser()">删除</a>
		</div>
	</div>
	<div id="dd" class="easyui-dialog" title="文件上传" style="width:400px;height:200px;" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    <form id="form" action="${pageContext.request.contextPath}/user/sc.action" method="post" enctype="multipart/form-data">
    <a href="${pageContext.request.contextPath}/resources/file/user_template.xls">下载模板(excel格式)</a>
    <br>
  <span id="one"> 选择所属区域</span><select  style="width: 150px;" id="area" name="areaid" onblur="childone();">
					<c:forEach items="${areaList}" var="area">
					<option value="${area.areaid}">${area.areaname}</option>
                    </c:forEach >
 </select> 

  <br>
  <span id="two">选择技术方向</span><select  style="width: 150px;" id="technology" name="technologyid">
					
 </select> 
 <br>
 <span id="three">选择所属部门</span><select  style="width: 150px;" id="dept" name="deptid" onblur="childtwo();">
					
 </select> 
  <br>
 <span id="four">选择所属职务</span><select  style="width: 150px;" id="duties" name="dutiesid">
					
 </select>  
  <br>    
    <input name="file" class="easyui-filebox" style="width:300px"><br>
    <a onclick="save()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
    <a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>                              
     </form>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,pagination:true,pagePosition:'bottom',fit:true,checkOnSelect:true,idField:'userid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'userid',width:300">用户账号</th>
<th data-options="field:'username',width:300">用户名称</th>
<th data-options="field:'usersex',width:300">用户性别</th>
<th data-options="field:'userproperties',width:300">全职/兼职</th>
<th data-options="field:'usertravel',width:300">是否出差</th>
<th data-options="field:'userphone',width:300">电话</th>
<th data-options="field:'userqq',width:300">QQ</th>
<th data-options="field:'userwechat',width:300">微信</th>
<th data-options="field:'useremail',width:300">邮箱</th>
<th data-options="field:'areaname',width:300">所属区域</th>
<th data-options="field:'deptname',width:300">所属部门</th>
<th data-options="field:'dutiesname',width:300">职务</th>
<th data-options="field:'leve',width:300">等级</th>
</tr>
</thead>
<tbody>
<c:forEach items="${userList}" var="re">
<tr>
<td></td>
<td>${re.userid }</td>
<td>${re.username }</td>
<td>
<c:choose>
								<c:when test="${re.sex == 0}">男</c:when>
								<c:otherwise>女</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
								<c:when test="${re.properties == 1}">全职</c:when>
								<c:otherwise>兼职</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
								<c:when test="${re.travel == 0}">接受出差</c:when>
								<c:otherwise>不接受出差</c:otherwise>
</c:choose>
</td>
<td>${re.phone }</td>
<td>${re.qq }</td>
<td>${re.wechat }</td>
<td>${re.email }</td>
<td>${re.areaname.areaname }</td>
<td>${re.deptname.deptname }</td>
<td>${re.dutiesname.dutiesname }</td>
<td>
<c:choose>
								<c:when test="${re.level == 0}">初级</c:when>
								<c:when test="${re.level == 1}">中级</c:when>
								<c:otherwise>高级</c:otherwise>
</c:choose>
</td>
</tr>
 </c:forEach >
 </tbody>
</table>
</div>
</body>
</html>