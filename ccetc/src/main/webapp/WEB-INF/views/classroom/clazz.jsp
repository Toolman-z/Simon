<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>开班管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
var boo=false;
var time=false;
$(document).ready(function(){	
	$("#peopler").hide();//隐藏人数
	$("#roleoner").hide();//隐藏讲师
	$("#roletwor").hide();//隐藏助教
	$("#rolethreer").hide();//隐藏班主任
	$("#technologyr").hide();//隐藏技术方向
	$("#classroomr").hide();//隐藏教室
	
})
function add() {
	var num=$("#people").val();//取到填写的人数
	var numb=parseInt(num);
	var startdate=$("#startdate").val();//取到填写的开始时间
	var starttime=new Date(startdate);
	var enddate=$("#enddate").val();//取到填写的结束时间
	var endtime=new Date(enddate);
	var areaid=$("#area").find("option:selected").val();//取到选择的区域
	var teacher=$("#roleone").find("option:selected").val();//取到选择的讲师
	var assistant=$("#roletwo").find("option:selected").val();//取到选择的助教
	var clazzmaster=$("#rolethree").find("option:selected").val();//取到选择的班主任	
	var properties=$("#clazzmaster").find("option:selected").val();//取到选择的班级性质
	var classroomid=$("#classroom").find("option:selected").val();  //取到选择的教室
	var c=parseInt(classroomid);
	var technology=$("#technology").find("option:selected").val();//取到选择的技术方向
	
	//转换类型
	checkmore();
	testpeople();
	if(num == ""){
		alert("请填写人数");
	}else if(startdate == ""){
		alert("请填写开始时间");
	}else if(enddate == ""){
		alert("请填写结束时间");
	}else if(areaid == ""){
		alert("请选择区域");
	}else if(teacher == ""){
		alert("请选择讲师");
	}else if(assistant == ""){
		alert("请选择助教");
	}else if(clazzmaster == ""){
		alert("请选择班主任");
	}else if(properties == ""){
		alert("请选择班级性质");
	}else if(classroomid == ""){
		alert("请选择教室");
	}else if(technology == ""){
		alert("请选择技术方向");
	}else if(boo && time){		
		$.ajax({
			url:"${pageContext.request.contextPath}/classroom/addclazz.action?row=10&page=1 ",
			type:"POST",
			data:{			
				count:numb,
				startdate:starttime,
				enddate:endtime,
				areaid:areaid,
				properties:properties,
				teacher:teacher,
				assistant:assistant,
				clazzmaster:clazzmaster,
				technologyid:technology,
				classroomid:c		
			},
			dataType:"json",
			success:function(data){
				if (data.success) {
				alert("开班成功");
					window.location.href = "${pageContext.request.contextPath}/classroom/clazz.action?row=10&page=1";			
				} else {
					$.messager.show({
						title : '消息',
						msg : data.message
					});				
				}
			}
		});
	}else{
		alert("请正确填写信息");
	}
}
function testpeople(){
	var numtest=/^[0-9]*$/;//正则判断是否是数字  	
	var num=$("#people").val();
	var contain=$("#contain").text();
	if(num != ""){
		if(numtest.test(num)){
	if(parseInt(num)<=parseInt(contain)){
		return boo=true;
	}else{
		alert("人数超过范围");
		return boo=false;
	}
		}else{
			alert("请输入数字");
			return boo=false;
		}
	}else{
		alert("请输入人数");
		return boo=false;
	}
}
function childthree(){
	 $("#classroom").empty();
		var starttime=$("#startdate").val();
		var endtime =$("#enddate").val();
	var areaid=$("#area").find("option:selected").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/classroom/childthree.action?row=10&page=1",
		type:"POST",
		data:{
			areaid:areaid
		
		},
		dataType:"json",
		success:function(data){
			 var obj='';       			 
			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +="<option value='"+option.classroomid+"'>"+option.calssroomname+"</option>";
				  };
				 
				  $("#classroom").append(obj);
		}
	});
}
function childtwo(){
	 $("#roleone").empty();
	var technologyid=$("#technology").find("option:selected").val();
	var areaid=$("#area").find("option:selected").val();	
		$.ajax({
			url:"${pageContext.request.contextPath}/user/childtwo.action?row=10&page=1",
			type:"POST",
			data:{
				areaid:areaid,	
				technologyid:technologyid		
			},
			dataType:"json",
			success:function(data){
				 var obj='';       			 
				 for(var i=0;i<data.length;i++){     				 
					   var option=data[i];  				   
					   obj +="<option value='"+option.userid+"'>"+option.username+"</option>";
					  };
					 
					  $("#roleone").append(obj);
					  $("#peopler").hide();//隐藏人数
						$("#roleoner").show();//显示讲师
						$("#roletwor").show();//显示助教
						$("#rolethreer").show();//显示班主任						
						$("#classroomr").show();//显示教室
			}
		});
		childfive();
		childfour();
	
}
function childfour(){
	 $("#roletwo").empty();
		var technologyid=$("#technology").find("option:selected").val();
		var areaid=$("#area").find("option:selected").val();		
			$.ajax({
				url:"${pageContext.request.contextPath}/user/childfour.action?row=10&page=1",
				type:"POST",
				data:{
					areaid:areaid,	
					technologyid:technologyid		
				},
				dataType:"json",
				success:function(data){
					 var obj='';       			 
					 for(var i=0;i<data.length;i++){     				 
						   var option=data[i];  				   
						   obj +="<option value='"+option.userid+"'>"+option.username+"</option>";
						  };
						 
						  $("#roletwo").append(obj);
				}
			});
}
function childfive(){
	 $("#rolethree").empty();
		var technologyid=$("#technology").find("option:selected").val();
		var areaid=$("#area").find("option:selected").val();
		
			$.ajax({
				url:"${pageContext.request.contextPath}/user/childfive.action?row=10&page=1",
				type:"POST",
				data:{
					areaid:areaid,	
					technologyid:technologyid		
				},
				dataType:"json",
				success:function(data){
					 var obj='';       			 
					 for(var i=0;i<data.length;i++){     				 
						   var option=data[i];  				   
						   obj +="<option value='"+option.userid+"'>"+option.username+"</option>";
						  };
						 
						  $("#rolethree").append(obj);
				}
			});
}
function childone(){
	var starttime=$("#startdate").val();
	var endtime =$("#enddate").val();
	if (starttime == ""){
		alert("请先选择开始时间");
	}else if(endtime == ""){
		alert("请选择结束时间");
	}else{
	
	 $("#technology").empty();
	 var areaid=$("#area").find("option:selected").val();
	 childthree();
	 $.ajax({
			url:"${pageContext.request.contextPath}/region/childthree.action?row=10&page=1",
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
					 
					  $("#technology").append(obj);
					  $("#peopler").hide();//隐藏人数
						$("#roleoner").hide();//隐藏讲师
						$("#roletwor").hide();//隐藏助教
						$("#rolethreer").hide();//隐藏班主任
						$("#technologyr").show();//显示技术方向
						$("#classroomr").hide();//隐藏教室
			}
		});
}
}
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/classroom/clazz.action?row=10&page=1";
}
function checkmore(){
	   var d = new Date();
	   d=d.getFullYear()+"-" + (d.getMonth()+1) + "-" + d.getDate();
	   var starttime=$("#startdate").val();
	   var endtime=$("#enddate").val();
	 
	   alert(starttime);
	   if(starttime > endtime){
		   alert("开始时间大于结束时间,请重新填写");
		   return time=true;
	   }else if(starttime < d){
		   alert("预定时间小于当前日期");
	   } else{
		   return time=true;
	   }
}
function selectcontain(){
	 $("#contain").empty();
	var classroomid=$("#classroom").find("option:selected").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/classroom/testpeople.action?row=10&page=1",
		type:"POST",
		data:{			
			classroomid:classroomid
		},
		dataType:"json",
		success:function(data){
			 var obj='';       			 
			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +=""+option.contain+"";
				  };
				 
				  $("#contain").append(obj);
				  $("#peopler").show();//显示人数
					
		}
	});
}
</script>
</head>
<body>
<table>
<tr>
<td style="width:70px;">班级性质:</td>
			<td><select  style="width: 150px;" id="clazzmaster" >					
					<option value="0">就业</option>
					<option value="1">非就业</option>                  
			</select></td>
</tr>
        <tr>
		<td style="width:70px;">开班日期:</td>
			<td><input id="startdate" name="role" type="date"  style="width: 150px"  onblur="testemail()"><span id="email"></span></td>							    		
		</tr>
			<tr>
			<td style="width:70px;">结束日期:</td>
			<td><input id="enddate" name="role"  type="date" style="width: 150px"  onblur="testqq()"><span id="email"></span></td>							
		</tr>		
		<tr>
			<td style="width:70px;">所属区域:</td>
			<td><select  style="width: 150px;" id="area" onblur="childone()">
					<c:forEach items="${List}" var="re">
					<option value="${re.areaid}">${re.areaname}</option>
                    </c:forEach >
			</select></td>								
		</tr>
		<tr id="technologyr">
		<td style="width:70px;">技术方向:</td>
			<td><select  style="width: 150px;" id="technology" onblur="childtwo()" >
					
			</select></td>
		</tr>
		
		<tr id="roleoner">
		<td style="width:70px;">讲师:</td>
			<td><select  style="width: 150px;" id="roleone" >
					
			</select></td>			
		</tr>
		<tr id="roletwor">			
			<td style="width:70px;">助教:</td>
			<td><select  style="width: 150px;" id="roletwo" >					
			</select></td>			
		</tr>			
		<tr id="rolethreer">							
			<td style="width:70px;">班主任:</td>
			<td><select  style="width: 150px;" id="rolethree" >					
			</select></td>
		</tr>			
		<tr id="classroomr">						
		 <td style="width:70px;">教室:</td>
			<td><select  style="width: 150px;" id="classroom" onblur="selectcontain()">
					
			</select><span>容纳人数：</span><span id="contain"></span></td>
		</tr>
		<tr id="peopler">
		<td style="width:70px;">人数:</td>
			<td><input id="people" name="role"   style="width: 150px"  onblur="testpeople()"><span id="email"></span></td>							    
		</tr>
		<tr>
			<td><a onclick="add()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">重置</a></td>
		</tr>
	</table>
</body>
</html>