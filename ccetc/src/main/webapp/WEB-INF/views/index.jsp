<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript" src="resources/jS/jquery-3.0.0.js"></script>
<title></title>
<script>
	function menu(title, url) {
		$("#iframe").attr("src", '${pageContext.request.contextPath}' + url);
		$('#cc').panel('setTitle', title);
	}
	function changepwd(title, url) {
		$("#iframe").attr("src", '${pageContext.request.contextPath}' + url);
		$('#cc').panel('setTitle', title);
	}
	function logout() {
		window.location.href = "${pageContext.request.contextPath}/logout.action";
	}
	function showTime() {
		var myDate = new Date();
		var year = myDate.getFullYear();
		var month = myDate.getMonth() + 1;
		var day = myDate.getDate();
		var hours = myDate.getHours();
		var minutes = myDate.getMinutes();
		var secound = myDate.getSeconds();
		if (day < 10) {
			day = "0" + day;
		}
		if (hours < 10) {
			hours = "0" + hours;
		}
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		if (secound < 10) {
			secound = "0" + secound;
		}
		document.getElementById("a").innerText = "北京时间：" + year + "年" + month
				+ "月" + day + "日" + hours + ":" + minutes + ":" + secound;
		setTimeout("showTime()", 1000);
	}
	$(document).ready(function() {
		showTime();
	})
	var isinter;
	var millisec = 25;//定时器间隔执行时间/毫秒		
	var xflo = 0; //漂浮层x坐标		
	var yflo = 0; //漂浮层y坐标		
	var yistop = false;
	var xisleft = true;
	function floatadfun() {
		kwidth = $(window).width();//可视区域宽度			
		kheight = $(window).height();//可视区域高度 			
		divwidth = $('#floatdivids').width();//div漂浮层宽度			
		divheight = $('#floatdivids').height();//div漂浮层高度 			
		hstop = jQuery(window).scrollTop();//滚动条距离顶部的高度			
		wsleft = jQuery(window).scrollLeft();//滚动条距离最左边的距离 			
		offwidth = (kwidth - divwidth);//div偏移的宽度			
		offheight = (kheight - divheight);//div偏移的高度 			
		if (!yistop) {
			yflo++;
			if (yflo >= offheight) {
				yistop = true;
			}
		} else {
			yflo--;
			if (yflo <= 0) {
				yistop = false;
			}
		}
		if (xisleft) {
			xflo++;
			if (xflo >= offwidth) {
				xisleft = false;
			}
		} else {
			xflo--;
			if (xflo <= 0) {
				xisleft = true;
			}
		}
		$('#floatdivids').css({
			'top' : yflo + hstop,
			'left' : xflo + wsleft
		}); /* 如果使用固定定位，请把加上滚动条的距离去掉即可 */
		
	}
	
	
	function floatadfuns() {
		kwidth = $(window).width();//可视区域宽度			
		kheight = $(window).height();//可视区域高度 			
		divwidth = $('#floatdivid').width();//div漂浮层宽度			
		divheight = $('#floatdivid').height();//div漂浮层高度 			
		hstop = jQuery(window).scrollTop();//滚动条距离顶部的高度			
		wsleft = jQuery(window).scrollLeft();//滚动条距离最左边的距离 			
		offwidth = (kwidth - divwidth);//div偏移的宽度			
		offheight = (kheight - divheight);//div偏移的高度 			
		if (!yistop) {
			yflo++;
			if (yflo >= offheight) {
				yistop = true;
			}
		} else {
			yflo--;
			if (yflo <= 0) {
				yistop = false;
			}
		}
		if (xisleft) {
			xflo++;
			if (xflo >= offwidth) {
				xisleft = false;
			}
		} else {
			xflo--;
			if (xflo <= 0) {
				xisleft = true;
			}
		}
		$('#floatdivid').css({
			'top' : yflo + hstop,
			'right' : xflo + wsleft
		}); /* 如果使用固定定位，请把加上滚动条的距离去掉即可 */
		
	}
	$(function() {
		isinter = setInterval("floatadfuns()", millisec);
		$('#floatdivid').mouseover(function() {
			clearInterval(isinter);
		}).mouseout(function() {
			isinter = setInterval("floatadfuns()", millisec);
		});	
		$('#ClickRemoveFloo').click(function() {
			$(this).parents("#floatdivid").slideUp(500, function() {
				clearInterval(isinter);
				$(this).remove();
			});
		});
	});
	$(function() {
		isinter = setInterval("floatadfun()", millisec);
		$('#floatdivids').mouseover(function() {
			clearInterval(isinter);
		}).mouseout(function() {
			isinter = setInterval("floatadfun()", millisec);
		});
		$('#ClickRemoveFlo').click(function() {
			$(this).parents("#floatdivids").slideUp(500, function() {
				clearInterval(isinter);
				$(this).remove();
			});
		});
	});
	
	
	//获取随机整数函数
    function rand(m,n){
             return Math.floor(Math.random() * (n - m + 1)) + m;
    }
    function setStyle(snowDiv){
             snowDiv.innerHTML = "新年快乐❤";           
             snowDiv.style.color = "red";
             snowDiv.style.position = "absolute";
             snowDiv.style.left = rand(0,document.documentElement.clientWidth || document.body.clientWidth) + 'px';
             snowDiv.style.top = rand(0,400) + 'px';
             snowDiv.style.fontSize = rand(30,40) + 'px';
             snowDiv.style.opacity = Math.random();
             document.body.appendChild(snowDiv);
    }
    //周期性创建雪花
    setInterval(function(){
             var snowDiv = document.createElement('div');
             setStyle(snowDiv);

             //设置雪花飘落的步径
             var step = 100;
             var run = setInterval(function(){
                     var newTop = snowDiv.offsetTop + step;
                     if(newTop  >= document.documentElement.clientHeight || document.body.clientHeight){
                              document.body.removeChild(snowDiv);
                              clearInterval(run);
                     }
                     snowDiv.style.top = newTop + 'px';
             },300)
    },200)
    
   
    	
    
    	
</script>
<style type="text/css">
  
.divc{

	width: 20px;

	height: 20px;

	background: url(resources/img/jupp.gif);

	position: absolute;

    z-index:10;
    
     pointer-events:none;
}

#floatdivids {
                font-weight: 600;
                font-size: 28px;
                font-family: "黑体";
                color: #8c888b;
                background: -webkit-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -moz-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -ms-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                color: transparent;
                /*设置字体颜色透明*/
                -webkit-background-clip: text;
                /*背景裁剪为文本形式*/
                animation: ran 6s linear infinite;
                /*动态6s展示*/
            }
            
#floatdivid {
                font-weight: 600;
                font-size: 28px;
                font-family: "黑体";
                color: #8c888b;
                background: -webkit-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -moz-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -ms-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                color: transparent;
                /*设置字体颜色透明*/
                -webkit-background-clip: text;
                /*背景裁剪为文本形式*/
                animation: ran 6s linear infinite;
                /*动态6s展示*/
            }

#a {
                font-weight: 600;
                font-size: 28px;
                font-family: "黑体";
                color: #8c888b;
                background: -webkit-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -moz-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                -ms-linear-gradient(45deg, #70f7fe, #fbd7c6, #fdefac, #bfb5dd, #bed5f5);
                color: transparent;
                /*设置字体颜色透明*/
                -webkit-background-clip: text;
                /*背景裁剪为文本形式*/
                animation: ran 3s linear infinite;
                /*动态1s展示*/
            }
            @keyframes ran {
                from {
                    backgroud-position: 0 0;
                }
                to {
                    background-position: 2000px 0;
                }
            }

#floatdivids {
	width: 200px;
	height: 200px;
	position: absolute;
	top: 0;
	left: 0;
	background: url(resources/img/jup.gif);
	z-index: 1000;
	border: 1px solid #ccc;
}
#floatdivid {
	width: 200px;
	height: 200px;
	position: absolute;
	top: 0;
	right: 0;
	background: url(resources/img/jup.png);
	z-index: 1000;
	border: 1px solid #ccc;
}
</style>
</head>
<body class="easyui-layout">


	<div data-options="region:'north'" style="height: 60px;">
		<div style="float: left;">
			<img src="resources/img/logo.png" />
		</div>

		<div style="margin-top: 28px; float: right;">${user.username}，欢迎您！
			<a href="javascript:void(0)" id="mb" class="easyui-menubutton"
				data-options="menu:'#mm',iconCls:'icon-edit'">设置</a>
			<div id="mm" style="width: 150px;">
				<div data-options="iconCls:'icon-lock'"
					onclick="changepwd('修改密码','/user/changepwd.action?row=10&page=1')">修改密码</div>
				<div class="menu-sep"></div>
				<div data-options="iconCls:'icon-back'" onclick="logout()">退出系统</div>
			</div>

		</div>
		<div id="a"
			style="font-size: 40px; width: 950px; height: 50px; float: right;">
		</div>
	</div>
	<div data-options="region:'south'" style="height: 25px;">
		<div align="center">中软国际 &copy; 2000-2022 中软国际有限公司, 保留一切权利 隐私保护 | 法律声明  京ICP备05028939号 京公安备11010802014778号</div>
	</div>
	<div data-options="region:'west',title:'菜单导航',collapsible:false" style="width: 150px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach items="${menuList}" var="auth">
				<div title="${auth.authname}">
					<ul class="easyui-tree">
						<c:forEach items="${auth.children}" var="au">
							<li>
								<div
									onclick="menu('${auth.authname}>${au.authname}','${au.url}')">
									<span>${au.authname}</span>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div id="cc" data-options="region:'center',title:'内容',collapsible:false" style="background: url(resources/img/bac.png);">
		<div style=" pointer-events:none;z-index:10;width=100%;height=100%;">
			</div>	
		<iframe id="iframe" src="" width="100%" height="100%"
			style="border: 0px;z-index:1;">
			
			</iframe>	
				
	</div>
	<div id="floatdivids">
			<span id="ClickRemoveFlo"
				style="position: absolute; top: 0; right: 0; background-color: rgba(140,140,140, 0.2); padding: 0 5px; cursor: pointer;">X</span>			
		</div>
		<div id="floatdivid">
			<span id="ClickRemoveFloo"
				style="position: absolute; top: 0; right: 0; background-color: rgba(140,140,140, 0.2); padding: 0 5px; cursor: pointer;">X</span>			
		</div>
</body>
</html>