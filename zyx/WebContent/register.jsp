<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List"%>
<%@ page import =" com.zyx.Model.Department"%>
<%@ page import ="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">           
        </style>
         <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
         <script type="text/javascript">
         var boo=false;
         $(function(){
        	$("#wrong").hide();
        	$("#right").hide();
         });
         function checkName(){ //验证账户名格式是否正确
        	 var name=$("#accountname").val();//取到姓名输入框的值
        	 var name_prompt;        	
        	 var nameReg=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;//正则表达式判断格式是否为英文字母和数字组成的4-16位字符，以字母开头 
        	 if(!nameReg.test(name)){
        	  name_prompt="错误，英文字母和数字组成的4-16位字符，以字母开头";
        	  $("#span_name").text(name_prompt);
        	  return false;
        	 }
        	 name_prompt="格式正确";
        	 $("#span_name").text(name_prompt);//向span中输入text
        	 return true;
        	}
         function checkNick()//检查姓名是否输入正确
         {
         	var nick=$("#employeename").val();//取到姓名输入框中的值
         	var nick_prompt;        		
         	var nickReg=/^([\u4e00-\u9fa5]|\w)+$/;//正则表达式判断
         	 var chinaReg = /[\u4e00-\u9fa5]/g;   //匹配中文字符
         	 var len = nick.replace(chinaReg, "ab").length;  //把中文字符转换为两个字母，以计算字符长度
         	if(!nickReg.test(nick)){//判断字符输入错误
         		nick_prompt="错误，包含汉字、字母、数字、下划线的4-20位字符，汉字占两个字符";
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
         function checkPwd(){//检查密码输入是否正确
        		var pwd=$("#password").val();//取到密码输入框中的值
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
        	}
         function checkConfirmPwd(){//检查第二次密码输入是否和第一次一致
        		var confirmPwd=$("#confirm").val();//取确认密码输入框中的值
        		var pwd=$("#password").val();//取密码输入框中的值
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
         function checkEmail(){//检查邮箱格式输入是否正确
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
         function check(){//注册按键判断所有注册信息是否输入正确，正确则继续执行注册，失败则返回更改错误
        	 if(checkName()&&checkNick()&&checkEmail()&&checkPwd()&&checkConfirmPwd()&&checkPhone()){        		 
        		return true;
        		 }else{
        	 return false;
        		 }
          }
        function back(){
        	window.setTimeout(function time(){
        		window.location.href="login.jsp"
        	},1000)
        }
        function checkup(){ 
        	checkrepeat();
            if(check() && boo){
            	$.ajax({     	 
   	   url:"/zyx/home",
   	   type:"POST",
   	   data:{
   		   employeename:$("#employeename").val(),
   		   accountname:$("#accountname").val(),
   		   password:$("#password").val(),
   		   phone:$("#phone").val(),
   		   email:$("#email").val(),
   		   departmentid:$("#department").val()   		  
   	   },
   	   dataType:"text",
   	   success:function(data){    		  
   		   if(data=="true"){
   			   alert("注册成功");
   			   window.location.href="login.jsp";
   		   }else{
   			   alert("注册失败");
   		   }
   	   }
      });}else{
    	  alert("注册信息输入错误");
      }           
        }
        function find(){                         	//注册页，查询下拉列表中的部门信息       
        	var x= document.getElementById("find");
        	x.submit();
        }
        function checkrepeat(){ 
        	 
        	$.ajax({
        		url:"/zyx/rep",
        		type:"POST",
        		data:{
        			username:$("#accountname").val()
        		},
        		dataType:"text",
        		success:function(data){        		
        			if(data=="true"){
        				$("#wrong").hide();
        				$("#right").show();
        				boo=true;
        			}else{
        				$("#wrong").show();
        				$("#right").hide();
        				alert("用户名被占用");
        			}
        		}
                  });            
        }
        </script>
    </head>
    <body>
    <form action="find" method="get" id="find"></form>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
             
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
                    人员管理 > 员工注册
                </div>               
                    <fieldset>
                        <legend>员工信息</legend>
                <%
                Object obj= request.getAttribute("departmentlist");
                List<Department> departmentlist = new ArrayList<Department>();
                if(obj != null){
                	departmentlist = (List<Department>)obj;
                }
                %>
                        <table class="formtable" style="width:95%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" maxlength="20" onblur="checkNick()"/><span id="span_nick"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" id="accountname" maxlength="20" onblur="checkName()" /><span style="color:red" id="wrong">X</span><span style="color:green" id="right">√</span><span id="span_name" ></span>
                             
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" id="password" maxlength="20" placeholder="请输入4位以上的密码" onblur="checkPwd()"/><span id="span_pwd"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="20" onblur="checkConfirmPwd()"/><span id="span_confirmPwd"></span>
                                </td>
                            </tr>
							 <tr>
                                <td>所属部门：</td>
                                <td>
								    <select id="department">
				    <%
                    
                    for(Department department : departmentlist){                   	
                    	out.write("<option value='"+department.getDepartmentid()+"'>"+department.getDepartmentname()+"</option>");                   	
                    	
                    }                                                        
                    %>                                    
									</select><input type="button" onclick="find()" value="显示所有部门">
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" id="phone" maxlength="20" onblur="checkPhone()"/><span id="span_phone"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" id="email" maxlength="20" onblur="checkEmail()"/><span id="span_email"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="注册" onclick="checkup()"/>                                    
                                    <input type="button" value="返回登录页" onclick="back();" class="clickbutton">
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