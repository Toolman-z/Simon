<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>用户添加</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
var boo=false;
$(document).ready(function(){	
	
	$("#technologya").hide();//技术方向隐藏
	$("#depta").hide();//所属部门隐藏
	$("#dutiesa").hide();//所属职务隐藏					
})
function testpwd(){//检查密码输入是否正确
        		var pwd=$("#pwd").val();//取到密码输入框中的值
        		var pwd_prompt;       			
        		 var pwdReg=/^[a-zA-Z0-9]{4,10}$/;//正则表达式判断由英文字母和数字组成的4—10位字符
        		if(!pwdReg.test(pwd)){
        			pwd_prompt="错误，由英文字母和数字组成的4—10位字符";
        			$("#pwdt").text(pwd_prompt);//向span中输入text
        			return false;
        		}else{
        		pwd_prompt="格式正确";
        		$("#pwdt").text(pwd_prompt);//向span中输入text
        		return true;
        		}
        	}
 function checkNick()//检查姓名是否输入正确
         {
         	var nick=$("#realname").val();//取到姓名输入框中的值
         	var nick_prompt;        		
         	var nickReg=/^([\u4e00-\u9fa5]|\w)+$/;//正则表达式判断
         	 var chinaReg = /[\u4e00-\u9fa5]/g;   //匹配中文字符
         	 var len = nick.replace(chinaReg, "ab").length;  //把中文字符转换为两个字母，以计算字符长度
         	if(!nickReg.test(nick)){//判断字符输入错误
         		nick_prompt="错误，请输入包含汉字、字母、数字、下划线的4-20位字符，汉字占两个字符,并且不要包含空格";
         		$("#span_nick").text(nick_prompt);
         		return false;
         	}else
         	if(len<4||len>20){//判断长度输入错误
         		nick_prompt="错误，长度为4－20个字符，一个汉字占两个字符";
         		$("#span_nick").text(nick_prompt);
         		return false;
         	}else{
         	nick_prompt="格式正确";
         	$("#span_nick").text(nick_prompt);
         	return true;}
         }
 function checkQq(){//检查QQ号输入是否是数字
        		var pwd=$("#qq").val();//取到输入框中的值
        		var pwd_prompt;       			
        		 var pwdReg=/^[0-9]{4,10}$/;//正则表达式判断数字组成的4—10位字符
        		if(!pwdReg.test(pwd)){
        			pwd_prompt="错误，由数字组成的4—10位字符";
        			$("#span_pwd").text(pwd_prompt);//向span中输入text
        			return false;
        		}else{
        		pwd_prompt="格式正确";
        		$("#span_pwd").text(pwd_prompt);//向span中输入text
        		return true;
        		}
        	}
 function testemail(){//检查邮箱格式输入是否正确
       	  var email=$("#email").val();//从邮箱输入框中取值
       	  var email_prompt;      		 
       	  var emailReg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;//正则表达式判断邮箱格式是否正确
       	if(!emailReg.test(email)){
       		email_prompt="错误，如hlx@tom.com或者hlx@sina.com.cn";
       	 $("#span_email").text(email_prompt);
       		return false;
       	}else{
       	email_prompt="格式正确";
        $("#span_email").text(email_prompt);//向span中输入text
       	return true;
       	}
         }
  function checkPhone(){//判断手机号输入是否正确
        		var phone=$("#phone").val();//向联系电话输入框中取值
        		var phone_prompt;        			
        		 var phoneReg=/^(13|15|18)\d{9}$/;//正则表达式判断手机号是否由11位数字组成，且以13、15、18开头
        		if(!phoneReg.test(phone)){
        			phone_prompt="错误，手机号由11位数字组成，且以13、15、18开头";
        			$("#span_phone").text(phone_prompt);
        			return false;
        		}else{
        		phone_prompt="格式正确";
        		$("#span_phone").text(phone_prompt);//向span中输入text
        		return true;
        		}
        	}
function add() {

	var name=$("#dutiesname").val();//取到填写的用户名	
	var realname=$("#realname").val();//取到填写的姓名
	var phone=$("#phone").val();//取到填写的电话
	var wechat=$("#wechat").val();//取到填写的微信
	var email=$("#email").val();//取到填写的邮箱
	var qq=$("#qq").val();//取到填写的邮箱
	var password=$("#password").val();//取到填写的密码
	var areaid=$("#area").find("option:selected").val();//取到选择的区域
	var deptid=$("#dept").find("option:selected").val();//取到选择的部门
	var dutiesid=$("#duties").find("option:selected").val();//取到选择的职务
	var sex=$("#sex").find("option:selected").val();//取到选择的性别
	var properties=$("#properties").find("option:selected").val();//取到选择的性质
	var level=$("#level").find("option:selected").val();//取到选择的等级
	var travel=$("#travel").find("option:selected").val();//取到选择的出差
	var technology=$("#technology").find("option:selected").val();//取到选择的技术方向
	var role=$("#role").find("option:selected").val();//取到选择的角色
	if(realname == ""){
		alert("请填写姓名");
	}else if(phone == ""){
		alert("请填写电话");
	}else if(wechat == ""){
		alert("请填写微信");
	}else if(email == ""){
		alert("请填写邮箱")
	}else if(qq == ""){
		alert("请填写QQ")
	}else if(password == ""){
		alert("请填写密码")
	}else{
		//注册按键判断所有注册信息是否输入正确，正确则继续执行注册，失败则返回更改错误
   	 if(checkNick()&&testpwd()&&checkQq()&&testemail()&&checkPhone()){        		 
   		
   		
 		
   		$.ajax({
   			url:"${pageContext.request.contextPath}/user/adduser.action?row=10&page=1",
   			type:"POST",
   			data:{			
   				userid:name,
   				username:realname,
   				phone:phone,
   				wechat:wechat,
   				email:email,
   				qq:qq,
   				areaid:areaid,
   				deptid:deptid,
   				dutiesid:dutiesid,
   				sex:sex,
   				properties:properties,
   				level:level,
   				travel:travel,
   				technologyid:technology,
   				roleid:role
   			},
   			dataType:"json",
   			success:function(data){
   				if (data.success) {
   				
   					window.location.href = "${pageContext.request.contextPath}/user/user.action?row=10&page=1";			
   				} else {
   					$.messager.show({
   						title : '消息',
   						msg : data.message
   					});				
   				}
   			}
   		});
   		 
   		 
   		 }else{
   	alert("请完善信息");
   		 }
	
	}
}
function testname(){
	var name=$("#dutiesname").val();	
	if(name != ""){
	$.ajax({
		url:"${pageContext.request.contextPath}/user/testusername.action?row=10&page=1",
		type:"POST",
		data:{			
			userid:name
		},
		dataType:"json",
		success:function(data){
			if (data.success) {
			
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
		alert("请输入用户名");
	}
}
function childone(){
	 $("#dept").empty();
	 $("#duties").empty();
	 childthree();
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
				  
					$("#depta").show();//所属部门显示
					$("#dutiesa").hide();//所属职务隐藏	
		}
	});
}
function childtwo(){
	 $("#duties").empty();
	var areaid=$("#area").find("option:selected").val();
	var deptid=$("#dept").find("option:selected").val();
	if(deptid == null){
		alert("请选择部门");
	}else{
		$.ajax({
			url:"${pageContext.request.contextPath}/region/childtwo.action?row=10&page=1",
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
						$("#dutiesa").show();//所属职务隐显示
			}
		});
	}
}
function childthree(){
	 $("#technology").empty();
	 var areaid=$("#area").find("option:selected").val();
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
					  $("#technologya").show();//技术方向显示
			}
		});
}
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/user/user.action?row=10&page=1";
}
</script>
</head>
<body>
<table>

	<tr>
			<td>电话</td>
			<td><input id="phone" name="role"   style="width: 150px"  onblur="checkPhone()"><span id="phone"></span><span id="span_phone"></span></td>					

</tr>
<tr>
			<td>微信</td>
			<td><input id="wechat" name="role"   style="width: 150px"  onblur="testwechat()"></td>
		</tr>
			<tr>
			<td>邮箱</td>
			<td><input id="email" name="role"   style="width: 150px"  onblur="testemail()"><span id="span_email"></span></td>					
		    </tr>
		<tr>
		    <td>QQ</td>
			<td><input id="qq" name="role"   style="width: 150px"  onblur="checkQq()"><span id="span_pwd"></span></td>							
		</tr>
		<tr>
		 <td>姓名</td>
			<td><input id="realname" name="role"   style="width: 150px"  onblur="checkNick()"><span id="span_nick"></span></td>							
		</tr>
		
		<tr>
			<td>用户账号</td>
			<td><input id="dutiesname" name="role"   style="width: 150px"  onblur="testname()"></td>		
			</tr>
<tr>
			<td>密码</td>
			<td><input id="pwd" name="role"   style="width: 150px"  onblur="testpwd()"><span id="pwdt"></span></td>
		</tr>
		<tr>
		<td>性别</td>
			<td><select  style="width: 150px;" id="sex" >
					<option value="0" selected = "selected">男</option>
					<option value="1">女</option>
			</select></td>
		
			</tr>
		<tr>
			<td>性质</td>
			<td><select  style="width: 150px;" id="properties" >
					<option value="1" selected = "selected">全职</option>
					<option value="0">兼职</option>
			</select></td>
			</tr>
		<tr>	
			<td>出差</td>
			<td><select  style="width: 150px;" id="travel" >
					<option value="0" selected = "selected">是</option>
					<option value="1">否</option>
			</select></td>
		</tr>
		<tr>
			<td>等级</td>
			<td><select  style="width: 150px;" id="level" >
					<option value="0" selected = "selected">初级</option>
					<option value="1">中级</option>
					<option value="2">高级</option>
			</select></td>	
			
		</tr>
		
	
		<tr>
			<td>角色</td>
			<td><select  style="width: 150px;" id="role" >
					<c:forEach items="${roleList}" var="re">
					<option value="${re.roleid}">${re.role}</option>
                    </c:forEach >
			</select></td>			
		
		</tr>		
		<tr>
			<td>所属区域</td>
			<td><select  style="width: 150px;" id="area" onblur="childone()">
					<c:forEach items="${List}" var="re">
					<option value="${re.areaid}">${re.areaname}</option>
                    </c:forEach >
			</select></td>
			</tr>
			<tr id="technologya">
			<td>技术方向</td>
			<td><select  style="width: 150px;" id="technology" >
					
			</select></td>
			</tr>
		<tr id="depta">		
			<td>所属部门</td>
			<td><select  style="width: 150px;" id="dept" onblur="childtwo()">
					
			</select></td>
		</tr>
		<tr  id="dutiesa">
			<td>所属职务</td>
			<td><select  style="width: 150px;" id="duties" >
					
			</select></td>	
			
		</tr>
		
		
		<tr>
			<td><a onclick="add()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a></td>
			<td><a onclick="cancel()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a></td>
		</tr>
	</table>
</body>
</html>