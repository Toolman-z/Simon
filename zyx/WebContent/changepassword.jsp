<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
         <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
      	  var you=${user.employeeid};
      	  $.ajax({
      		  url:"/zyx/who",
      		  type:"POST",
      		  data:{
      			  you:you
      		  },
      		  dataType:"json",
      		  success:function(data){
      			  var obj='';       			 
       			 for(var i=0;i<data.length;i++){     				 
      				   var option=data[i];  				   
      				   obj +="<span>"+option.realname+"</span>";
      				  };
      				  $("#who").append(obj);
      		  }
      	  });
        });
 /*        function checkPwdold(){//检查密码输入是否正确
    		var pwd=$("#old").val();//取到密码输入框中的值
    		var pwd_prompt;       			
    		 var pwdReg=/^[a-zA-Z0-9]{4,10}$/;//正则表达式判断由英文字母和数字组成的4—10位字符
    		if(!pwdReg.test(pwd)){
    			pwd_prompt="错误，由英文字母和数字组成的4—10位字符";
    			$("#span_pwd").text(pwd_prompt);//向span中输入text
    			return false;
    		}else{
    		pwd_prompt="格式正确";
    		$("#span_pwd").text(pwd_prompt);//向span中输入text
    		return true;
    		}
    	} */
        function checkPwdnew(){//检查密码输入是否正确
    		var pwd=$("#new").val();//取到密码输入框中的值
    		var pwd_prompt;       			
    		 var pwdReg=/^[a-zA-Z0-9]{4,10}$/;//正则表达式判断由英文字母和数字组成的4—10位字符
    		if(!pwdReg.test(pwd)){
    			pwd_prompt="错误，由英文字母和数字组成的4—10位字符";
    			$("#span_pwdnew").text(pwd_prompt);//向span中输入text
    			return false;
    		}else{
    		pwd_prompt="格式正确";
    		$("#span_pwdnew").text(pwd_prompt);//向span中输入text
    		return true;
    		}
    	}
        function checkConfirmPwd(){//检查第二次密码输入是否和第一次一致
    		var confirmPwd=$("#again").val();//取确认密码输入框中的值
    		var pwd=$("#new").val();//取密码输入框中的值
    		var confirmPwd_prompt;        		
    		if(pwd!=confirmPwd){//判断两次取值是否相等
    			confirmPwd_prompt="错误，两次输入的密码不一致";
    			$("#span_confirmPwd").text(confirmPwd_prompt);//向span中写入text
    			return false;
    		}else{
    		confirmPwd_prompt="密码正确";
    		$("#span_confirmPwd").text(confirmPwd_prompt);//向span中写入text
    		return true;
    		}
    	}
        function checksame(){        	
        	var old=${user.password};
        	var now=$("#old").val();
        	var t;
        	var f;
        	if(old == now){
        		t="通过";
        		$("#tf").text(t);//向span中写入text
        		return true;
        	}else{
        		f="与原密码不一致";
        		$("#tf").text(f);//向span中写入text
        		return false;
        	}        	
        	}
        function changepwd(){
        	if(checkPwdnew() && checkConfirmPwd() && checksame()){
        		var re=confirm("你确定要修改吗");
        		var id=${user.employeeid};
        		$.ajax({
        			url:"/zyx/who",
        			type:"GET",
        			data:{
        				id:id,
        				pwd:$("#new").val()
        			},
        			dataType:"text",
        			success:function(data){
        				if(data == "true"){
        					alert("修改成功");
        				}else{
        					alert("修改失败");
        				}
        			}
        		});
        	}else{
        	alert("请正确输入信息");
        	}
        }
        </script>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong id="who"></strong>
                <a href="changepassword.jsp">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li></c:if>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li></c:if>
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li></c:if>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li></c:if>
                        <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    修改密码
                </div>
                
                    <fieldset>
                        <legend>修改密码信息</legend>
                        <table class="formtable" style="width:80%">
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="old" type="password" onblur="checksame()"/></span><span id="tf"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>新密码:</td>
                                <td>
                                    <input id="new" type="password" onblur="checkPwdnew()" /><span id="span_pwdnew"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>确认新密码：</td>
                                <td>
                                    <input id="again" type="password" onblur="checkConfirmPwd()"/><span id="span_confirmPwd"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton" onclick="changepwd()"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>