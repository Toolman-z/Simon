<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
<jsp:include page="inc.jsp"></jsp:include>
<script>
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
	
	function login(){
		$.ajax({
			url:"${pageContext.request.contextPath}/user/login.action",
			type:"post",
			data:{
				userid:$("#userid").val(),
				password:$("#password").val()
			},
			dataType:"json",
			success:function(data){
				if(data.success){
					window.location.href="${pageContext.request.contextPath}/index.action";
				}else{
					$.messager.show({
						title:'消息',
						msg:data.message
					});
				}
			}
		});
	}
	
	function reset(){
		$("#userid").val("");
		$("#password").val("");
		$("#yzm").val("");
	}
	
	function loadImg(){
		$("#imagetool").attr("src","${pageContext.request.contextPath}/img/img.action?r="+Math.random());
	}
</script>
</head>
<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/resources/img/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎使用教务管理系统</span>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>
			<div class="loginbox loginbox1">

				<ul>
					<li><input type='text' class="loginuser" id="userid" name='userid' value="" /></li>
					<li><input class="loginpwd" id="password" type='password' name='password' value="" maxlength="16" /></li>
					<li class="yzm"><span><input type="text" id="yzm" name="yzm" maxlength="4" value="验证码" onclick="JavaScript:this.value=''" /> </span> <cite>
					 <img id="imagetool" src="${pageContext.request.contextPath}/img/img.action" border="0" style="margin-bottom: -9px; height: 47px;" onclick="loadImg()" /><br />
					</cite></li>
					<li><a style="margin-left: 40px;" class="loginbtn" onclick="login()">登录</a> <a style="margin-left: 30px;" class="loginbtn" onclick="reset()">重置</a></li>
				</ul>
			</div>
	</div>

</body>

</body>
</html>