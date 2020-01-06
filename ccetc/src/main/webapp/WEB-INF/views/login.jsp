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

	function logint(){
		//验证码和输入的是否相同
		var yzm = $("#yzm").val();
		
		$.ajax({
			url:"${pageContext.request.contextPath}/img/imgCode.action",
			type:"POST",
			data:{id:"lilei",name:"hanmeimei"},
			dataType:"text",
			success:function(data){
				if(yzm == data){
					login();
				}else{
					alert("验证码不一致");
				}
			}
		});
	}
	 function getPos(ev){	
	    	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;	
	    	var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft;	
	    	return {x:ev.clientX+scrollLeft,y:ev.clientY+scrollTop}}document.onmousemove = function(ev){	
	    		var oDiv = document.getElementsByTagName('p')	
	    		var oEvent = ev||event;	var pos = getPos(oEvent)	
	    		//后面的div跟这前面的div走	
	    		for(var i = oDiv.length-1; i>0;i--){		
	    			oDiv[i].style.left = oDiv[i-1].offsetLeft+'px';		
	    			oDiv[i].style.top = oDiv[i-1].offsetTop+'px';	}	
	    		//第一个div跟着鼠标走	
	    		oDiv[0].style.left = pos.x+'px';	
	    		oDiv[0].style.top = pos.y+'px'; } 
</script>
<style type="text/css">
.divc{

	width: 10px;

	height: 10px;
	
	background: url(resources/img/jupp.gif);

	position: absolute;

    z-index:10;
    
    pointer-events:none;
}
</style>
</head>

<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>
<p class="divc"></p>

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
					 <img id="imagetool"src="${pageContext.request.contextPath}/img/img.action" border="0" style="margin-bottom: -9px; height: 47px;" onclick="loadImg()"/><br/>
					</cite></li>
					<li><a style="margin-left: 40px;" class="loginbtn" onclick="logint()">登录</a> <a style="margin-left: 30px;" class="loginbtn" onclick="reset()">重置</a></li>
				</ul>
			</div>
	</div>

</body>

</body>
</html>